package com.hpl.ashe;

import com.hpl.ashe.api.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Title: ConsumerTest</p>
 *
 * @author hupenglong
 * @date 2020-07-09 19:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ConsumerTest {
    @Autowired
    private DemoService demoService;

    @Test
    public void test() {
        log.info(demoService.sayHello("demo"));
    }
}
