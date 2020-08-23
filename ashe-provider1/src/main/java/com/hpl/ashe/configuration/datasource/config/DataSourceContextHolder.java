package com.hpl.ashe.configuration.datasource.config;

/**
 * <p>Title: DataSourceContextHolder</p>
 *
 * @author hupenglong
 * @date 2020-06-29 11:59
 */
public class DataSourceContextHolder {
    public static final String WRITE = "write";
    public static final String READ = "read";
    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDbType(String dbType) {
        if (dbType == null) {
            throw new NullPointerException();
        }
        contextHolder.set(dbType);
    }

    public static String getDbType() {
        return contextHolder.get() == null ? WRITE : contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
