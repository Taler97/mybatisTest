package org.example.mapper;

import java.util.List;
import org.example.entity.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Permission row);

    Permission selectByPrimaryKey(Integer pid);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission row);
}