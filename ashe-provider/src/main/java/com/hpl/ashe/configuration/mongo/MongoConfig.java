package com.hpl.ashe.configuration.mongo;


import com.hpl.ashe.configuration.ConfigService;
import com.hpl.ashe.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * <p>Title: MongoConfig</p>
 *
 * @author hupenglong
 * @date 2020-06-27 15:11
 */
@Configuration
public class MongoConfig {
    @Autowired
    private ConfigService configService;

    @Bean
    @Primary
    public MongoProperties mongoProperties() {
        MongoProperties properties = new MongoProperties();
        properties.setUri(configService.getString(CommonConstant.Mongo.DATA_MONGO_URI));
        return properties;
    }
}
