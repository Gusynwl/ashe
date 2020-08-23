package com.hpl.ashe.provider;

import com.hpl.ashe.api.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>Title: OrderServiceImpl</p>
 *
 * @author hupenglong
 * @date 2020-08-23 18:54
 */
@Component
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    public String getOrder(String orderName) {
        log.info(orderName);
        return "Hello, " + orderName + ", " + new Date();
    }
}
