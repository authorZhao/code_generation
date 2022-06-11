package com.git.mapper;

import com.git.th.SqlColumn;
import com.git.th.SqlTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author authorZhao
 * @since 2022-05-10
 */
@Mapper
public interface SqlMapper {

    /**
     * 执行sql
     * @param sql
     * @return
     */
    @Select("${sql}")
    List<Map<String,Object>> query(@Param("sql")String sql);

    @Select("select COLUMN_NAME AS columnName,COLUMN_COMMENT AS `comment`,DATA_TYPE AS sqlType from information_schema.`COLUMNS` WHERE `TABLE_SCHEMA`=#{dataBase} AND TABLE_NAME=#{table} AND  `EXTRA` NOT LIKE '%GENERATED%'")
    List<SqlColumn> querySqlColumn(@Param("dataBase")String dataBase, @Param("table")String table);


    @Select("SELECT TABLE_NAME AS tableName,TABLE_COMMENT AS comment FROM information_schema.`TABLES` WHERE `TABLE_SCHEMA`=#{dataBase} AND TABLE_NAME=#{table}")
    SqlTable queryTable(@Param("dataBase")String dataBase, @Param("table")String table);

    @Select("SELECT TABLE_NAME AS tableName,TABLE_COMMENT AS comment FROM information_schema.`TABLES` WHERE `TABLE_SCHEMA`=#{dataBase}")
    List<SqlTable> queryTableFromDb(String cube);
}
