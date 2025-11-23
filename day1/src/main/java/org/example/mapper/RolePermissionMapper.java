package org.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.entity.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(@Param("rid") Integer rid, @Param("pid") Integer pid);

    int insert(RolePermission row);

    List<RolePermission> selectAll();
}