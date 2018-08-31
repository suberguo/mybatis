package com.dds.mybatis.executor;

import java.util.List;

public interface Executor {

    <T> List<T> query(String sql, Object[] parameter, Class<T> clz) throws Exception;
    void execute(String sql, Object[] parameter) throws Exception;
}
