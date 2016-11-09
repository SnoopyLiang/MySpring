package com.lql.service;

import com.lql.dao.DatabaseDao;
import com.lql.model.TableData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liquanl on 2016/11/3.
 *
 * @author liquanl
 * service层
 */
@Service("databaseService")
public class DatabaseService {
  private static Logger logger = LoggerFactory.getLogger(DatabaseService.class);

  @Resource
  private DatabaseDao databaseDao;

  public List<String> getTableName() {
    logger.debug("service:getTableName");
    logger.info("获取数据库中所有表名");
    return databaseDao.getTableName();
  }

  public List<TableData> executeSql(String sql) {
    logger.debug("service:executeSql");
    List<TableData> tableDatas = new ArrayList<TableData>();
    try {
      logger.info("sql语句:" + sql);
      tableDatas = databaseDao.executeSql(sql);
    } catch (BadSqlGrammarException e) {
      logger.error("输入的sql语句错误:" + sql);
      e.printStackTrace();
    }

    return tableDatas;
  }

}
