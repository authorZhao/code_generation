package com.git;

import com.cube.protocol.ActivityProto;
import com.git.mapper.SqlMapper;
import com.git.proto.InClass;
import com.git.proto.InMethod;
import com.git.proto.OutClass;
import com.git.th.SqlColumn;
import com.git.th.SqlTable;
import com.git.util.CmdUtil;
import com.git.util.MyClassLoader;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author authorZhao
 * @since 2022-05-10
 */
public class TestProto {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = ActivityProto.class;
        Class<?>[] classes = aClass.getClasses();
        String outClassName = aClass.getName();
        String outName = OutClass.getOutName(outClassName);
        List<InClass> inClassList = Arrays.stream(classes).filter(i ->
                !i.getName().endsWith("Builder") && !i.isInterface()
        ).map(TestProto::getInClass).collect(Collectors.toList());

        TemplateEngine templateEngine = new TemplateEngine();
        Context context = new Context();

        OutClass outClass = new OutClass().setInnerClassList(inClassList).setName(outName);
        context.setVariable("outClass",outClass);


        context.setVariable("author","authorZhao");
        context.setVariable("date", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
        String template = FileUtils.readFileToString(new File("E:\\idea\\workpace\\space7\\code_generation\\src\\main\\resources\\templates\\proto.th"), StandardCharsets.UTF_8);
        String outPutPath = "C:\\Users\\authorZhao\\Desktop\\note\\gen\\java\\"+outName+".java";
        FileWriter fileWriter = new FileWriter(outPutPath);
        templateEngine.process(template, context,fileWriter);
        CmdUtil.openWithCode(outPutPath);
    }

    private static InClass getInClass(Class<?> i) {
        return new InClass()
                .setType(i.getTypeName())
                .setName(OutClass.getInName( i.getName()))
                .setRealClass(i.getClass())
                .setIsEnum(i.getTypeName().contains("enum"))
                .setInMethodList(getInMethod(i));
    }

    private static List<InMethod> getInMethod(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        return Arrays.stream(declaredFields).filter(i->{
            boolean isStatic = Modifier.isStatic(i.getModifiers());
            boolean isFinal = Modifier.isFinal(i.getModifiers());
            String name = i.getName();
            List<String> excluded = Lists.newArrayList("memoizedIsInitialized"
            ,"bitField0_","memoizedSerializedSize");
            boolean bitField0_ = excluded.contains(name);
            return !isStatic && !isFinal && !bitField0_;
        }).map(i->{
                    String simpleType = i.getType().getSimpleName();
                    String fieldName = OutClass.getFieldName(i.getName());
                    if("Object".equals(simpleType) && fieldName.startsWith("s")){
                        simpleType = "String";
                    }
                    return new InMethod()
                            .setFieldName(fieldName)
                            .setFieldRealType(i.getType())
                            .setFieldType(simpleType);
        }
        ).collect(Collectors.toList());
    }



    private static final char UNDERLINE = '_';

    private String underlineToCamel(String param) {
        if (StringUtils.isBlank(param)) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = Character.toLowerCase(param.charAt(i));
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
