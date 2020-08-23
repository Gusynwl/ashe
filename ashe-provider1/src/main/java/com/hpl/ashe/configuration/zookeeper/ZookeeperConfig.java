package com.hpl.ashe.configuration.zookeeper;

import com.dangdang.config.service.zookeeper.ZookeeperConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: ZookeeperConfig</p>
 *
 * @author hupenglong
 * @date 2020-06-22 15:35
 */
@Configuration
public class ZookeeperConfig {

    @Value("${config.server.zk}")
    private String connectStr;
    @Value("${config.server.project}")
    private String rootNode;
    @Value("${config.server.version}")
    private String version;
    @Value("${config.server.group}")
    private String group;

    @Bean
    public ZookeeperConfigProfile zookeeperConfigProfile() {
        return new ZookeeperConfigProfile(connectStr, rootNode, version);
    }

    @Bean
    public ZookeeperConfigGroup zookeeperConfigGroup(ZookeeperConfigProfile zookeeperConfigProfile) {
        return new ZookeeperConfigGroup(zookeeperConfigProfile, group);
    }

}
