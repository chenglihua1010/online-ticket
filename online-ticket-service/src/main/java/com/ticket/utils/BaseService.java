package com.ticket.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.lang.reflect.Field;
import java.util.*;

public class BaseService<T> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);


    /**
     * 复制对象
     *
     * @param dest
     * @param origin
     */
    public static void copyProperties(Object dest, Object origin) {
        if (null == origin) {
            dest = null;
            return;
        }
        try {
            BeanUtils.copyProperties(origin, dest);
        } catch (BeansException e) {
            LOGGER.error("BeansException copyProperties error ", e);
        }
    }

    /**
     * 获取业务对象bean
     *
     * @param origin
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Object origin, Class<T> clazz) {
        Object dest = null;
        if (null != origin) {
            try {
                dest = clazz.newInstance();
                copyProperties(dest, origin);
            } catch (InstantiationException e) {
                dest = null;
                LOGGER.error("InstantiationException getBean error ", e);
            } catch (IllegalAccessException e) {
                dest = null;
                LOGGER.error("IllegalAccessException getBean error ", e);
            }
        }

        return (null != dest) ? (T) dest : null;
    }


    /**
     * list转list
     * @param srcList
     * @param targetClazz
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T, S> List<T> getList(Collection<S> srcList, Class<T> targetClazz) {
        if (CollectionUtils.isEmpty(srcList)) {
            return Collections.emptyList();
        }
        T target = null;
        try {
            List<T> dist = new ArrayList<T>();
            for (S src : srcList) {
                //目标类注意必须实现空构造函数
                target = targetClazz.newInstance();
                copyProperties(target, src);
                dist.add(target);
            }
            return dist;
        } catch (Exception e) {
            LOGGER.error("对象{}复制属性出错:{}", targetClazz.getSimpleName(), JSONObject.toJSONString(srcList));
            throw new IllegalArgumentException("对象" + targetClazz.getSimpleName() + "复制属性出错", e);
        }
    }



    /**
     * 忽略大小写转换bean类型
     *
     * @param obj 转换的源对象
     * @param clz 目标对象
     * @return 转换后的对象
     */
    public static <T> T transferObjectIgnoreCase(Object obj, Class clz) {
        T result = null;
        try {
            if (obj != null && !obj.equals("")) {
                result = (T) clz.newInstance();
                //获取目标类的属性集合
                Map<String, Field> destPropertyMap = new HashMap<>();
                for (Field curField : clz.getDeclaredFields()) {
                    destPropertyMap.put(curField.getName().toLowerCase(), curField);
                }
                //拷贝属性
                for (Field curField : obj.getClass().getDeclaredFields()) {
                    Field targetField = destPropertyMap.get(curField.getName().toLowerCase());
                    if (targetField != null) {
                        targetField.setAccessible(true);
                        curField.setAccessible(true);
                        targetField.set(result, curField.get(obj));
                    }
                }
            }
        } catch (Exception e1) {
            return null;
        }
        return result;
    }

    /**
     * 忽略大小写转换bean类型List
     *
     * @param originList 转换的源对象
     * @param clazz 目标对象
     * @return 转换后的对象
     */
    public List<T> transferObjectIgnoreCaseList(List<?> originList, Class<T> clazz) {
        List<T> list = new ArrayList<>(originList.size());
        if (CollectionUtils.isNotEmpty(originList)) {
            for (Object obj : originList) {
                list.add(transferObjectIgnoreCase(obj, clazz));
            }
        }

        return list;
    }


}
