package com.ticket.service.impl;

/**
 * Created by wangwu on 2020/7/15.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类，使用之前请确保RedisTemplate成功注入
 *
 * @author ye17186
 * @version 2019/2/22 10:48
 */
@Service
public class RedisUtils {

        private static final Logger log = LoggerFactory.getLogger(RedisService.class);

        @Autowired
        public  RedisTemplate redisTemplate;

//        @Resource(name = "JedisPool")
//        private JedisPool jedisPool;

        @Resource(name = "shardedJedisPool")
        private ShardedJedisPool shardedJedisPool;

        private static final String LOCK_SUCCESS = "OK";
        private static final String SET_IF_NOT_EXIST = "NX";
        private static final String SET_WITH_EXPIRE_TIME = "PX";
        private static final Long RELEASE_SUCCESS = 1L;

        public void setRedisTemplate(RedisTemplate redisTemplate) {
                this.redisTemplate = redisTemplate;
        }

        private RedisUtils() {
        }

//        @SuppressWarnings("unchecked")
//        private static RedisTemplate<String, Object> redisTemplate = SpringUtils
//                        .getBean("redisTemplate", RedisTemplate.class);

        /**
         * 设置有效时间
         *
         * @param key Redis键
         * @param timeout 超时时间
         * @return true=设置成功；false=设置失败
         */
        public  boolean expire(final String key, final long timeout) {

                return expire(key, timeout, TimeUnit.SECONDS);
        }




        /**
         * 尝试获取分布式锁
         * @param jedis Redis客户端
         * @param lockKey 锁
         * @param requestId 请求标识
         * @param expireTime 超期时间
         * @return 是否获取成功
         */
        public  boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {

                String result =shardedJedisPool.getResource().set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
//                Jedis jedis1=jedisPool.getResource();
//                String result = jedis1.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

                if (LOCK_SUCCESS.equals(result)) {
                        return true;
                }
                return false;

        }


        /**
         * 释放分布式锁
         * @param jedis Redis客户端
         * @param lockKey 锁
         * @param requestId 请求标识
         * @return 是否释放成功
         */
        public  boolean releaseDistributedLock(Jedis jedis,String lockKey, String requestId) {

                String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

                if (RELEASE_SUCCESS.equals(result)) {
                        return true;
                }
                return false;

        }



        /**
         * 设置有效时间
         *
         * @param key Redis键
         * @param timeout 超时时间
         * @param unit 时间单位
         * @return true=设置成功；false=设置失败
         */
        public  boolean expire(final String key, final long timeout, final TimeUnit unit) {

                Boolean ret = redisTemplate.expire(key, timeout, unit);
                return ret != null && ret;
        }

        /**
         * 删除单个key
         *
         * @param key 键
         * @return true=删除成功；false=删除失败
         */
        public  void del(final String key) {
                redisTemplate.delete(key);
        }

        /**
         * 删除多个key
         *
         * @param keys 键集合
         * @return 成功删除的个数
         */
        public  long del(final Collection<String> keys) {

                 redisTemplate.delete(keys);
                return keys.size();
        }

        /**
         * 存入普通对象
         *
         * @param key Redis键
         * @param value 值
         */
        public  void set(final String key, final Object value) {

//                redisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);
                redisTemplate.opsForValue().set(key, value);
        }

        // 存储普通对象操作

        /**
         * 存入普通对象
         *
         * @param key 键
         * @param value 值
         * @param timeout 有效期，单位秒
         */
        public  void set(final String key, final Object value, final long timeout) {

                redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        }

        /**
         * 获取普通对象
         *
         * @param key 键
         * @return 对象
         */
        public  Object get(final String key) {

                return redisTemplate.opsForValue().get(key);
        }

        // 存储Hash操作

        /**
         * 往Hash中存入数据
         *
         * @param key Redis键
         * @param hKey Hash键
         * @param value 值
         */
        public  void hPut(final String key, final String hKey, final Object value) {

                redisTemplate.opsForHash().put(key, hKey, value);
        }

        /**
         * 往Hash中存入多个数据
         *
         * @param key Redis键
         * @param values Hash键值对
         */
        public  void hPutAll(final String key, final Map<String, Object> values) {

                redisTemplate.opsForHash().putAll(key, values);
        }

