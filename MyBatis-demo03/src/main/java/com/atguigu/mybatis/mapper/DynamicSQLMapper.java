package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Su
 * @create 2022-04-14 9:00
 */
public interface DynamicSQLMapper {

    //多条件查询
    List<Emp> getEmpByCondition(Emp emp);

    //测试choose、when、otherwise
    List<Emp> getEmpByChoose(Emp emp);

    //通过数组实现批量删除
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    //通过List集合实现批量添加
    int insertMoreByList(@Param("emps")List<Emp> emps);
}
