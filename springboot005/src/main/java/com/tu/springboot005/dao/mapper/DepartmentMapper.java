package com.tu.springboot005.dao.mapper;

import com.tu.springboot005.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DepartmentMapper {

    public int incrDepartment(Department department);

}
