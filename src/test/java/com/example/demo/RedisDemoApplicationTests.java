package com.example.demo;

import com.example.demo.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	@Qualifier(value = "userRedisTemplate")
	private RedisTemplate<String, User> userRedisTemplate;

	@Test
	public void test() throws Exception {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
        RedisConnectionFactory connectionFactory = stringRedisTemplate.getConnectionFactory();

        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Test
	public void test1() throws Exception {
		Jedis jedis = new Jedis("192.168.2.138",6379);
		jedis.auth("123456");
		jedis.set("age", "1");
		System.out.println(jedis.get("age"));
	}

	@Test
	public void testUser() throws Exception {

		User user1 = new User("小红", 10);
		User user2 = new User("小白", 20);
		User user3 = new User("小李", 30);

		userRedisTemplate.opsForValue().set(user1.getUsername(), user1);
		userRedisTemplate.opsForValue().set(user2.getUsername(), user2);
		userRedisTemplate.opsForValue().set(user3.getUsername(), user3);

		Assert.assertEquals(10, userRedisTemplate.opsForValue().get("小红").getAge().longValue());
		Assert.assertEquals(20, userRedisTemplate.opsForValue().get("小白").getAge().longValue());
		Assert.assertEquals(30, userRedisTemplate.opsForValue().get("小李").getAge().longValue());
	}
}
