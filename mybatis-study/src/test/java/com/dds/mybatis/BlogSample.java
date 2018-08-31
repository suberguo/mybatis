package com.dds.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;


public class BlogSample {

    @Test
    public void test(){

        SqlSession session = null;
        try {
            session = Mysql.getSession();
            //Blog blog = (Blog) session.selectOne("com.dds.mybatis.BlogMapper.selectBlogAndPost",1);
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlogAndPost(1);

            //Author author = mapper.selectBlogAndAuthor(1);
            //for(Post p : blog.getPosts()){
            //   System.out.println(p);
            //}
            //System.out.println(blog.getPosts().size());
            System.out.println(blog.getText());
            System.out.println(blog.getPosts().get(0));

            System.out.println("----------------");


            Blog blog2 = mapper.selectBlogAndPost(1);
            System.out.println(blog2.getText());
            System.out.println(blog2.getPosts().get(0));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
    }

}
