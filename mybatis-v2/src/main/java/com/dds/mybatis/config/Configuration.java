package com.dds.mybatis.config;

import com.dds.mybatis.mapper.MapperProxy;
import com.dds.mybatis.executor.DefaultExecutor;
import com.dds.mybatis.executor.Executor;
import com.dds.mybatis.session.DefaultSqlSession;

import java.util.HashMap;

public class Configuration {

    public String getSql(String fullName) {
        return Sql.map.get(fullName);
    }

    public <T> T getMapper(DefaultSqlSession session, Class<T> clz){
        MapperProxy mapperProxy = new MapperProxy(session);
        return mapperProxy.newInstance(clz);
    }

    public Executor newExecutor(){
        return new DefaultExecutor();
    }

    private static class Sql {
        private static HashMap<String, String> map = new HashMap<>();

        static {
            map.put("interface com.dds.mybatis.EmployeeMapper#selectById", "select * from EMP where empno = ?");
        }
    }

}
