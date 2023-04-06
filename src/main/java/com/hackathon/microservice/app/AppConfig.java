package com.hackathon.microservice.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import com.hackathon.microservice.model.Status;

@Configuration
public class AppConfig {

	//Creating Connection with Redis
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory();
	}

	//Creating RedisTemplate for Entity 'Employee'
	@Bean
	public RedisTemplate<String, Status> redisTemplate(){
		RedisTemplate<String, Status> empTemplate = new RedisTemplate<>();
		empTemplate.setConnectionFactory(redisConnectionFactory());
		return empTemplate;
	}
}