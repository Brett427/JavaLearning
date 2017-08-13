package com;

import java.util.HashMap;
import java.util.List;

import com.pojo.Employee;

public interface EmployeeMapper {
	
	List<Employee> selectEmployeeByIdLike(HashMap<String, Object> params);


}
