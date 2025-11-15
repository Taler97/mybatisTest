package org.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.function.Function;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            System.out.println("session配置失败");
            System.out.println(e.getMessage());
        }
    }

    public static SqlSession getSqlSession() {
        SqlSession session = sqlSessionFactory.openSession();
        if (session!=null) {
            System.out.println("成功获取session");
            return session;}
    return null;

    }
    public static <T, R> R executeQuery(Class<T> mapperClass, Function<T, R> function) {
        try (SqlSession session = getSqlSession()) {
            T mapper = session.getMapper(mapperClass);
            return function.apply(mapper);
        }
    }
    public static <T> int executeUpdate(Class<T> mapperClass, Function<T, Integer> function) {
        SqlSession session = getSqlSession();
        try {
            T mapper = session.getMapper(mapperClass);
            int result = function.apply(mapper);
            return result;
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            commitAndCloseSession(session);
        }
    }
    public static void commitAndCloseSession(SqlSession session){
        session.commit();
        System.out.println("事务已提交");
        session.close();
        System.out.println("已关闭session");
    }

}