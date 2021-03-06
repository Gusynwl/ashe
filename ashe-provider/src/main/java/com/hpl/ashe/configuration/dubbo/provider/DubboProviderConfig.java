package com.hpl.ashe.configuration.dubbo.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.hpl.ashe.api.DemoService;
import com.hpl.ashe.configuration.ConfigService;
import com.hpl.ashe.constant.CommonConstant;
import com.hpl.ashe.provider.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * <p>Title: DubboProviderConfig</p>
 *
 * @author hupenglong
 * @date 2020-07-09 19:26
 */
@Component
public class DubboProviderConfig {
    @Autowired
    private ConfigService configService;
    @Autowired
    private ApplicationConfig applicationConfig;
    @Autowired
    private ProtocolConfig protocolConfig;
    @Autowired
    private RegistryConfig registryConfig;
    @Autowired
    private DemoServiceImpl demoService;

    @Bean
    public ServiceConfig<DemoService> demoServiceServiceConfig() {
        ServiceConfig<DemoService> config = new ServiceConfig<>();
        config.setInterface(DemoService.class);
        config.setRef(demoService);
        someRepate(config);
        return config;
    }

    private void someRepate(ServiceConfig<?> config) {
        config.setTimeout(Integer.valueOf(configService.getString(CommonConstant.Dubbo.CONSUMER_TIMEOUT)));
        config.setGroup(configService.getString(CommonConstant.Dubbo.REGISTRY_GROUP));
        config.setApplication(applicationConfig);
        config.setProtocol(protocolConfig);
        config.setRegistry(registryConfig);
        config.export();
    }
}
