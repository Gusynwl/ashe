package com.hpl.ashe.configuration.threadpool;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>Title: ThreadPoolConfig</p>
 *
 * @author hupenglong
 * @date 2020-07-09 18:26
 */
@Component
@ConfigurationProperties(prefix = "thread.pool")
@Data
public class ThreadPoolConfig {
    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;
}
