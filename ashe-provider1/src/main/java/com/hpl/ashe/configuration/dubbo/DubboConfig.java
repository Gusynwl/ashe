package com.hpl.ashe.configuration.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.hpl.ashe.configuration.ConfigService;
import com.hpl.ashe.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: DubboConfig</p>
 *
 * @author hupenglong
 * @date 2020-06-22 15:35
 */
@Configuration
public class DubboConfig {
    @Autowired
    private ConfigService configService;

    @Bean
    public ApplicationConfig getApplicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(configService.getString(CommonConstant.Dubbo.APPLICATION_NAME));
        applicationConfig.setEnvironment(configService.getString(CommonConstant.Dubbo.APPLICATION_ENV));
        return applicationConfig;
    }

    @Bean
    public RegistryConfig getRegistryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(configService.getString(CommonConstant.Dubbo.REGISTRY_ADDRESS));
        registryConfig.setId(configService.getString(CommonConstant.Dubbo.REGISTRY_ID));
        registryConfig.setGroup(configService.getString(CommonConstant.Dubbo.REGISTRY_GROUP));
        return registryConfig;
    }

    @Bean
    public ProtocolConfig getProtocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(configService.getString(CommonConstant.Dubbo.PROTOCOL_NAME));
        protocolConfig.setPort(Integer.valueOf(configService.getString(CommonConstant.Dubbo.PROTOCOL_PORT)));
        return protocolConfig;
    }

    @Bean
    public ConsumerConfig getConsumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(Integer.valueOf(configService.getString(CommonConstant.Dubbo.CONSUMER_TIMEOUT)));
        return consumerConfig;
    }

}
