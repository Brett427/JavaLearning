package com.service;

import com.mapper.BookMapper;
import com.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brett on 2017/8/19.
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    /**
     * 自动注入BookMapper
     * */
    @Autowired
    private BookMapper bookMapper;

    /**
     * BookService接口getAll方法实现
     * @see { BookService }
     * */
    @Override
    public List<Book> getall() {
        return bookMapper.findAll();
    }

}