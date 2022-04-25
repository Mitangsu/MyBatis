package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @author Su
 * @create 2022-04-14 18:29
 */
public class MBGTest {

    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//            //查询所有数据
//            List<Emp> emps = mapper.selectByExample(null);
//            emps.forEach(System.out::println);
//
//
//            //根据条件来查询
//            EmpExample empExample =new EmpExample();
//            //创建条件
//            //名字为张三,年龄为12岁
//            empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(12);
//            //和did不为空的
//            empExample.or().andDidIsNotNull();
//            //QBC风格 根据条件查询 都查出来了
//            List<Emp> emps = mapper.selectByExample(empExample);
//            emps.forEach(System.out::println);
//
            //sex是null修改后数据库里也是null
            mapper.updateByPrimaryKey(new Emp(1,"张三",22,null,"234@qq.com",3));
            //选择性修改null不会赋值到数据库
            mapper.updateByPrimaryKeySelective(new Emp(1,"张三",22,null,"234@qq.com",3));

            mapper.insert(new Emp(null,"张三",23,"男","2234@qq.com",1));
            mapper.insertSelective(new Emp(null,"张1",null,"女","2134@qq.com",3));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
