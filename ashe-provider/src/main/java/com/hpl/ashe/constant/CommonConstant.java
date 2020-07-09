package com.hpl.ashe.constant;

/**
 * <p>Title: CommonConstant</p>
 *
 * @author hupenglong
 * @date 2020-07-08 20:50
 */
public class CommonConstant {
    public static final class Dubbo {
        private Dubbo() {

        }
        public static final String REGISTRY_ADDRESS = "dubbo.registry.address";
        public static final String REGISTRY_ID = "dubbo.registry.id";
        public static final String PROTOCOL_NAME = "dubbo.protocol.name";
        public static final String PROTOCOL_PORT = "dubbo.protocol.port";
        public static final String APPLICATION_NAME = "dubbo.application.name";
        public static final String CONSUMER_TIMEOUT = "dubbo.consumer.timeout";
        public static final String REGISTRY_GROUP = "dubbo.registry.group";
        public static final String APPLICATION_ENV = "dubbo.application.env";
    }

    public static final class Redis {
        private Redis() {

        }
        public static final String REDIS_HOST = "spring.redis.host";
        public static final String REDIS_PASSWORD = "spring.redis.password";
        public static final String REDIS_PORT = "spring.redis.port";
        public static final String REDIS_TIMEOUT = "spring.redis.timeout";
        public static final String REDIS_DATASOURCE = "spring.redis.datasource";
        public static final String REDIS_JEDISPOOL_MAXACTIVE = "spring.redis.jedis.pool.max-active";
        public static final String REDIS_JEDISPOOL_MAXWAIT = "spring.redis.jedis.pool.max-wait";
        public static final String REDIS_JEDISPOOL_MAXIDLE = "spring.redis.jedis.pool.max-idle";
        public static final String REDIS_JEDISPOOL_MINIDLE = "spring.redis.jedis.pool.min-idle";

    }

    public static final class Mysql {
        public Mysql() {

        }
        public static final String DATASOURCE_TYPE = "spring.datasource.type";
        public static final String DATASOURCE_URL = "spring.datasource.druid.url";
        public static final String DATASOURCE_USERNAME = "spring.datasource.druid.username";
        public static final String DATASOURCE_PASSWORD = "spring.datasource.druid.password";
        public static final String DATASOURCE_DRIVER_CLASS_NAME = "spring.datasource.druid.driver-class-name";
        public static final String DATASOURCE_MAXACTIVE = "spring.datasource.druid.maxActive";
        public static final String DATASOURCE_INITIALSIZE = "spring.datasource.druid.initialSize";
        public static final String DATASOURCE_MINIDLE = "spring.datasource.druid.minIdle";

        public static final class Master {
            public static final String DATASOURCE_URL = "spring.datasource.druid.master.url";
            public static final String DATASOURCE_USERNAME = "spring.datasource.druid.master.username";
            public static final String DATASOURCE_PASSWORD = "spring.datasource.druid.master.password";
        }

        public static final class Slave {
            public static final String DATASOURCE_URL = "spring.datasource.druid.slave.url";
            public static final String DATASOURCE_USERNAME = "spring.datasource.druid.slave.username";
            public static final String DATASOURCE_PASSWORD = "spring.datasource.druid.slave.password";
        }

    }

    public static final class Mongo {
        public Mongo() {

        }

        public static final String DATA_MONGO_URI = "spring.data.mongo.uri";
    }

    public static final class RabbitMq {
        public RabbitMq() {

        }

        public static final String HOST = "spring.rabbitmq.host";
        public static final String PORT = "spring.rabbitmq.port";
        public static final String USERNAME = "spring.rabbitmq.username";
        public static final String PASSWORD = "spring.rabbitmq.password";
        public static final String VIRTUAL_HOST = "spring.rabbitmq.virtualhost";
        public static final String LISTENER_SIMPLE_CONCURRENCY = "spring.rabbitmq.listener.simple.concurrency";
        public static final String LISTENER_SIMPLE_MAXCONCURRENCY = "spring.rabbitmq.listener.simple.maxconcurrency";
    }
}
