package cn.bocaiman.util;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-Reds存取工具类</b>
 * <p>
 *     当系统需要使用到 Redis 时，需要使用本工具进行操作
 * </p>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("redisUtil")
public class RedisUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * <b>将数据存储到 Redis 中</b>
	 * @param key
	 * @param value
	 * @param expireMillis
	 * @throws Exception
	 */
	public void saveToRedis(String key, Object value, Long expireMillis) throws Exception {
		// 将对应的需要存储的对象变为 json 格式
		JsonMapper jsonMapper = new JsonMapper();
		String valueJSONStr = jsonMapper.writeValueAsString(value);
		// 将变为 String 的 value 存储到 Redis 中
		redisTemplate.opsForValue().set(key, valueJSONStr);
		// 设定存储的时长
		redisTemplate.expire(key, expireMillis, TimeUnit.MILLISECONDS);
	}

	/**
	 * <b>从 Redis 中获取信息</b>
	 * @param key
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public Object getFromRedis(String key, Class type) throws Exception {
		// 通过 key 从 Redis 中获取数据
		String valueJSONStr = redisTemplate.opsForValue().get(key);
		// 借助于 JsonMapper 将 json 还原成对象
		JsonMapper jsonMapper = new JsonMapper();
		Object value = jsonMapper.convertValue(valueJSONStr, type);
		return value;
	}
}
