package org.xgqc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
    public RedisConfig() {
    }

    @Bean
    @Primary
    public RedisConnectionFactory businessRedisConnectionFactory() {
        RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration();
        clusterConfig.clusterNode("10.20.0.184", 4901);
        clusterConfig.clusterNode("10.20.0.184", 4902);
        clusterConfig.clusterNode("10.20.0.184", 4903);
        clusterConfig.clusterNode("10.20.0.185", 5901);
        clusterConfig.clusterNode("10.20.0.185", 5902);
        clusterConfig.clusterNode("10.20.0.185", 5903);
        clusterConfig.clusterNode("10.20.0.186", 6901);
        clusterConfig.clusterNode("10.20.0.186", 6902);
        clusterConfig.setPassword("hopechart1qa@WS3edRedis");
        return new LettuceConnectionFactory(clusterConfig);
    }

    @Bean
    public RedisConnectionFactory rateLimitRedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("10.20.0.224");
        config.setPort(6399);
        config.setDatabase(0);
        config.setPassword("7PFWLJtad87i5ZfJvhxq6bj09");
        return new LettuceConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<String, byte[]> binaryRedisTemplate(@Qualifier("businessRedisConnectionFactory") RedisConnectionFactory factory) {
        RedisTemplate<String, byte[]> template = new RedisTemplate();
        template.setConnectionFactory(factory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(RedisSerializer.byteArray());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<String, Object> objectRedisTemplate(@Qualifier("rateLimitRedisConnectionFactory") RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setConnectionFactory(factory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(RedisSerializer.string());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(@Qualifier("businessRedisConnectionFactory") RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(factory);
        template.afterPropertiesSet();
        return template;
    }
}
