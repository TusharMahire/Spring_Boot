package net.javaguids.springboot.service;

import java.util.List;

import net.javaguids.springboot.model.Employee;

public interface EmployeeService {

	Employee saveEmpolyee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	Employee updateEmployee(Employee employee, Long id);

	void deleteEmployee(Long id);

}
