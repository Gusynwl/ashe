package com.hpl.ashe.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Title: DubboLogInfoFilter</p>
 *
 * @author hupenglong
 * @date 2020-07-09 19:12
 */
@Slf4j
@Activate(group = Constants.PROVIDER)
public class DubboLogInfoFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long start = System.currentTimeMillis();
        Object[] arguments = invocation.getArguments();
        if (arguments.length > 0) {
            log.info("{}#{}#before:{}", invoker.getInterface(), invocation.getMethodName(), JSON.toJSONString(arguments[0]));
        }
        Result result = invoker.invoke(invocation);
        log.info("{}#{}#time:{}ms#after:{}", invoker.getInterface(), invocation.getMethodName(), System.currentTimeMillis() - start, JSON.toJSONString(result.getValue()));
        return result;
    }
}
