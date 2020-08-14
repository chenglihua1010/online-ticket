package com.ticket.utils;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by wangwu on 2020/8/10.
 */
public class ContextUtils {
        public  static ThreadLocal<Map<String,Object>> context=new ThreadLocal<Map<String,Object>>();
        public  static ThreadLocal<Object> context1=new ThreadLocal<Object>();
        public  static Map<String,Object> map= Maps.newConcurrentMap();


        public static ThreadLocal<Map<String, Object>> getContext() {
                return context;
        }

        public static void setContext(ThreadLocal<Map<String, Object>> context) {
                ContextUtils.context = context;
        }

        public static Map<String, Object> getMap() {
                return map;
        }

        public static void setMap(Map<String, Object> map) {
                ContextUtils.map = map;
        }
}
