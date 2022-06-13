package com.git;

import com.git.mapper.SqlMapper;
import com.git.proto.InClass;
import com.git.proto.OutClass;
import com.git.th.SqlColumn;
import com.git.th.SqlTable;
import com.git.util.CmdUtil;
import com.git.util.MyClassLoader;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
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
        File file = new File("E:\\idea\\workspace3\\gan\\app-backend\\backend-proto\\src\\main\\java\\com\\cube\\protocol\\ActivityProto.java");
        byte[] bytes = FileUtils.readFileToByteArray(file);
        Class<?> aClass = MyClassLoader.instance().defineClassForName("com.cube.protocol.ActivityProto", bytes);
        Class<?>[] classes = aClass.getClasses();
        String outClassName = aClass.getName();
        String outName = OutClass.getOutName(outClassName);
        List<InClass> inClassList = Arrays.stream(classes).filter(i ->
                !i.getName().endsWith("Builder") && !i.isInterface()
        ).map(i ->
                new InClass()
                        .setType(i.getTypeName())
                        .setName(OutClass.getInName(outName, i.getName()))
        ).collect(Collectors.toList());

        TemplateEngine templateEngine = new TemplateEngine();
        Context context = new Context();

        OutClass outClass = new OutClass().setInnerClassList(inClassList).setName(outName);
        context.setVariable("outClass",outClass);


        context.setVariable("author","authorZhao");
        context.setVariable("date", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
        String template = FileUtils.readFileToString(new File("E:\\java\\workspace\\space2\\code_generation\\src\\main\\resources\\templates\\proto.th"), StandardCharsets.UTF_8);
        String outPutPath = "C:\\Users\\Admin\\Desktop\\工作文档\\worknote\\txt\\"+outName+".java";
        FileWriter fileWriter = new FileWriter(outPutPath);
        templateEngine.process(template, context,fileWriter);
        CmdUtil.openWithCode(outPutPath);
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
