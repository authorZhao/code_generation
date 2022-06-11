package com.git.th;

import lombok.Data;

/**
 * @author authorZhao
 * @since 2022-05-10
 */
@Data
public class SqlColumn {

    /**
     * 数据库名字
     */
    private String columnName;

    /**
     * 驼峰名字
     */
    private String camelColumnName;

    /**
     * 注释
     */
    private String comment;

    /**
     * sql类型
     */
    private String sqlType;

    /**
     * java类型结构
     */
    private String javaType1;

    /**
     * 自定义的
     */
    private String javaType2;
}
