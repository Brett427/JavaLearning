package com.controller;

import com.pojo.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by brett on 2017/8/20.
 */
@Controller
public class BookController {

    /**
     * 自动注入BookService
     * */
    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    /**
     * 处理/main请求
     * */
    @RequestMapping(value="/main")
    public String main(Model model){
        // 获得所有图书集合
        List<Book> book_list = bookService.getall();
        // 将图书集合添加到model当中
        model.addAttribute("book_list", book_list);
        // 跳转到main页面
        return "main";
    }

}