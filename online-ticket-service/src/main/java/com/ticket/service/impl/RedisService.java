package com.ticket.service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * Created by wangwu on 2020/7/10.
 */
@Service
public class RedisService {

        private static final Logger log = LoggerFactory.getLogger(RedisService.class);

        @Autowired
        private StringRedisTemplate redisTemplate;


        /**
         * @Description 获取String类型的value
         * @param name
         * @return
         */
        public String findName(String name) {
                if (name==null){
                        log.error("===============key为null======================================================");
                }
                return redisTemplate.opsForValue().get(name);
        }

        /**
         * @Description 添加String类型的key-value
         * @param name
         * @param value
         * @return
         */
        public String setNameValue(String name, String value) {
                log.info("==================添加String类型的key-value========================================");
                redisTemplate.opsForValue().set(name,value);
                return name;
        }

        /**
         * @Description 根据key删除redis的数据
         * @param name
         * @return
         */
        public String delNameValue(String name) {
                redisTemplate.delete(name);
                return name;
        }

        /**
         * @Description 根据key获取list类型的value(范围)
         * @param key
         * @return
         */
        public List<String> findList(String key,int start,int end) {
                log.info("=====================按照范围查询redis中List类型=======================================");
                return redisTemplate.opsForList().range(key,start,end);
        }

//        public List<Object> findEntityList(String key,int start,int end) {
//                log.info("=====================按照范围查询redis中List类型=======================================");
//                return redisTemplate.opsForList().range(key,start,end);
//        }

        /**
         * @Description 插入多条数据--字符串
         * @param key
         * @param value
         * @return
         */
        public long setList(String key, List<String> value) {
                log.info("=========================redis List type insert ======================================");
                return redisTemplate.opsForList().rightPushAll(key, value);
        }



        /**
         * @Description 插入多条数据--对象
         * @param key
         * @param value
         * @return
         */
//        public long setObjectList(String key, List<Object> value) {
//                log.info("=========================redis List type insert ======================================");
//                return redisTemplateALL.opsForList().rightPushAll(key,value);
//        }

        /**
         * @Description 获取list最新记录（右侧）
         * @param key
         * @return
         */
        public String findLatest(String key) {
                log.info("=============================rides List latest rigth==================================");
                return redisTemplate.opsForList().index(key,redisTemplate.opsForList().size(key)-1);
        }

        /**
         * @Description 查询hash
         * @param key
         * @return
         */
        public Map<Object, Object> findHash(String key) {
                log.info("===================================redis hash =========================================");
                return redisTemplate.opsForHash().entries(key);
        }

        /**
         * @Description 查询hash中所有的key
         * @param key
         * @return
         */
        public Set<Object> findHashKeys(String key) {
                log.info("====================================== All keys of hash ===============================");
                return redisTemplate.opsForHash().keys(key);
        }

        /**
         * @Description 查询hash中所有的value
         * @param key
         * @return
         */
        public List<Object> findHashValues(String key) {
                log.info("===================================== All values of hash ==============================");
                return redisTemplate.opsForHash().values(key);
        }

        /**
         * @Desscription 插入hash数据
         * @param key
         * @param map
         * @return
         */
        public long insertHash(String key, Map<String, Object> map) {
                log.info("====================================== insert hashes into redis ========================");
                redisTemplate.opsForHash().putAll(key,map);
                return map.size();
        }
}