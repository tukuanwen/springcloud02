package com.tu.springboot005.dao.mapper;

import com.tu.springboot005.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmployeeMapper {

    @Select("select id, last_name, gender, email from tbl_employee where id = #{id}")
    public Employee getOneEmployee(Integer id);

    public Employee getOneEmployee2(Integer id);

    public int incrOneEmployee(Employee employee);

}
