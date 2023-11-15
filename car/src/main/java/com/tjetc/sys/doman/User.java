package com.tjetc.sys.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //⽤户的id
    private Integer userid;
    //登录名称
    private String loginName;
    //身份证号码
    private String identity;
    //真是姓名
    private String realName;
    //性别
    private Integer sex;
    //地址
    private String address;
    //电话
    private String phone;
    //密码
    private String pwd;
    //职位
    private String position;
    //⽤户类型
    private Integer type;
    //是否可⽤
    private Integer available;
}
