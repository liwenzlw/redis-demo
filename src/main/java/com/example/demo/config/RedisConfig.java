package com.example.demo.config;

import com.example.demo.bean.User;
import com.example.demo.redisutil.RedisObjectSerializer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePool;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * Created by zenglw on 2018/3/11.
 */
@Configuration
public class RedisConfig {

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }

    @Bean(name = "userRedisTemplate")
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

    /**
     * jedis
     */
//    @Bean
//    public RedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setDatabase(0);
//        redisStandaloneConfiguration.setHostName("192.168.2.138");
//        redisStandaloneConfiguration.setPort(6379);
//        redisStandaloneConfiguration.setPassword(RedisPassword.of("123456"));
//        JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder();
//        builder.usePooling();
//        builder.connectTimeout(Duration.ofSeconds(8));
//        builder.readTimeout(Duration.ofSeconds(8));
//        JedisClientConfiguration jedisClientConfiguration = builder.build();
//
//        return new JedisConnectionFactory(redisStandaloneConfiguration,jedisClientConfiguration);
//    }
//
//    /**
//     * Lettuce
//     */
//    @Bean
//    public RedisConnectionFactory lettuceConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setDatabase(0);
//        redisStandaloneConfiguration.setHostName("192.168.2.138");
//        redisStandaloneConfiguration.setPort(6379);
//        redisStandaloneConfiguration.setPassword(RedisPassword.of("123456"));
//        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
//        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
//        builder.poolConfig(genericObjectPoolConfig);
//        LettucePoolingClientConfiguration build = builder.build();
//        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration,build);
//        return lettuceConnectionFactory;
//    }
}
