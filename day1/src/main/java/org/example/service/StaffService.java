package org.example.service;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.example.entity.Staff;
import org.example.mapper.StaffMapper;
import org.example.utils.MyBatisUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StaffService {
    public static void batchInsertStaff(){
        List<Staff> staffList=new ArrayList<>();
        staffList.add(Staff.builder()
                .id(7)
                .name("张丽")
                .addr("江苏省南京市")
                .age(32)
                .job("销售员")
                .sal(new BigDecimal("7000"))
                .build());

        staffList.add(Staff.builder()
                .id(8)
                .name("张伟")
                .addr("江苏省苏州市")
                .age(26)
                .job("职员")
                .sal(new BigDecimal("5000"))
                .build());

        staffList.add(Staff.builder()
                .id(9)
                .name("王晓")
                .addr("上海市")
                .age(30)
                .job("区域总监")
                .sal(new BigDecimal("20000"))
                .build());

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        sqlSession.getMapper(StaffMapper.class).batchInsert(staffList);
        MyBatisUtil.commitAndCloseSession(sqlSession);
    }

    public static void deleteStaffByProvince(String province){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        sqlSession.getMapper(StaffMapper.class).deleteByAddr(province);
        MyBatisUtil.commitAndCloseSession(sqlSession);
    }

    public static void ariseSalByAge(int age){
        SqlSession session=MyBatisUtil.getSqlSession();
        session.getMapper(StaffMapper.class).raiseSalaryByAge(age,new BigDecimal(1000));
        MyBatisUtil.commitAndCloseSession(session);
        System.out.println("已提升超过27岁员工薪资");
        MyBatisUtil.executeQuery(StaffMapper.class,staffMapper -> staffMapper.selectByAge(27));
    }

    public static void selectByAddr(int pageNum){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PageHelper.startPage(pageNum,3);
        sqlSession.getMapper(StaffMapper.class).selectByAddr("江苏");
    }
}
