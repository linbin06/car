package com.tjetc.sys.service;

import com.tjetc.sys.doman.User;
import com.tjetc.sys.doman.UserVo;
import org.springframework.stereotype.Component;

public interface IUserService {
    /**
     * ⽤户登录
     */
    User login(UserVo userVo);
}