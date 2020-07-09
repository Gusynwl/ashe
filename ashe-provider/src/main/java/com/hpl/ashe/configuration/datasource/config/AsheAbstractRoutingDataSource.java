package com.hpl.ashe.configuration.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>Title: AuxoAbstractRoutingDataSource</p>
 *
 * @author hupenglong
 * @date 2020-06-29 12:01
 */
public class AsheAbstractRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDbType();
    }
}
