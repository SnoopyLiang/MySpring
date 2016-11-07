package com.lql.util;

import java.util.List;
import java.util.Map;

/**
 * Created by liquanl on 2016/11/4.
 */


/**
 * 工具类
 *
 * @author liquanl
 */
public class MyUtils {

  /**
   * 遍历List集合中的Map集合
   *
   * @param listMaps
   */
  public static void loopListMap(List<Map<String, Object>> listMaps) {
    for (Map<String, Object> listMap : listMaps) {
      for (Map.Entry<String, Object> entry : listMap.entrySet()) {
        System.out.println(entry.getKey() + "  :  " + entry.getValue());
      }
    }
  }

  /**
   * 判断字符串是否为空
   *
   * @param str
   * @return
   */
  public static boolean isEmpty(String str) {
    if (str == null || "".equals(str.trim())) {
      return true;
    } else {
      return false;
    }
  }
}
