package com.dds.mybatis.executor;


import com.dds.mybatis.handler.ParameterSetHandler;
import com.dds.mybatis.handler.ResultSetHandler;
import com.dds.mybatis.handler.StatementHandler;
import java.sql.*;
import java.util.List;

public class DefaultExecutor implements Executor {

    @Override
    public <T> List<T> query(String sql, Object[] parameters, Class<T> clz) throws Exception {
        ResultSet resultSet = null;
        ResultSetHandler resultSetHandler = new ResultSetHandler();
        StatementHandler statementHandler = new StatementHandler();
        ParameterSetHandler parameterSetHandler = new ParameterSetHandler();
        try {
            PreparedStatement stmt = statementHandler.handlePreparedStatement(sql);
            parameterSetHandler.handle(stmt,parameters);
            resultSet = stmt.executeQuery();
            return resultSetHandler.handle(resultSet,clz);
        }  finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    @Override
    public void execute(String sql, Object[] parameter) throws Exception {

    }

}
