package com.hpl.ashe.configuration.datasource.aspect;

import com.hpl.ashe.configuration.datasource.annotation.ReadOnly;
import com.hpl.ashe.configuration.datasource.config.DataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * <p>Title: AsheDataSourceAdvice</p>
 *
 * @author hupenglong
 * @date 2020-06-29 11:59
 */
@Aspect
@Component
public class AsheDataSourceAdvice implements Ordered {

    @Around("execution(* com.hpl.ashe.service..*.insert*(..)) " +
            "|| execution(* com.hpl.ashe.service..*.add*(..)) " +
            "|| execution(* com.hpl.ashe.service..*.save*(..)) " +
            "|| execution(* com.hpl.ashe.service..*.update*(..)) " +
            "|| execution(* com.hpl.ashe.service..*.edit*(..)) " +
            "|| execution(* com.hpl.ashe.service..*.modify*(..)) " +
            "|| execution(* com.hpl.ashe.service..*.delete*(..)) " +
            "|| execution(* com.hpl.ashe.service..*.remove*(..))")
    public Object setWrite(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            DataSourceContextHolder.setDbType(DataSourceContextHolder.WRITE);
            return joinPoint.proceed();
        } finally {
            DataSourceContextHolder.clearDbType();
        }
    }

    @Around("@annotation(readOnly)")
    public Object setRead(ProceedingJoinPoint joinPoint, ReadOnly readOnly) throws Throwable {
        try {
            DataSourceContextHolder.setDbType(DataSourceContextHolder.READ);
            return joinPoint.proceed();
        } finally {
            DataSourceContextHolder.clearDbType();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
