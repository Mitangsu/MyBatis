package com.atguigu.mybatis.utils;

import com.atguigu.mybatis.mapper.ParameterMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Su
 * @create 2022-04-12 14:18
 */
public class SqlSessionUtils {

    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            sqlSession = build.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;


    }
}
