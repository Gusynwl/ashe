package com.hpl.ashe.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.hpl.ashe.utils.ContainerInstance;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Title: DubboConsumerFilter</p>
 *
 * @author hupenglong
 * @date 2020-08-23 18:03
 */
@Slf4j
@Activate(group = Constants.CONSUMER)
public class DubboConsumerFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //调用远程接口需要将UUID传递过去
        RpcContext.getContext().setAttachment("ashe-traceId", ContainerInstance.getUniqueId());
        log.info("ContainerInstance.getUniqueId()={}", ContainerInstance.getUniqueId());
        log.info("RpcContext.getContext().get={}",RpcContext.getContext().get("ashe-traceId"));
        log.info("DubboConsumerFilter");
        return invoker.invoke(invocation);
    }
}
