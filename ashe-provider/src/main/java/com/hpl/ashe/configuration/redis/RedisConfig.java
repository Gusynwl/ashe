package com.hpl.ashe.configuration.redis;


import com.hpl.ashe.configuration.ConfigService;
import com.hpl.ashe.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

/**
 * <p>Title: RedisConfig</p>
 *
 * @author hupenglong
 * @date 2020-06-22 17:20
 */
@Configuration
public class RedisConfig {
    @Autowired
    private ConfigService configService;

    @Bean
    @Primary
    public RedisProperties redisProperties() {
        RedisProperties redisProperties = new RedisProperties();
        redisProperties.setHost(configService.getString(CommonConstant.Redis.REDIS_HOST));
        redisProperties.setPassword(configService.getString(CommonConstant.Redis.REDIS_PASSWORD));
        redisProperties.setPort(Integer.valueOf(configService.getString(CommonConstant.Redis.REDIS_PORT)));
        redisProperties.setTimeout(Duration.ofMillis(Long.valueOf(configService.getString(CommonConstant.Redis.REDIS_TIMEOUT))));
        redisProperties.setDatabase(Integer.valueOf(configService.getString(CommonConstant.Redis.REDIS_DATASOURCE)));
        return redisProperties;
    }

}
