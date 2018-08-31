package com.dds.mybatis;


import org.apache.ibatis.annotations.Select;

public interface BlogMapper {

    Blog selectBlog(int id);

    Blog selectBlogAndAuthor(int id);

    Blog selectBlogAndPost(int id);

    @Select("select name from Blog where id=#{id}")
    String selectName(int id);

    void addBlog(int id, String name);
}
