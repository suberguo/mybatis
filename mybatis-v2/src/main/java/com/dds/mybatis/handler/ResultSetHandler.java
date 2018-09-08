package com.dds.mybatis.handler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ResultSetHandler {

    public <T> List<T> handle(ResultSet resultSet, Class<T> clz) throws Exception {
        List<T> list = new ArrayList<T>();
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

        return list;
    }

}
