package com.hpl.ashe.controller;

import com.hpl.ashe.api.DemoService;
import com.hpl.ashe.utils.ContainerInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: DemoController</p>
 *
 * @author hupenglong
 * @date 2020-08-23 17:40
 */
@RestController()
@Slf4j
public class DemoController {
    @Autowired
    DemoService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam("name") String name) {
        log.info(ContainerInstance.getUniqueId() + "---" + name);
        return demoService.sayHello(ContainerInstance.getUniqueId() + "---" + name);
    }
}
