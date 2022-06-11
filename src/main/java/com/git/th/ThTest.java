package com.git.th;

import com.baomidou.mybatisplus.generator.config.converts.DB2TypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author authorZhao
 * @since 2022-05-10
 */
public class ThTest {

    public static void main(String[] args) throws IOException {
        TemplateEngine templateEngine = new TemplateEngine();
        Context context = new Context();
        context.setVariable("items", Lists.newArrayList("渣渣辉","古田乐"));
        context.setVariable("a", "哈哈");
        String template = "[# th:each=\"item : ${items}\"][# th:utext=\"${item}\" /][/]";
        //template = "<div th:text=\"${a}\"></div>";
        //template ="姓名：[(${name})]<br/>性别：[(${sex})]";
        template = FileUtils.readFileToString(new File("E:\\java\\workspace\\space2\\code_generation\\src\\main\\resources\\templates\\appServerBean.th"), StandardCharsets.UTF_8);
        context.setVariable("name", "橙小七");
        context.setVariable("sex", "女");
        context.setVariable("packageName","com.cube");
        context.setVariable("tableComment","用户表");
        context.setVariable("author","authorZhao");
        context.setVariable("date","2022-05-10");
        context.setVariable("tableName","User");


        //IColumnType columnType = DB2TypeConvert.INSTANCE.processTypeConvert(null, "int");




        FileWriter fileWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\工作文档\\worknote\\txt\\a.txt");
        templateEngine.process(template, context,fileWriter);

    }
}
