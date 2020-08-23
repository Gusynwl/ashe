package com.hpl.ashe.configuration.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.hpl.ashe.api.DemoService;
import com.hpl.ashe.api.OrderService;
import com.hpl.ashe.configuration.ConfigService;
import com.hpl.ashe.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * <p>Title: DubboConsumerConfig</p>
 *
 * @author hupenglong
 * @date 2020-07-09 19:28
 */
@Component
public class DubboConsumerConfig {
    @Autowired
    private RegistryConfig registryConfig;
    @Autowired
    private ApplicationConfig applicationConfig;
    @Autowired
    protected ConfigService configService;

    @Bean
    public OrderService orderService() {
        ReferenceConfig<OrderService> config = new ReferenceConfig<>();
        setReferenceConfig(config, OrderService.class);
        return config.get();
    }

    private void setReferenceConfig(ReferenceConfig rf, Class claz) {
        rf.setInterface(claz);
        rf.setGroup(configService.getString(CommonConstant.Dubbo.REGISTRY_GROUP));
        rf.setTimeout(Integer.valueOf(configService.getString(CommonConstant.Dubbo.CONSUMER_TIMEOUT)));
        rf.setApplication(applicationConfig);
        rf.setRegistry(registryConfig);
        rf.setCheck(false);
    }
}
