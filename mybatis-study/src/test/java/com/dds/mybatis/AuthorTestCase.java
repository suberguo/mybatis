package com.dds.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AuthorTestCase {

    @DisplayName("test Author")
    @Test
    public void test(){

        SqlSession session = null;
        try {
            session = Mysql.getSession();
            AuthorMapper mapper = session.getMapper(AuthorMapper.class);
            //mapper.delete(2);
            mapper.add(new Author(1,"wanjiali"));
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


}
