package org.example.mapper;

import java.util.List;
import org.example.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Role row);

    Role selectByPrimaryKey(Integer rid);

    List<Role> selectAll();

    int updateByPrimaryKey(Role row);
}