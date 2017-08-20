package com.service;

import com.mapper.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by brett on 2017/8/19.
 */

@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * UserService接口login方法实现
     * @see { UserService }
     * */
    @Override
    public User login(String loginname, String password) {
        return userMapper.findWithNameandPassword(loginname, password);
    }

}
