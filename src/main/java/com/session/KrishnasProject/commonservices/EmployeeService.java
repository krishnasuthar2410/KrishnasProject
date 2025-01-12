package com.session.KrishnasProject.commonservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.session.KrishnasProject.dto.EmployeeRequest;
import com.session.KrishnasProject.entities.Department;
import com.session.KrishnasProject.entities.Employee;
import com.session.KrishnasProject.respositories.DepartmentRepository;
import com.session.KrishnasProject.respositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
	private final EmployeeRepository employeerepository;
	private final DepartmentRepository departmentrepository;
	public Employee createemployee(EmployeeRequest request)
	{
		Optional<Department> opt=departmentrepository.findById(request.getDepartmentId());
		if(opt.isEmpty())
		{
			throw new RuntimeException ("Invalid department ID:"+request.getDepartmentId());
		}
		Department dpt=opt.get();
		Employee employee=Employee.builder().name(request.getName()).department(dpt).build();
		return employeerepository.save(employee);
	}

}
