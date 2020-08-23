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
 * <p>Title: DubboProviderFilter</p>
 *
 * @author hupenglong
 * @date 2020-08-23 18:03
 */
@Slf4j
@Activate(group = Constants.PROVIDER)
public class DubboProviderFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //获取上有服务传递的UUID
        String traceId = (String) RpcContext.getContext().get("ashe-traceId");
        log.info("traceId={}", traceId);
        log.info("DubboProviderFilter");
        ContainerInstance.setUniqueId(traceId);
        return invoker.invoke(invocation);
    }
}
