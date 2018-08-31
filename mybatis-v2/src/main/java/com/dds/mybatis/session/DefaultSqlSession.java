package com.dds.mybatis.session;

import com.dds.mybatis.Configuration;
import com.dds.mybatis.executor.DefaultExecutor;

import java.util.List;


public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private DefaultExecutor executor;

    public DefaultSqlSession(Configuration configuration, DefaultExecutor defaultExecutor) {
        this.configuration = configuration;
        this.executor = defaultExecutor;
    }

    @Override
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

    @Override
    public <T> List<T> selectList(String method, Object[] parameters, Class<T> clz) throws Exception {
        String sql = this.configuration.getSql(method);
        return this.executor.query(sql, parameters, clz);
    }

    @Override
    public <T> T getMapper(Class<T> clz) {
        return this.configuration.getMapper(this,clz);
    }
}
