package net.javaguids.springboot.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguids.springboot.exception.ResourceNotFoundException;
import net.javaguids.springboot.model.Employee;
import net.javaguids.springboot.repository.EmployeeRepository;
import net.javaguids.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRespository) {
		super();
		this.employeeRepository = employeeRespository;
	}

	@Override
	public Employee saveEmpolyee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if (employee.isPresent()) {
//			return employee.get();
//		} else {
//			throw new ResourceNotFoundException("Employee", "id", id);
//		}

		// same above method in Lambda expression
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		// Check whether the employee with id is exist in DB or not

		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		// save employee details in DB

		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(Long id) {
		// check whether the employee is exist in DB or not
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		employeeRepository.deleteById(id);
	}

}
