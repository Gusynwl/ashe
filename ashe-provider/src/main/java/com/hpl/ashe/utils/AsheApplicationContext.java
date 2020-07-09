package com.hpl.ashe.utils;

import org.springframework.context.ApplicationContext;

/**
 * <p>Title: AsheApplicationContext</p>
 *
 * @author hupenglong
 * @date 2020-07-08 20:50
 */
public class AsheApplicationContext {
    private static ApplicationContext context;

    public static void setContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> t) {
        return context.getBean(t);
    }
}
