package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * 工厂模式：如果创建某一个对象，使用的过程基本固定，那么我们就可以把创建这个对象的
 *           相关代码封装到一个“工厂类”中，以后都使用这个工厂类来“生产”我们需要的对象.
 *
 * 操作步骤：调用mapper接口中的方法根据mapper接口找到映射文件UserMapper.xml根据方法找到sql语句
 * @author Su
 * @create 2022-04-11 20:43
 */
public class MyBatisTest {
    @Test
    public void testMyBatis() throws IOException {
        //1.加载核心配置文件(字节输入流)
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //4.获取SqlSession(MyBatis操作数据库的会话对象)
        //SqlSession：代表Java程序和数据库之间的会话。
        //SqlSession默认不自动提交事务,若需要自动提交事务可以sqlSessionFactory.openSession(true);表示自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5.获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //6.测试功能
        int result = mapper.insertUser();
        System.out.println("result:"+result);
//      //7.提交事务 因为第4部已经设置自动提交了
//      sqlSession.commit();

    }
    @Test
    public void testUpdate() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();

    }

    @Test
    public void testDelete() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();

    }
    @Test
    public void testSelectById() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById();
        System.out.println(userById);

    }
    @Test
    public void testSelectAll() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);

    }
}















