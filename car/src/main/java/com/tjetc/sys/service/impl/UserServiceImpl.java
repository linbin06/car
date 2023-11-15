package com.tjetc.sys.service.impl;

import com.tjetc.sys.doman.User;
import com.tjetc.sys.doman.UserVo;
import com.tjetc.sys.mapper.UserMapper;
import com.tjetc.sys.service.IUserService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements IUserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * ⽤户登录的核⼼⽅法
     *
     * @param userVo
     * @return
     */
    @Override
    public User login(UserVo userVo) {
        //根据⽤户名和密码查询
        //从UserVo中⽤户输⼊的密码进⾏md5加密操作
        String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes()
        );
        userVo.setPwd(pwd);
        //调⽤userMapper接⼝中的查询⽅法
        return userMapper.login(userVo);
    }
}