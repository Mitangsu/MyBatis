package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Su
 * @create 2022-04-13 7:51
 */
public interface SelectMapper {

    //查询所有用户信息
    //List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

    //根据id查询用户信息为一个map集合
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    //查询用户信息的总记录数
    Integer getCount();

    //根据id查询用户信息
    List<User> getUserById(@Param("id") Integer id);

    //查询所有的用户信息
    List<User> getAllUser();
}
