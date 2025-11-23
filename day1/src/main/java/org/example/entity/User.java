package org.example.entity;

import lombok.Data;
import java.util.Date;

/**
 * 用户表实体类
 */
@Data
public class User {
    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 最后访问时间
     */
    private Date lasttime;
}