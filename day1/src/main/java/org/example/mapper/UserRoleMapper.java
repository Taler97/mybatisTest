package org.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(@Param("uid") Integer uid, @Param("rid") Integer rid);

    int insert(UserRole row);

    List<UserRole> selectAll();
}