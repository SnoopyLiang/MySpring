package com.lql.controller;

import com.lql.model.TableData;
import com.lql.service.DatabaseService;
import com.lql.util.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by liquanl on 2016/11/3.
 */
@Controller("databaseController")
@RequestMapping("/data")
public class DatabaseController {

  private static Logger logger = LoggerFactory.getLogger(DatabaseController.class);

  @Autowired
  private DatabaseService databaseService;

  @RequestMapping(value = "/listTableName")
  public String listTableName(Model model) {
    logger.debug("listTableName");
    List<String> tableNameList = databaseService.getTableName();
    model.addAttribute("tableNameList", tableNameList);
    return "index";
  }

  @RequestMapping(value = "/executeSql")
  public String executeSql(@RequestParam(value = "sql", required = false) String sql, Model model) {
    List<TableData> tableDatas;
    logger.debug("executeSql");
    if (MyUtils.isEmpty(sql)) {
      model.addAttribute("info", "输入为空,请输入sql语句!!!");
    } else {
      try {
        tableDatas = databaseService.executeSql(sql);
        model.addAttribute("tableDatas", tableDatas);
      } catch (BadSqlGrammarException e) {
        model.addAttribute("info", "输入sql有误");
        logger.error("输入sql有误");
        e.printStackTrace();
      }
    }
    return "index";
  }

}
