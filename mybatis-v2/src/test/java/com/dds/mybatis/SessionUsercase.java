package com.dds.mybatis;

import com.dds.mybatis.config.Configuration;
import com.dds.mybatis.session.SqlSession;
import com.dds.mybatis.session.SqlSessionBuilder;
import org.junit.Test;

public class SessionUsercase {

    @Test
    public void testSessionFun(){

        SqlSessionBuilder sessionBuilder = new SqlSessionBuilder(new Configuration());
        SqlSession session = sessionBuilder.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectById(123);
        System.out.println(employee);

    }

}
