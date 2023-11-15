package com.tjetc.sys.mapper;

import com.tjetc.sys.doman.User;
import com.tjetc.sys.doman.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 查询⽤户信息
     * @param userVo
     * @return
     */
    User login(UserVo userVo);

}
