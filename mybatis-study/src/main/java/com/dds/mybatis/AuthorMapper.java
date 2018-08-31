package com.dds.mybatis;

import java.util.List;

public interface AuthorMapper {

    Author get(int id);

    List<Author> list(int id);

    void add(Author author);

    void update(Author author);

    void  delete(int id);

}
