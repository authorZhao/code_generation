package com.git;

import com.cube.protocol.*;
import com.git.proto.InClass;
import com.git.proto.InField;
import com.git.proto.OutClass;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author authorZhao
 * @since 2022-05-10
 */
public class TestProto {


    public static void main(String[] args) throws Exception {

        Map<String,String> map = new HashMap<>();
        Set<OutClass> outClasses = genAllClass();
        outClasses.forEach(i->{
            String name = i.getName();
            map.put(i.getClazz().getName(),i.getName());

            List<InClass> innerClassList = i.getInnerClassList();
            if(innerClassList==null)return;
            innerClassList.forEach(in->{
                String allClassName = in.getClazz().getName();
                String newName = i.getAllName()+"$"+in.getClazz().getSimpleName();
                map.put(allClassName,newName);
            });
        });


        outClasses.forEach(i->{
            try {
                List<InClass> innerClassList = i.getInnerClassList();
                if(innerClassList==null){
                    i.setInnerClassList(Collections.emptyList());
                }
                innerClassList.forEach(in->{
                    Set<InField> inFieldSet = in.getInFieldSet();
                    if(inFieldSet==null){
                        inFieldSet = Collections.emptySet();
                        in.setInFieldSet(inFieldSet);
                    }
                    inFieldSet.forEach(field->{
                        String fieldName = field.getName();
                        if(fieldName.startsWith("List<")){
                            fieldName = fieldName.substring(5,fieldName.length()-1);
                        }
                        if(map.containsKey(fieldName)){
                            String s = map.get(fieldName);
                            if(s.startsWith(i.getAllName())){
                                s = s.substring(i.getAllName().length()+1);
                                field.setJavaType("List<"+s+">");
                            }else {
                                field.setJavaType("List<"+map.get(fieldName)+">");
                            }
                        }
                    });
                });
                genJavaFile(i);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }


    private static Set<OutClass> genAllClass() throws IOException {
        Set<OutClass> outClassesSet = new HashSet<>();
        List<Class> classList = List.of(ActivityProto.class,AssetsProto.class,CertificateProto.class,ClockProto.class,CodeProto.class,CompeteMultiTeamProto.class,CompeteQualifierProto.class,CompeteSelfBuildProto.class,CompetitionProto.class,CubeProto.class,CustomAvatarProto.class,DiscussProto.class,EnumProtocol.class,GoalProto.class,LeagueProto.class,LoginProto.class,MatchProto.class,MessageProto.class,MiscProto.class,PlayerProto.class,RankProto.class,RelationProto.class,ReviewProto.class,TrainingProto.class);
        classList.forEach(i->{
            List<InClass> inClassList =
                    Arrays.stream(i.getClasses())
                            .filter(TestProto::filterInnerClass).
                            map(TestProto::getInClass).collect(Collectors.toList());
            OutClass outClass = new OutClass().setName(OutClass.getOutName(i.getName()))
                    .setAllName(OutClass.getAllOutName(i.getName()))
                    .setClazz(i).setInnerClassList(inClassList);
            outClassesSet.add(outClass);
        });
        return outClassesSet;
    }

    /**
     * 生成javaclass
     * @throws IOException
     */
    private static void genJavaFile(OutClass outClasses) throws IOException {
        TemplateEngine templateEngine = new TemplateEngine();
        Context context = new Context();
        context.setVariable("outClass",outClasses);
        context.setVariable("author","authorZhao");
        context.setVariable("date", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
        String template = FileUtils.readFileToString(new File("E:\\java\\workspace\\space2\\code_generation\\src\\main\\resources\\templates\\proto.th"), StandardCharsets.UTF_8);
        String outPutPath = "C:\\Users\\Admin\\Desktop\\工作文档\\worknote\\java\\"+outClasses.getName()+".java";
        FileWriter fileWriter = new FileWriter(outPutPath);
        templateEngine.process(template, context,fileWriter);
    }


    /**
     * 获取内部类
     * @param i
     * @return
     */
    private static InClass getInClass(Class<?> i) {
        Field[] declaredFields = i.getDeclaredFields();
        Set<InField> fieldList = getInFields(i,declaredFields);
        InClass inClass = new InClass()
                .setInFieldSet(fieldList)
                .setClazz(i)
                .setIsEnum(i.isEnum())
                        .setType(i.getTypeName())
                        .setName(i.getSimpleName());
        return inClass;
    }


    /**
     * 获取字段
     *
     * @param i
     * @param declaredFields
     * @return
     */
    private static Set<InField> getInFields(Class<?> clazz, Field[] declaredFields) {
        Set<InField> fieldList = Arrays.stream(declaredFields).filter(i->filterInnerField(clazz,i)).map(f -> {
            InField inField = new InField().setName(f.getName());

            Class<?> fieldType = f.getType();
            String simpleName = fieldType.getSimpleName();
            boolean assignableFrom = List.class.isAssignableFrom(fieldType);
            inField.setJavaType(simpleName);

            if(assignableFrom){
                // 获取该字段的类型信息，getGenericType()方法能够获取带有泛型的类型信息
                Type genericType = f.getGenericType();
                // 但我们实际上需要获取返回值类型中的泛型信息，所以要进一步判断，即判断获取的返回值类型是否是参数化类型ParameterizedType
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) genericType;
                    // 获取成员变量的泛型类型信息
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    inField.setJavaType("List<"+actualTypeArguments[0].getTypeName()+">");
                    /*for (Type actualTypeArgument : actualTypeArguments) {
                        Class fieldArgClass = (Class) actualTypeArgument;
                        System.out.println("成员变量的泛型信息：" + fieldArgClass);
                    }*/
                }
            }

            if (f.getName().contains("Object") && f.getName().startsWith("s")) {
                inField.setJavaType("String");
            }
            inField.setRealType(fieldType);
            return inField;
        }).collect(Collectors.toSet());
        return fieldList;
    }

    /**
     * 是不是需要的字段
     *
     * @param clazz
     * @param field
     * @return
     */
    private static boolean filterInnerField(Class<?> clazz, Field field) {
        String name = field.getName();
        Class<?> type = field.getType();

        if(clazz == type){
            return false;
        }
        boolean contains = List.of("bitField0_").contains(name);
        boolean is_ = name.endsWith("_");
        return !contains && is_;
    }


    /**
     * 是不是需要的class
     * @param i
     * @return
     */
    private static boolean filterInnerClass(Class<?> i) {
        return !i.getName().endsWith("Builder") && !i.isInterface();
    }

    @Test
    public void testFile(){
        File file = new File("E:\\java\\workspace\\space2\\app-backend\\backend-proto\\src\\main\\java\\com\\cube\\protocol");
        String collect = Arrays.stream(file.listFiles()).map(i -> {
            return i.getName().substring(0,i.getName().length()-5) + ".class";
        }).collect(Collectors.joining(","));
        System.out.println("collect = " + collect);
    }



}
