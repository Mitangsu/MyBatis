package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author Su
 * @create 2022-04-14 16:49
 */
public interface CacheMapper {

    //
    Emp getEmpById(@Param("eid")Integer eid);

}
