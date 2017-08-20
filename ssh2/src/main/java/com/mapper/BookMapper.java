package com.mapper;

import com.pojo.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by brett on 2017/8/18.
 */
@Component
public interface BookMapper {

    /**
     * 查询所有图书
     * @return 图书对象集合
     * */
    @Select(" select * from tb_book ")
    List<Book> findAll();

}

