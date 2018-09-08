package com.dds.mybatis.session;

import com.dds.mybatis.config.Configuration;

public class SqlSessionBuilder {

    private Configuration configuration;

    public SqlSessionBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession(){
       return new DefaultSqlSession(this.configuration,this.configuration.newExecutor());
    }
}
