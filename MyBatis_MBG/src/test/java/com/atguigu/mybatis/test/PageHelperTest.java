package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @create 2022-04-14 19:06
 */
public class PageHelperTest {

    @Test
    public void testPageHelper(){
        /**
         * limit index,pageSize
         * index:当前页的起始索引
         * pageSize:每页显示的条数
         * pageNum:当前页的页码
         * index=(pageNum-1)*pageSize
         *
         * 使用MyBatis的分页插件实现分页功能:
         * 1.需要在查询功能之前开启分页
         * PageHelper.startPage(int pageNum,int pageSize);
         * PageInfo<Emp> page =new PageInfo<>(emps,5);
         *
         */

        InputStream is = null;
        try {
             is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //开启分页功能 第一页，5个记录
            PageHelper.startPage(1, 5);
            //查询所有数据
            List<Emp> emps = mapper.selectByExample(null);
            //获取分页相关的所有数据
            PageInfo<Emp> page =new PageInfo<>(emps,5);
            System.out.println(page);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
