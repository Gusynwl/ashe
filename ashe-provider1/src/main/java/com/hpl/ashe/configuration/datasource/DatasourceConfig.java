package com.hpl.ashe.configuration.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.hpl.ashe.configuration.ConfigService;
import com.hpl.ashe.configuration.datasource.config.AsheAbstractRoutingDataSource;
import com.hpl.ashe.configuration.datasource.config.DataSourceContextHolder;
import com.hpl.ashe.constant.CommonConstant;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: DatasourceConfig</p>
 *
 * @author hupenglong
 * @date 2020-07-09 18:17
 */
@Configuration
public class DatasourceConfig {
    @Autowired
    private ConfigService configService;

    @Bean
    @Primary
    public DataSourceProperties getDataSourceProperties() {
        DataSourceProperties properties = new DataSourceProperties();
        properties.setType(DruidDataSource.class);
        return properties;
    }

    @Bean(name = "writeDatasource")
    @Primary
    public DruidDataSource writeDatasource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(configService.getString(CommonConstant.Mysql.Master.DATASOURCE_URL));
        dataSource.setUsername(configService.getString(CommonConstant.Mysql.Master.DATASOURCE_USERNAME));
        dataSource.setPassword(configService.getString(CommonConstant.Mysql.Master.DATASOURCE_PASSWORD));
        return dataSource;
    }

    @Bean(name = "readDataSource")
    public DruidDataSource readDatasource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(configService.getString(CommonConstant.Mysql.Slave.DATASOURCE_URL));
        dataSource.setUsername(configService.getString(CommonConstant.Mysql.Slave.DATASOURCE_USERNAME));
        dataSource.setPassword(configService.getString(CommonConstant.Mysql.Slave.DATASOURCE_PASSWORD));
        return dataSource;
    }

    @Bean
    public AbstractRoutingDataSource routingDataSource() {
        AsheAbstractRoutingDataSource proxy = new AsheAbstractRoutingDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DataSourceContextHolder.WRITE, writeDatasource());
        targetDataSources.put(DataSourceContextHolder.READ, readDatasource());
        proxy.setDefaultTargetDataSource(readDatasource());
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(routingDataSource());
//        mybatis的XML的配置
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        bean.setMapperLocations(resolver.getResources(""));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(routingDataSource());
    }
}
