package com.git;

import com.git.mapper.SqlMapper;
import com.git.th.SqlColumn;
import com.git.th.SqlTable;
import com.git.util.CmdUtil;
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
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author authorZhao
 * @since 2022-05-10
 */
@SpringBootTest(classes = RunApplication.class)
public class TestSqlInfo {

    @Autowired
    private SqlMapper sqlMapper;

    @Test
    public void test1() throws Exception {
        String databases = "cube";
        List<SqlTable> sqlTables = queryTables(databases);
        sqlTables = sqlTables.stream().filter(TestSqlInfo::filterTables).collect(Collectors.toList());

        sqlTables.forEach(i->{
            List<SqlColumn> sqlColumns = queryColumn(databases, i.getTableName(), false);
            i.setSqlColumnList(sqlColumns);
        });

        TemplateEngine templateEngine = new TemplateEngine();
        Context context = new Context();
        String template = FileUtils.readFileToString(new File("E:\\java\\workspace\\space2\\code_generation\\src\\main\\resources\\templates\\sqlInfo.th"), StandardCharsets.UTF_8);

        context.setVariable("tables",sqlTables);

        String outPutPath = "C:\\Users\\Admin\\Desktop\\工作文档\\worknote\\txt\\运营字段.md";
        FileWriter fileWriter = new FileWriter(outPutPath);
        templateEngine.process(template, context,fileWriter);
        CmdUtil.openWithCode(outPutPath);
    }


    private static boolean filterTables(SqlTable sqlTable) {
        return true;
    }

    private List<SqlTable> queryTables(String cube) {
        return sqlMapper.queryTableFromDb(cube);
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

    private List<SqlColumn> queryColumn(String database,String table,boolean warp){
        List<SqlColumn> sqlColumns = sqlMapper.querySqlColumn(database,table);
        sqlColumns.forEach(i->{
            String sqlType = i.getSqlType();
            i.setCamelColumnName(underlineToCamel(i.getColumnName()));
            if(sqlType==null)return;
            if(sqlType.contains("tinyint")){
                i.setJavaType2("ClassType.BYTE");
                i.setJavaType1(warp?"Byte":"byte");
            }else if(sqlType.equals("int")){
                i.setJavaType2("ClassType.INT");
                i.setJavaType1(warp?"Integer":"int");
            }else if(sqlType.contains("bigint")){
                i.setJavaType2("ClassType.LONG");
                i.setJavaType1(warp?"Long":"long");
            }else if(sqlType.contains("time")){
                i.setJavaType2("ClassType.TIME");
                i.setJavaType1("Date");
            }else {
                i.setJavaType1("String");
                i.setJavaType2("ClassType.STR");
            }
        });
        return sqlColumns;
    }
}
