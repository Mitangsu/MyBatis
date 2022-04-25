package test;

import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Su
 * @create 2022-04-14 16:51
 */
public class CacheMapperTest {

    //mybatis中一级缓存是默认开启的，作用域很小，是同一个sqlSession
    @Test
    public void testOneCache(){
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp empById = mapper1.getEmpById(1);
        System.out.println(empById);
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp empById1 = mapper2.getEmpById(1);
        System.out.println(empById1);


    }

    @Test
    public void testTowCache()  {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlsessionfactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpById(1));
            sqlSession1.close();
            SqlSession sqlSession2 = sqlsessionfactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpById(1));
            sqlSession2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
