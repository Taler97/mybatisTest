package org.example.mapper;

import org.example.unity.Teacher;
import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    List<Teacher> selectAllTeachers();
    int batchInsertTeachers(List<Teacher> teachers);
    int insertTeacherById(Teacher teacher);
    int batchDelete(int[] ids);
    int batchInsert();
    int deleteByCondition(Map<String, Object> condition);
    List<Teacher> selectByCondition(Map<String, Object> params);
    double getJilinAverageSalary();
    int promoteSalesToManager();
}