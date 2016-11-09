package com.lql.controller;

import com.lql.model.TableData;
import com.lql.service.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liquanl on 2016/11/3.
 *
 * @author liquanl
 *         Controller层
 */
@Controller("databaseController")
@RequestMapping("/data")
public class DatabaseController {

  private static Logger logger = LoggerFactory.getLogger(DatabaseController.class);

  @Autowired
  private DatabaseService databaseService;

  @RequestMapping(value = "/listTableName")
  @ResponseBody
  public List<String> listTableName() {
    logger.debug("controller:listTableName");
    return databaseService.getTableName();
  }

  @RequestMapping(value = "/executeSql")
  @ResponseBody
  public List<TableData> executeSql(@RequestParam(value = "sql") String sql) {
    logger.debug("controller:executeSql");
    logger.info(sql);
    return databaseService.executeSql(sql);
  }

}
