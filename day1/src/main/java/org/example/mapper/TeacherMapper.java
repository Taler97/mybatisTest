package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.unity.Teacher;
import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    @Select("select  * from teacher")
    List<Teacher> selectAllTeachers();
    int deleteById(Integer id);
    int updateById(Teacher teacher);
    int insertTeacherById(Teacher teacher);
    int batchInsertTeachers(List<Teacher> teachers);
    int batchDelete(int[] ids);
    int deleteByCondition(Map<String, Object> condition);
    List<Teacher> selectByCondition(Map<String, Object> params);
    double getJilinAverageSalary(String province);
    int promoteSalesToManager();
}