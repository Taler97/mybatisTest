package org.example.mapper;

import org.example.unity.Teacher;
import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    List<Teacher> selectAllTeachers();
    int batchInsertTeachers(List<Teacher> teachers);
    int insertTeacher(Teacher teacher);
    int deleteTeacher();
    int batchDelete(int[] ids);
    int batchInsert();
    List<Teacher> selectByCondition(Map<String, Object> params);

}