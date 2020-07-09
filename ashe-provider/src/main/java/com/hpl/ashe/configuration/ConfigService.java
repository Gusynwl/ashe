package com.hpl.ashe.configuration;

import com.dangdang.config.service.zookeeper.ZookeeperConfigGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: ConfigService</p>
 *
 * @author hupenglong
 * @date 2020-07-08 20:49
 */
@Configuration
public class ConfigService {
    @Autowired
    private ZookeeperConfigGroup configGroup;

    public String getString(String key) {
        try {
            String result = configGroup.get(key);
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
