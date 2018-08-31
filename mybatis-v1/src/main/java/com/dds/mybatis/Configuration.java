package com.dds.mybatis;

import java.util.HashMap;

public class Configuration {

    public String getSql(String fullName) {
        return Sql.map.get(fullName);
    }

    public <T> T getMapper(SqlSession session, Class<T> clz){
        MapperProxy mapperProxy = new MapperProxy(session);
        return mapperProxy.newInstance(clz);
    }

    private static class Sql {
        private static HashMap<String, String> map = new HashMap<>();

        static {
            map.put("interface com.dds.mybatis.EmployeeMapper#selectById", "select * from EMP where empno = ?");
        }
    }

}
