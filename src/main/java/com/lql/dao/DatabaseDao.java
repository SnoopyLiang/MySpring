package com.lql.dao;

import com.lql.model.TableData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liquanl on 2016/11/3.
 * @author liquanl
 * Dao层
 */
@Repository("databaseDao")
public class DatabaseDao {
  @Resource
  private JdbcTemplate jdbcTemplate;

  private static Logger logger = LoggerFactory.getLogger(DatabaseDao.class);

  /**
   * 获取数据库中的所有表名
   *
   * @return 表名列表
   */
  public List<String> getTableName() {
    logger.debug("Dao:getTableName");
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
   * 执行sql查询语句
   *
   * @param sql 要执行的语句
   * @return 查询到的表内数据
   */
  public List<TableData> executeSql(String sql) {
    logger.debug("Dao:executeSql");
    List<TableData> tableDatasResult = new ArrayList<TableData>();
    List<Map<String, Object>> tableDatas = jdbcTemplate.queryForList(sql);
    for (Map<String, Object> tableData : tableDatas) {
      TableData tableDataInstance = new TableData();
      tableDataInstance.setData(tableData);
      tableDatasResult.add(tableDataInstance);
    }
    return tableDatasResult;

  }

}
