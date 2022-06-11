package com.git.th;

import lombok.Data;

import java.util.List;

/**
 * @author authorZhao
 * @since 2022-05-10
 */
@Data
public class SqlTable {

    private String tableName;

    private String comment;

    private List<SqlColumn> sqlColumnList;
}
