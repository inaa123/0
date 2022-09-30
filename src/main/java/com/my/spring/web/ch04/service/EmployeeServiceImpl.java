package com.my.spring.web.ch04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.web.ch04.dao.EmployeeDao;
import com.my.spring.web.ch04.domain.Employee;

@Service //나는 서비스레이어야
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired private EmployeeDao employeeDao; //서비스의 디펜던시 Dao
	
	@Override
	public Employee getEmployee(int employeeId) {
		return employeeDao.selectEmployee(employeeId);
	}
}
