package com.hpl.ashe.utils;

import com.hpl.ashe.configuration.threadpool.ThreadPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>Title: BussinessThreadPool</p>
 *
 * @author hupenglong
 * @date 2020-07-08 20:50
 */
@Component
public class BussinessThreadPool {

    @Autowired
    private ThreadPoolConfig config;

    @Bean("asyncPool")
    public ThreadPoolTaskExecutor apiTaskAsyncPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(config.getCorePoolSize());
        executor.setMaxPoolSize(config.getMaxPoolSize());
        executor.setQueueCapacity(config.getQueueCapacity());
        executor.setKeepAliveSeconds(config.getKeepAliveSeconds());
        executor.setThreadNamePrefix("asyncThreadPool");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
