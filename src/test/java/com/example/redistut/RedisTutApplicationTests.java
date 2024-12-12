package com.example.redistut;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisTutApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;
//	@Test
//	void contextLoads() {
//	}

	@Disabled
	@Test
	void testSendEmail(){
		redisTemplate.opsForValue().set("email","demomail@gmail.com");
		Object obj = redisTemplate.opsForValue().get("email");
		System.out.println(obj);
	}

}