        /**
         * 获取Hash中的数据
         *
         * @param key Redis键
         * @param hKey Hash键
         * @return Hash中的对象
         */
        public  Object hGet(final String key, final String hKey) {

                return redisTemplate.opsForHash().get(key, hKey);
        }

        /**
         * 获取多个Hash中的数据
         *
         * @param key Redis键
         * @param hKeys Hash键集合
         * @return Hash对象集合
         */
        public  List<Object> hMultiGet(final String key, final Collection<Object> hKeys) {

                return redisTemplate.opsForHash().multiGet(key, hKeys);
        }

        // 存储Set相关操作

        /**
         * 往Set中存入数据
         *
         * @param key Redis键
         * @param values 值
         * @return 存入的个数
         */
        public  long sSet(final String key, final Object... values) {
                Long count = redisTemplate.opsForSet().add(key, values);
                return count == null ? 0 : count;
        }

        /**
         * 删除Set中的数据
         *
         * @param key Redis键
         * @param values 值
         * @return 移除的个数
         */
        public  long sDel(final String key, final Object... values) {
                Long count = redisTemplate.opsForSet().remove(key, values);
                return count == null ? 0 : count;
        }

        // 存储List相关操作

        /**
         * 往List中存入数据
         *
         * @param key Redis键
         * @param value 数据
         * @return 存入的个数
         */
        public  long lPush(final String key, final Object value) {
                Long count = redisTemplate.opsForList().rightPush(key, value);
                return count == null ? 0 : count;
        }

        /**
         * 往List中存入多个数据
         *
         * @param key Redis键
         * @param values 多个数据
         * @return 存入的个数
         */
        public  long lPushAll(final String key, final Collection<Object> values) {
                Long count = redisTemplate.opsForList().rightPushAll(key, values);
                return count == null ? 0 : count;
        }

        /**
         * 往List中存入多个数据
         *
         * @param key Redis键
         * @param values 多个数据
         * @return 存入的个数
         */
        public  long lPushAll(final String key, final Object... values) {
                Long count = redisTemplate.opsForList().rightPushAll(key, values);
                return count == null ? 0 : count;
        }

        /**
         * 从List中获取begin到end之间的元素
         *
         * @param key Redis键
         * @param start 开始位置
         * @param end 结束位置（start=0，end=-1表示获取全部元素）
         * @return List对象
         */
        public  List<Object> lGet(final String key, final int start, final int end) {
                return redisTemplate.opsForList().range(key, start, end);
        }

        /**
         *  获取key
         * @param name
         * @return
         */
        public String findName(String name) {
                if (name==null){
                        log.error("===============key为null======================================================");
                }
                return (String) redisTemplate.opsForValue().get(name);
        }

        private static final String KEY_SPLIT_CHAR = ":";

        /**
         *  key 键规则定义
         * @param args 参数
         * @return key
                */
        public static String keyBuilder(String ... args){
                StringBuilder key=new StringBuilder();
                for(String arg:args){
                        key.append(KEY_SPLIT_CHAR).append(arg);
                }
                return key.toString();
        }

        public boolean lock(String key, String value){
                if(redisTemplate.opsForValue().setIfAbsent(key,value)){
                        return true;
                }
                return false;
        }

        public void unlock(String key,String value){

                if(this.get(key).equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
                }
        }


        public boolean lock1(String key, String value){
                if(redisTemplate.opsForValue().setIfAbsent(key,value)){
                        return true;
                }
                String current_value=(String)this.get(key);
                if(!current_value.equals("")
                                && Long.parseLong(current_value)<System.currentTimeMillis()){
                        return true;
                }
                return false;
        }

        public boolean lock2(String key,String value){
                if(redisTemplate.opsForValue().setIfAbsent(key,value)){
                        return true;
                }
                String current_value=(String)this.get(key);
                if(!current_value.equals("")&& Long.parseLong(current_value)<System.currentTimeMillis()){
                        String old_value=(String)redisTemplate.opsForValue().getAndSet(key,value);
                        if(!old_value.equals("")&&old_value.equals(current_value)){
                                return true;
                        }
                }
                return false;
        }


}