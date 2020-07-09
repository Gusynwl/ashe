package com.hpl.ashe.listeners;

import com.hpl.ashe.utils.AsheApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * <p>Title: AsheApplicationContextListeners</p>
 *
 * @author hupenglong
 * @date 2020-07-08 20:51
 */
public class AsheApplicationContextListeners implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AsheApplicationContext.setContext(event.getApplicationContext());
    }
}
