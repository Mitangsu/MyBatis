package test;

import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Su
 * @create 2022-04-13 15:17
 */
public class ResultMapTest {
    /**
     * 解决字段名和属性名不一致的清空：
     * >为字段起别名,保持和属性名的一致
     * >mapUnderscoreToCamelCase：将下划线_自动映射为驼峰,emp_name:empName
     *  <settings>
     *      <setting name="mapUnderscoreToCamelCase" value="true"/>
     *  </settings>
     *  >通过resultMap设置自定义的映射关系
     *  <resultMap id="empResultMap" type="Emp">
     *      property属性名 column字段名
     *      id设置主键的映射关系
     *      <id property="eid" column="eid"></id>
     *      result设置普通的映射关系
     *      <result property="empName" column="emp_name"></result>
     *      <result property="age" column="age"></result>
     *      <result property="sex" column="sex"></result>
     *      <result property="email" column="email"></result>
     *</resultMap>
     *
     * 处理多对一的映射关系:
     * >级联属性赋值
     * >association
     * >分布查询
     *
     * 处理一对多的映射关系:
     * >collection
     * >分布查询
     *
     */

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmpBysTepOne(1);
        System.out.println(deptAndEmp.getDeptName());
    }


    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDeptByStepOne(1);
        //开启延迟加载只查询对应的sql 如果不开就全部查出来并赋值
        System.out.println(empAndDept.getEmpName());
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println(empAndDept.getDept());
    }

    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(3);
        System.out.println(empAndDept);
    }

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> allEmp = mapper.getAllEmp();
        allEmp.forEach(System.out::println);
    }
}
