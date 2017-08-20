package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by brett on 2017/8/18.
 */
@Component
public interface UserMapper {
    @Select("select * from tb_user where loginname=#{loginname} and password = #{password}")
    User findWithNameandPassword(@Param("loginname")String loginname, @Param("password") String password);

}
