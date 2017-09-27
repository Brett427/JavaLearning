package com.Mapper;

import com.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    List<Book> selectBooks(@Param("price")Double dd);
}
