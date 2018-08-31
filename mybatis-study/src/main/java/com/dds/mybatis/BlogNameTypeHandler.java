package com.dds.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.*;


public class BlogNameTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(i,s.replaceAll("\\$",""));
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        if("name".equals(s)) {
            return "$"+resultSet.getString(s)+"$";
        }else{
            return resultSet.getString(s);
        }
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if(i ==1) {
            return "$"+resultSet.getString(i)+"$";
        }else{
            return resultSet.getString(i);
        }
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }
}
