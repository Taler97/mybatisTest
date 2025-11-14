package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.TeacherMapper;
import org.example.unity.Teacher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherService {
    public static void initTeachers(){
        SqlSession session = MyBatisUtil.getSqlSession();
        try {
            session.getConnection().createStatement().execute("DROP TABLE IF EXISTS teacher");
            session.getConnection().createStatement().execute(
                    "CREATE TABLE teacher (" +
                            "    id INT AUTO_INCREMENT PRIMARY KEY, " +
                            "    name VARCHAR(50) NOT NULL, " +
                            "    addr VARCHAR(255), " +
                            "    age INT, " +
                            "    job VARCHAR(255), " +
                            "    sal INT" +
                            ")"
            );
            List<Teacher> teachers = Arrays.asList(
                    Teacher.builder().name("张三").addr("江苏省南京市").age(35).job("区域总监").sal(20000).build(),
                    Teacher.builder().name("李四").addr("江苏省苏州市").age(32).job("销售经理").sal(15000).build(),
                    Teacher.builder().name("王五").addr("四川省成都市").age(26).job("销售员").sal(8000).build(),
                    Teacher.builder().name("赵六").addr("吉林省长春市").age(27).job("财务").sal(10000).build(),
                    Teacher.builder().name("刘七").addr("吉林省吉林市").age(24).job("销售员").sal(6000).build(),
                    Teacher.builder().name("吴八").addr("陕西省西安市").age(31).job("销售员").sal(7000).build()
            );

            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            int result = mapper.batchInsertTeachers(teachers);
            session.commit();

            System.out.println("初始化完成，插入 " + result + " 条数据");

        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void selectAllTeachers(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
            sqlSession.getMapper(TeacherMapper.class).selectAllTeachers();
            sqlSession.close();
    }
    public static void insertTeacher(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        int lines = sqlSession.getMapper(TeacherMapper.class).insertTeacher(
                Teacher.builder().name("刘七").age(24).job("销售员").addr("吉林省长春市").sal(6000).build()
        );
        sqlSession.commit();
        System.out.println("影响行数"+lines);
            sqlSession.close();
        }

    public static void batchDeleteTeacher(int[] ids){
        SqlSession session=MyBatisUtil.getSqlSession();
        int lines = session.getMapper(TeacherMapper.class).batchDelete(ids);
        System.out.println("影响行数"+lines);
        MyBatisUtil.commitAndCloseSession(session);
    }

    public static List<Teacher> findTeachers(String name, String job, Integer minAge,
                                      Integer maxAge, Integer minSal, Integer maxSal, String addr) {
        Map<String, Object> params = new HashMap<>();

        // 动态设置参数，null的参数不会参与查询
        if (name != null) params.put("name", name);
        if (job != null) params.put("job", job);
        if (minAge != null) params.put("minAge", minAge);
        if (maxAge != null) params.put("maxAge", maxAge);
        if (minSal != null) params.put("minSal", minSal);
        if (maxSal != null) params.put("maxSal", maxSal);
        if (addr != null) params.put("addr", addr);

        return MyBatisUtil.executeQuery(org.example.mapper.TeacherMapper.class,
                mapper -> mapper.selectByCondition(params)
        );
    }
    }

