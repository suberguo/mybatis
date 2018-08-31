package com.dds.mybatis.executor;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultExecutor implements Executor {

    @Override
    public <T> List<T> query(String sql, Object[] parameters, Class<T> clz) throws Exception {

        List<T> list = new ArrayList<T>();
        Driver driver = (Driver)Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@10.188.136.116:1521:workflow", "SCOTT", "123456");
        ResultSet resultSet = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                stmt.setObject(i + 1, parameters[i]);
            }
            resultSet = stmt.executeQuery();
            Field[] fields = clz.getDeclaredFields();

            while (resultSet.next()) {
                T object = clz.newInstance();
                for (Field f : fields) {
                    f.setAccessible(true);
                    f.set(object, resultSet.getObject(f.getName().toUpperCase()));
                    f.setAccessible(false);
                }
                list.add(object);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    @Override
    public void execute(String sql, Object[] parameter) throws Exception {

    }

}
