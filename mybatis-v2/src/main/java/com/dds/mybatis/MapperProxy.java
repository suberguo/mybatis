package com.dds.mybatis;

import com.dds.mybatis.session.DefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MapperProxy implements InvocationHandler {

    private DefaultSqlSession session;

    public MapperProxy(DefaultSqlSession session) {
        this.session = session;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return this.session.selectOne(proxy.getClass().getInterfaces()[0] + "#" + method.getName(),
                    args, method.getReturnType());
        }
    }

    public <T> T newInstance(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(),
                new Class[]{clz},
                this);
    }

}
