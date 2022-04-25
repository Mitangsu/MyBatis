package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Su
 * @create 2022-04-12 14:14
 */
public class ParameterMapperTest {

    /**
     *
     *
     * MyBatis获取参数值的两种方式:${}和#{}
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     * MyBatis获取参数值的各种情况
     * 1.mapper接口方法的参数为单个的字面量类型
     * 可以通过${}和#{}以任意的字符串获取参数参数值,但是需要注意${}单引号问题
     * 2.mapper接口方法的参数为多个时 (MyBatis3.5.9版本是以自定义字段名称为键)
     * 此时Mybatis会将这些参数放在一个map集合中,以两种方式进行存储
         * -以arg0,arg1...为键,以参数位置
         * -以param1,param2...为键,以参数位置
     * 因此只需要通过#{}和${}以键的方式访问值即可,但是需要注意${}的单引号问题
     * 3.若mapper接口方法的参数有多个时,可以手动将这些参数放在一个map中存储
     *   因此只需要通过#{}和${}以键的方式访问值即可,但是需要注意${}的单引号问题
     * 4.mapper接口方法的参数是一个实体类类型的参数
     *   因此只需要通过#{}和${}以键的方式访问值即可,但是需要注意${}的单引号问题
     * 5.使用@Param注解命名参数
     * 此时Mybatis会将这些参数放在一个map集合中,以两种方式进行存储
     * >以@Param注解的值为键，以参数为值
     * >以param1,param2..为键
     * 可以通过${}和#{}以任意的字符串获取参数参数值,但是需要注意${}单引号问题
     */

    //5.根据姓名和密码查询(@Param)
    @Test
    public void testCheckLogByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("Jorry", "123456");
        System.out.println(user);

    }



    //4.根据实体类类型插入数据
    @Test
    public void testInsertUser()  {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int i = mapper.insertUser(new User(null, "李四", "132", 23, "男", "123@qq.com"));
        System.out.println(i);

    }

    //3.根据姓名和密码查询(自己创建Map集合)
    @Test
    public void testCheckLogByMap()  {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","Jorry");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);

    }

    //2.根据姓名和密码查询
    @Test
    public void testCheckLog()  {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("Jorry", "123456");
        System.out.println(user);

    }

    //1.查询用户名信息
    @Test
    public void testUserByUsername()  {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUserName("Jorry");
        System.out.println(user);

    }

    //查询所有用户信息
    @Test
    public void testGetAllUser()  {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));

    }

}







