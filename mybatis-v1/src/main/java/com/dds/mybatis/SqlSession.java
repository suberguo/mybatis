package com.dds.mybatis;

import java.util.List;


public class SqlSession {

    private Configuration configuration;
    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String method, Object[] parameters, Class<T> clz) throws Exception {
        String sql = this.configuration.getSql(method);
        List<T> list = this.executor.query(sql, parameters, clz);
        if (list.size() > 1) {
            throw new Exception("find more result");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public <T> List<T> selectList(String method, Object[] parameters, Class<T> clz) throws Exception {
        String sql = this.configuration.getSql(method);
        return this.executor.query(sql, parameters, clz);
    }

    public <T> T getMapper(Class<T> clz) {
        return this.configuration.getMapper(this,clz);
    }
}
