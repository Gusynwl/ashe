package com.hpl.ashe.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * <p>Title: ContainerInstance</p>
 *
 * @author hupenglong
 * @date 2020-08-23 17:56
 */
@Slf4j
public class ContainerInstance {
    private static ThreadLocal<String> uniqueIdLocal = new ThreadLocal<>();

    public static void setUniqueId() {
        uniqueIdLocal.set(getUUID());
    }

    public static void setUniqueId(String uuid) {
        uniqueIdLocal.set(uuid);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getUniqueId() {
        return uniqueIdLocal.get();
    }

    public static void remove() {
        uniqueIdLocal.remove();
    }
}
