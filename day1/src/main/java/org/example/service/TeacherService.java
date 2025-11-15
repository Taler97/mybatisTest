package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.TeacherMapper;
import org.example.unity.Teacher;
import org.example.utils.MyBatisUtil;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TeacherService {
    private SqlSession session=MyBatisUtil.getSqlSession();

    public  void initTeachers(){
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
    public  int deleteByAge(){
        Map<String,Object> params=new HashMap<>();
        params.put("minAge",35);
        int lines = session.getMapper(TeacherMapper.class).deleteByCondition(params);
        MyBatisUtil.commitAndCloseSession(session);
        System.out.println("已删除"+lines+"条数据");
        return lines;
    }
    public  double getJiLinAvrSal(){
        double averageSalary = session.getMapper(TeacherMapper.class).getJilinAverageSalary();
        System.out.println("吉林省员工平均薪资："+averageSalary);
        return getJiLinAvrSal();
    }
    public void selectJiangSuTeacher(){
            MyBatisUtil.executeQuery(TeacherMapper.class,
                    teacherMapper -> teacherMapper.selectByCondition(Map.of("addr","江苏省")));

    }
    public int promote(){
        int lines = MyBatisUtil.executeUpdate(TeacherMapper.class,
                TeacherMapper::promoteSalesToManager);
        System.out.println("已升职员工数："+lines);
        return lines;

    }
}

