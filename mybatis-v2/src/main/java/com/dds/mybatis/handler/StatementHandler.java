package com.dds.mybatis.handler;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class StatementHandler {

    public PreparedStatement handlePreparedStatement(String sql) throws Exception {
        Driver driver = (Driver)Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@10.188.136.116:1521:workflow", "SCOTT", "123456");
        return  connection.prepareStatement(sql);
    }
}
