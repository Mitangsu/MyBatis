package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
        import com.atguigu.mybatis.utils.SqlSessionUtils;
        import org.apache.ibatis.session.SqlSession;
        import org.junit.Test;

/**
 * @author Su
 * @create 2022-04-13 7:55
 */
public class SelectMapperTest {

    /**
     * MyBatis的各种查询功能：
     * 1.若查询出的数据只有一条,
     * >可以通过实体类对象接收
     * >可以通过List集合接收
     * >可以通过map集合接收
     * 结果:{password=123456, sex=男, id=1, age=23, email=123@qq.com, username=李斯}
     * 2.若查询出的数据有多条,
     * >可以通过List集合接收
     * >可以通过map类型的list集合接收
     * >可以在mapper接口的方法上添加@MapKey注解,此时就可以将每条数据转换的map集合作为值,以某个字段的值作为键，放在同一个map集合中
     * 注意:一定不能通过实体类对象接收,此时会抛TooManyResultsException,
     * MyBatis中设置了默认的类型别名
     * Java.lang.Integer -->int,integer
     * int -->int,integer
     * Map-map
     * String-->string
     *
     */

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(1));
    }


    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(5));
    }
}
