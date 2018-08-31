package com.dds.mybatis.session;

import java.util.List;

public interface SqlSession {

    <T> T selectOne(String method,Object[] parameters,Class<T> clz) throws Exception;

    <T> List<T> selectList(String method, Object[] parameters, Class<T> clz) throws Exception;

    <T> T getMapper(Class<T> clz);

    void commit();

    void close();
}
