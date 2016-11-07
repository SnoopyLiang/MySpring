package com.lql.dao;

import com.lql.model.TableData;
import com.lql.util.MyUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by liquanl on 2016/11/3.
 */
@Repository("databaseDao")
public class DatabaseDao {
  @Resource
  private JdbcTemplate jdbcTemplate;

  /**
   * 获取数据库中的所有表名
   *
   * @return 表名列表
   */
  public List<String> getTableName() {
    final List<String> tableNameList = new ArrayList<String>();
    String sql = "select table_name from information_schema.tables where table_schema= ?" + " and table_type= ?";
    jdbcTemplate.query(sql, new Object[] {"springtest", "base table"}, new RowCallbackHandler() {
      public void processRow(ResultSet rs) throws SQLException {
        String tableName = rs.getString("table_name");
        tableNameList.add(tableName);
      }
    });
    return tableNameList;
  }

  /**
   * 获取表的所有字段名
   *
   * @param tableName 表名
   * @return 所有字段名
   */
  public List<String> getTableFieldName(String tableName) {
    final List<String> tableFieldNameList = new ArrayList<String>();
    String sql = "select column_name from information_schema.tables where table_schema= ?" + " and table_name=?";
    jdbcTemplate.query(sql, new Object[] {"springtest", tableName}, new RowCallbackHandler() {
      public void processRow(ResultSet rs) throws SQLException {
        String tableFieldName = rs.getString("column_name");
        tableFieldNameList.add(tableFieldName);
      }
    });
    return tableFieldNameList;
  }

  /**
   * 执行sql查询语句
   *
   * @param sql 要执行的语句
   * @return 查询到的表内数据
   */
  public List<TableData> executeSql(String sql) {
    List<TableData> tableDatasResult = new ArrayList<TableData>();
    List<Map<String, Object>> tableDatas = jdbcTemplate.queryForList(sql);
    for (int i = 0; i < tableDatas.size(); i++) {
      Map<String, Object> tableData = tableDatas.get(i);
      TableData tableDataInstance = new TableData();
      tableDataInstance.setData(tableData);
      tableDatasResult.add(tableDataInstance);
    }
    return tableDatasResult;

  }

}
