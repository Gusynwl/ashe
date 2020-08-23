package com.hpl.ashe.provider;

import java.util.Date;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hpl.ashe.api.DemoService;
import com.hpl.ashe.api.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    private OrderService orderService;

    @Override
    public String sayHello(String name) {
        log.info(name);
        String orderName = orderService.getOrder("orderName");
        return "Hello, " + name + ", " + new Date() + ",orderName=" + orderName;
    }

}