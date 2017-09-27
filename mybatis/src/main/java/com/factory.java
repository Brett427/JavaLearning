package com;


import com.Mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class factory {
    public static void main(String[] args)
    {

        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
//          Book book = (Book) session.selectOne("org.mybatis.example.BookMapper.selectBook",1);
            List<Book> books = new ArrayList<Book>();
            BookMapper bookMapper  = session.getMapper(BookMapper.class);
            books = bookMapper.selectBooks(666.0);
            for(int i=0;i<books.size();i++)
            {
                System.out.println(books.get(i).getId());
            }
//            System.out.println(book.getId());
        } finally {
            session.close();
        }
    }


}
