package com.service;

import com.pojo.User;

/**
 * Created by brett on 2017/8/19.
 */

public interface UserService {
    User login(String loginname, String password);
}
