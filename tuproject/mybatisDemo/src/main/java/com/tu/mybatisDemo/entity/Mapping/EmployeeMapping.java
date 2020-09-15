package com.tu.mybatisDemo.entity.Mapping;

import com.tu.mybatisDemo.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapping {

    /**
     * 查询employee数据
     * @param id
     * @return
     */
    public Employee getEmployeeOne(Integer id);

    /**
     * 新增employee数据
     */
    public int incrEmployee(Employee employee);

    /**
     * 修改employee数据
     */
    public int updEmployee(Employee employee);

    /**
     * 删除employee数据
     */
    public int decrEmployee(Integer id);

    /**
     * 根据多个参数条件查询employee
     */
    public Employee getEmployeeByCondition(String tbl, @Param("lastName") String lastName, @Param("email") String email);

    /**
     * 返回list结果集合
     */
    public List<Employee> getListEmployeeByLastName(String lastName);

    /**
     * 查询返回单个结果的Map结果集
     */
    public Map<String, Object> getMapEmployeeByLastName(String lastName);

    /**
     * 查询返回多个结果的Map结果集
     */
    @MapKey("id")
    public Map<String, Employee> getMapEmployeeByLikeLastName(String lastName);

    /**
     * 查询关联结果getEmployeeByOneAssoc1
     */
    public Employee getEmployeeByOneAssoc1(Integer id);

    /**
     * 查询关联结果getEmployeeByOneAssoc2
     */
    public Employee getEmployeeByOneAssoc2(Integer id);

    /**
     * 查询关联结果getEmployeeByOneAssoc3 分布查询
     */
    public Employee getEmployeeByOneAssoc3(Integer id);

}
