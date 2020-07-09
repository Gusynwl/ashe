微服务框架模板

	1、基于springboot+dubbo+mybatis

	2、其中集成了druid、redis、rabbitmq、mongo、异步线程池asyncThreadPool

	3、mysql数据库实现读写分离
		1、基于注解(方法上使用@ReadOnly)
		2、基于方法名开头(方法以save/insert/delete/update等操作开头)
	4、自定义实现dubbo的filter，进行接口请求入参和出参的日志打印及接口请求时长的记录

	5、配置中心使用zookeeper

	6、dubbo服务的注册可通过@Service和DubboProviderConfig类进行暴露，不推荐使用注解

	7、dubbo服务的消费可通过@Reference和DubboConsumerConfig类进行消费，不推荐使用注解
