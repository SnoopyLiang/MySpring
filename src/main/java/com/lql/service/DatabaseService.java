package com.lql.service;

import com.lql.dao.DatabaseDao;
import com.lql.model.TableData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liquanl on 2016/11/3.
 */
@Service("databaseService")
public class DatabaseService {

  @Resource
  private DatabaseDao databaseDao;

  public List<String> getTableName() {
    return databaseDao.getTableName();
  }

  public List<String> getTableFieldName(String tableName) {
    return databaseDao.getTableFieldName(tableName);
  }

  public List<TableData> executeSql(String sql) {
    return databaseDao.executeSql(sql);
  }

}
