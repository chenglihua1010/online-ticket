package com.ticket.utils;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationUtils;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * shenhj
 */
public class RedisClient {
	private static final Logger log = LoggerFactory.getLogger(RedisClient.class);

	@Resource(name = "redisTemplate")
	private RedisTemplate redisTemplate;

	@Resource(name = "shardedJedisPool")
	private ShardedJedisPool shardedJedisPool;

	/**
	 * instance来源仍是spring
	 */
	private static RedisClient instance;

	private RedisSerializer<String> keySerializer;

	private RedisSerializer valueSerializer;

	private GenericToStringSerializer genericToStringSerializer = new GenericToStringSerializer(Object.class);

	private RedisClient(){
		instance = this;
	}
	public static RedisClient instance(){
		if (instance == null){
			instance = new RedisClient();
		}
		return instance;
	}

	public RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	/**
	 * 用于设置hash结构数据的ttl
	 */
	private Set<String> keySet = new HashSet<>();
	/**
	 * 配合hset使用，用于获取java对象或者String
	 */
	public <T> T hget(final String name,final String field) {
		return (T) redisTemplate.execute(new RedisCallback<T>() {
			public T doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] name_ = keySerializer.serialize(name);
				byte[] field_ = keySerializer.serialize(field);
				byte[] value_ = connection.hGet(name_,field_);
				return (T) valueSerializer.deserialize(value_);
			}
		});
	}

	/**
	 * 配合hset使用，用于分页获取hash结构
	 * @param name
	 * @param count 每次扫描行数，并非分页数
	 * @param pattern 用于模糊匹配field,类似通配符的使用:field*
	 * @param <T>
	 * @return
	 */
	public <T> Map<String, T> hScan(final String name,final int count,final String pattern) {
		return (Map<String, T>)redisTemplate.execute(new RedisCallback<Map<String, T>>() {
			public Map<String, T> doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] name_ = keySerializer.serialize(name);
				ScanOptions.ScanOptionsBuilder builder = ScanOptions.scanOptions().count(count);
				if (StringUtils.isNotBlank(pattern)) {
					builder.match(pattern);
				}
				Cursor<Map.Entry<byte[], byte[]>> entryCursor = connection.hScan(name_, builder.build());
				Map<String, T> result = new HashMap<>();
				while (entryCursor.hasNext()) {
					Map.Entry<byte[], byte[]> entry = entryCursor.next();
					String field_ = keySerializer.deserialize(entry.getKey());
					T value_ = (T) valueSerializer.deserialize(entry.getValue());
					result.put(field_,value_);
				}
				return result;
			}
		});
	}
	/**
	 * 配合hget使用，用于存放java 对象或者String
	 */
	public <T> boolean hset(final String name,final String field, final T val) {
		return (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] name_ = keySerializer.serialize(name);
				byte[] field_ = keySerializer.serialize(field);
				byte[] value_ = valueSerializer.serialize(val);
				return connection.hSet(name_,field_,value_);
			}
		});
	}

	/**
	 * 配合hget使用，慎用，数量太大会挂起其他操作线程，还可能引起OOM
	 * 不建议使用
	 */
	@Deprecated
	public <T> Map<String, T> hGetAll(final String name) {
		return (Map<String, T>) redisTemplate.execute(new RedisCallback<Map<String, T>>() {
			public Map<String, T> doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] name_ = keySerializer.serialize(name);
				Map<byte[], byte[]> map = connection.hGetAll(name_);
				Map<String, T> result = new HashMap<>();
				for (Map.Entry<byte[], byte[]> entry : map.entrySet()) {
					result.put(
							keySerializer.deserialize(entry.getKey()),
							(T) valueSerializer.deserialize(entry.getValue()));
				}
				return result;
			}
		});
	}
	/**
	 * 配合hincrby方法,用于获取计数值
	 */
	public Long hgetNum(final String name,final String field) throws UnsupportedEncodingException {
		return (Long)redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] name_ = keySerializer.serialize(name);
				byte[] field_ = keySerializer.serialize(field);
				byte[] value_ = connection.hGet(name_,field_);
				try {
					return Long.parseLong(new String(value_, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					log.error(e.getMessage());
				}
				return null;
			}
		});
	}

	/**
	 * 配合hgetNum使用，设置计数，支持加减
	 */
	public  Long hincrby(final String name,final String field, final long val) {
		return (Long) redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] name_ = keySerializer.serialize(name);
				byte[] field_ = keySerializer.serialize(field);
				return connection.hIncrBy(name_,field_,val);
			}
		});
	}

	public <T> boolean hsetEx(final String name,final String field, final T val,final Long ttl) {
		return (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] name_ = keySerializer.serialize(name);
				byte[] field_ = keySerializer.serialize(field);
				byte[] value_ = valueSerializer.serialize(val);
				if(!keySet.contains(name)){
					boolean flag = connection.expire(name_,ttl==null?7*24*3600L:ttl);
					if(flag){
						keySet.add(name);
					}
				}
				return connection.hSet(name_,field_,value_);
			}
		});
	}
	/**
	 * Created by shenhj on 2017/4/22.
	 * return items(Long)
	 */
	public <T> Long hdel(final String name, final String field) {
		return (Long) redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] name_ = keySerializer.serialize(name);
				byte[] field_ = keySerializer.serialize(field);
				return connection.hDel(name_,field_);
			}
		});
	}

	public <T> Long hlength(final String name) {
		return (Long) redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] name_ = keySerializer.serialize(name);
				return connection.hLen(name_);
			}
		});
	}

	public <T> boolean hexists(final String name, final String field) {
		return (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] name_ = keySerializer.serialize(name);
				byte[] field_ = keySerializer.serialize(field);
				if (Boolean.TRUE.equals(connection.hExists(name_,field_))) {
					return true;
				}else{
					return false;
				}
			}
		});
	}

	/**
	 * @param pattern,类似key:*
	 * @return
	 */
	public Set<String> scan(final String pattern) {
		return scan(pattern, 10000);
	}

	/**
	 *
	 * @param pattern
	 * @param count 每次扫描记录数
	 * @return
	 */
	private Set<String> scan(final String pattern, final int count) {
		return (Set<String>)redisTemplate.execute(new RedisCallback<Set<String>>() {
			public Set<String> doInRedis(RedisConnection connection)
					throws DataAccessException {
				ScanOptions.ScanOptionsBuilder builder = ScanOptions.scanOptions().count(count);
				if (StringUtils.isNotBlank(pattern)) {
					builder.match(pattern);
				}
				Cursor<byte[]> cursor = connection.scan(builder.build());
				Set<String> result = Sets.newHashSetWithExpectedSize(1 << 10);
				while (cursor.hasNext()) {
					byte[] bytes = cursor.next();
					String field_ = keySerializer.deserialize(bytes);
					result.add(field_);
				}
				return result;
			}
		});
	}

	public <T> T get(final String key) {
		return (T) redisTemplate.execute(new RedisCallback<T>() {
			public T doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key_ = keySerializer.serialize(key);
				byte[] value_ = connection.get(key_);
				return (T) valueSerializer.deserialize(value_);
			}
		});
	}
	/**
	 * Created by shenhj on 2017/4/22.
	 * EX   seconds  -- Set the specified expire time, in seconds.
	 * ttl default one week
	 */
	public <T> void set(final String key, final T val) {
		redisTemplate.execute(new RedisCallback<Void>() {
			public Void doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key_ = keySerializer.serialize(key);
				byte[] value_ = valueSerializer.serialize(val);
				connection.setEx(key_, 7*24*3600L,value_);
				return null;
			}
		});
	}

	public <T> void permanentSet(final String key, final T val) {
		redisTemplate.execute(new RedisCallback<Void>() {
			public Void doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key_ = keySerializer.serialize(key);
				byte[] value_ = valueSerializer.serialize(val);
				connection.set(key_, value_);
				return null;
			}
		});
	}

	public boolean exists(final String key) {
		return (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key_ = keySerializer.serialize(key);
				if (Boolean.TRUE.equals(connection.exists(key_))) {
					return true;
				}else{
					return false;
				}
			}
		});
	}

	public Long del(final String key) {
		return (Long) redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key_ = keySerializer.serialize(key);
				return connection.del(key_);
			}
		});
	}

	/**
	 * Created by shenhj on 2017/4/22.
	 * EX   seconds  -- Set the specified expire time, in seconds.
	 * PX   milliseconds  -- Set the specified expire time, in milliseconds.
	 * NX  -- Only set the key if it does not already exist
	 * XX  -- Only set the key if it already exist.
	 */
	public <T> boolean setNX(final String key, final T val) {
		return (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key_ = keySerializer.serialize(key);
				byte[] value_ = valueSerializer.serialize(val);
				if (Boolean.TRUE.equals(connection.setNX(key_, value_))) {
					return true;
				}else{
					return false;
				}
			}
		});
	}


	/**
	 * Created by shenhj on 2017/4/22.
	 * Set the specified expire time, in seconds.
	 * timeout  /s
	 */
	public <T> void setEX(final String key, final Long timeout, final T val) {
		redisTemplate.execute(new RedisCallback<Void>() {
			public Void doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key_ = keySerializer.serialize(key);
				byte[] value_ = valueSerializer.serialize(val);
				connection.setEx(key_, timeout, value_);
				return null;
			}
		});
	}

	public <T> void setEXForInc(final String key, final Long timeout, final T val) {
		redisTemplate.execute(new RedisCallback<Void>() {
			public Void doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key_ = keySerializer.serialize(key);
				byte[] value_ = genericToStringSerializer.serialize(val);
				connection.setEx(key_, timeout, value_);
				return null;
			}
		});
	}

	/**
	 * 设置超时时间
	 * @param key
	 * @param timeout 超时时间 单位秒
	 * @return
	 */
	public boolean setex(final String key,final long timeout) {
		return (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key_ = keySerializer.serialize(key);
				if (Boolean.TRUE.equals(connection.expire(key_,timeout))) {
					return true;
				}else{
					return false;
				}
			}
		});
	}
	/**
	 * 设置次数
	 * @param key key
	 * @param num 增加的次数
	 * @return 加上之后的次数
	 */
	public Long incr(final String key,final long num) {
		return (Long) redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key_ = keySerializer.serialize(key);
				return connection.incrBy(key_, num);
			}
		});
	}

	/**
	 * 原子加一
	 * @param key
	 * @return
	 */
	public Long incr(final String key) {
		return incr(key, 1L);
	}

	/**
	 * 原子减一
	 * @param key
	 * @return
	 */
	public Long decr(final String key) {
		return incr(key, -1L);
	}

	/**
	 * 设置key结构的过期时间
	 * @param key key
	 * @param expire 过期时间，秒为单位
	 * @return
	 */
	public boolean expire(final String key,final long expire) {
		return setex(key, expire);
	}

	/**
	 * 用于存放set结构
	 */
	public <T> Long sAdd(final String key, final T... values){
		return (Long)redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) {
				byte[] key_ = keySerializer.serialize(key);
				byte[][] rawValues = serializeValues(values);
				return connection.sAdd(key_, rawValues);
			}
		});
	}
	/**
	 * set结构中是否存在成员
	 */
	public <T> boolean sIsMemeber(final String key,final T val){
		return (boolean)redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) {
				byte[] key_ = keySerializer.serialize(key);
				byte[] value_ = valueSerializer.serialize(val);
				if (Boolean.TRUE.equals(connection.sIsMember(key_, value_))) {
					return true;
				}else{
					return false;
				}
			}
		});
	}
	/**
	 * 获取全部set成员
	 */
	public Set sMembers(final String key) {
		return  (Set)redisTemplate.execute(new RedisCallback<Set>() {
			public Set doInRedis(RedisConnection connection) {
				byte[] key_ = keySerializer.serialize(key);
				Set<byte[]> rawValues =  connection.sMembers(key_);
				return (Set)deserializeRawValues(rawValues);
			}
		});
	}
	/**
	 * set结构,删除成员
	 */
	public <T> Long sRemove(final String key,final T...values) {
		return (Long)redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) {
				byte[] key_ = keySerializer.serialize(key);
				byte[][] rawValues = serializeValues(values);
				return connection.sRem(key_, rawValues);
			}
		});
	}

	/**
	 * 用于添加HyperLogLog结构的数据
	 */
	public <T> Long pfadd(final String key,final T... values) {
		return (Long)redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) {
				byte[] key_ = keySerializer.serialize(key);
				byte[][] rawValues = serializeValues(values);
				return connection.pfAdd(key_, rawValues);
			}
		});
	}

	/**
	 * 用于统计HyperLogLog的基数估算值
	 */
	public <T> Long pfCount(final String key) {
		return (Long)redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) {
				byte[] key_ = keySerializer.serialize(key);
				return connection.pfCount(key_);
			}
		});
	}

	/**
	 * redis消息队列实现,pub
	 * @param topic
	 * @param <T>
	 * @return
	 */
	public <T> Long publish(final String topic,final T t) {
		return (Long)redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) {
				byte[] key_ = keySerializer.serialize(topic);
				byte[] value_ = valueSerializer.serialize(t);
				return connection.publish(key_,value_);
			}
		});
	}

	/**
	 * redis消息队列实现,sub
	 * @param listener
	 * @param topic
	 * @return
	 */
	public void subscribe(final MessageListener listener, final String topic) {
		redisTemplate.execute(new RedisCallback<Void>() {
			public Void doInRedis(RedisConnection connection) {
				byte[] key_ = keySerializer.serialize(topic);
				connection.subscribe(listener,key_);
				return null;
			}
		});
	}

	private <T> Set<T> deserializeRawValues(Set<byte[]> rawValues) {
		return SerializationUtils.deserialize(rawValues, valueSerializer);
	}

	private byte[][] serializeKeys(String... keys) {
		byte[][] rawKeys = new byte[keys.length][];
		int i = 0;
		String[] objects = keys;
		int length = keys.length;

		for(int j = 0; j < length; ++j) {
			String key = objects[j];
			rawKeys[i++] = keySerializer.serialize(key);
		}
		return rawKeys;
	}

	private byte[][] serializeValues(Object... values) {
		byte[][] rawValues = new byte[values.length][];
		int i = 0;
		Object[] objects = values;
		int length = values.length;

		for(int j = 0; j < length; ++j) {
			Object value = objects[j];
			rawValues[i++] = valueSerializer.serialize(value);
		}
		return rawValues;
	}

	public RedisSerializer<String> getKeySerializer() {
		return keySerializer;
	}

	public void setKeySerializer(RedisSerializer<String> keySerializer) {
		this.keySerializer = keySerializer;
	}

	public RedisSerializer getValueSerializer() {
		return valueSerializer;
	}

	public void setValueSerializer(RedisSerializer valueSerializer) {
		this.valueSerializer = valueSerializer;
	}

	/**
	 * redis的HyperLogLog算法计算集合的基数，这里用于去重操作
	 * 如果至少有个元素被添加返回 1， 否则返回 0
	 * 此方法可能会被清理，建议用 pfadd 方法
	 */
	@Deprecated
	public Long pfAdd(final String key,String value) {
		ShardedJedis shardedJedis = null;
		Long result = null;
		try{
			//从池中获取jedis实例
			shardedJedis = shardedJedisPool.getResource();
			result = shardedJedis.pfadd(key,value);
			log.info("pfadd success result = " + result);
		}catch (Exception e){

			returnBrokenResource(shardedJedis);
		}finally {
			returnResource(shardedJedis);
			return result;
		}
	}

	private void returnBrokenResource(ShardedJedis shardedJedis) {
		if (shardedJedis == null) {
			return;
		}
		try {
			shardedJedis.close();
			//shardedJedisPool.returnBrokenResource(shardedJedis);
		} catch (Exception e) {
			log.error("returnBrokenResource error.", e);
		}
	}

	private void returnResource(ShardedJedis shardedJedis) {
        if (shardedJedis == null) {
            return;
        }
		try {
			shardedJedis.close();
			//shardedJedisPool.returnResource(shardedJedis);
		} catch (Exception e) {
			log.error("returnResource error.", e);
		}
	}
}