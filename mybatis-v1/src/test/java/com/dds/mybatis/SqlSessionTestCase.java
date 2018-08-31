package com.dds.mybatis;

import org.junit.Test;

public class SqlSessionTestCase {

    @Test
    public void getdata(){
       Configuration configuration = new Configuration();
       Executor executor = new Executor();
       SqlSession session = new SqlSession(configuration, executor);
       EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
       Employee user = mapper.selectById(7499);
       System.out.println(user);
    }

}
