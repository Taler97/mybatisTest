package org.example.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Staff row);

    int batchInsert(List<Staff> staffList);

    Staff selectByPrimaryKey(Integer id);

    List<Staff> selectAll();

    @Delete("delete from staff WHERE addr LIKE CONCAT(#{province}, '%');")
    int deleteByAddr(@Param("province")String province);

    List<Staff> selectByAge(@Param("age") int age);

    @Select("select * from staff WHERE addr LIKE CONCAT(#{province}, '%');")
    List<Staff> selectByAddr(@Param("province")String province);

    int raiseSalaryByAge(@Param("minAge") int minAge,
                         @Param("amount") BigDecimal amount);
    int updateByPrimaryKey(Staff row);
}