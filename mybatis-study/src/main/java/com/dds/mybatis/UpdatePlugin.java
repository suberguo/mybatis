package com.dds.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts(@Signature(type=Executor.class,method = "update",args = {MappedStatement.class,Object.class}))
public class UpdatePlugin implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("lanjie");
        return invocation.proceed();
    }

    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    public void setProperties(Properties properties) {
        System.out.println(properties.getProperty("name"));

    }
}
