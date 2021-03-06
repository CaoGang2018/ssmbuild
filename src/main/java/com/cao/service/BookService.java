package com.cao.service;

import com.cao.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author admin_cg
 * @data 2020/10/3 15:34
 */
public interface BookService {
    // 增加一本书
    int addBook(Books books);

    // 删出一本书
    int deleteBookById(int id);

    // 更新一本书
    int updateBook(Books books);

    // 查询一本书
    Books queryBookById(int id);

    // 查询所有书
    List<Books> queryAllBook();
    // 查询书名
    List<Books> queryBookByName(String bookName);
}
