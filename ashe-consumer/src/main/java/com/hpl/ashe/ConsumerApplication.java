package com.hpl.ashe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * <p>Title: ConsumerApplication</p>
 *
 * @author hupenglong
 * @date 2020-07-09 19:21
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ConsumerApplication {


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ConsumerApplication.class);
        springApplication.run(args);
    }
}
