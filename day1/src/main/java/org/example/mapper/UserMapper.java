package org.example.mapper;

import org.example.DTO.UserPermissionDTO;
import org.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    User selectByPrimaryKey(Integer uid);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    List<String> selectUserRoles(String uname);

    UserPermissionDTO selectUserAuthInfo(String uname);

    int updateLastTime(Integer uid);

    String getPwdByUname(String uname);
}