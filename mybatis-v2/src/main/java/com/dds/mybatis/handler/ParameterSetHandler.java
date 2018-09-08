package com.dds.mybatis.handler;

import java.sql.PreparedStatement;

public class ParameterSetHandler {

    public void handle(PreparedStatement statement, Object[] parameters) throws Exception {
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }
    }

}
