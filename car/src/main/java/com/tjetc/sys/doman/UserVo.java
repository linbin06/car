package com.tjetc.sys.doman;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)


@Data
public class UserVo extends User {
    /**
     * 分⻚的参数
     */
    private Integer page;
    private Integer limit;
    private String code;
    /**
     * 接收多个⻆⾊的id
     */
    private Integer[] ids;
}