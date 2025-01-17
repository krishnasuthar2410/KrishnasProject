package com.session.KrishnasProject.commonservices;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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
	private final AsychService asynchservice;
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
	public List<Employee> fetchEmployeebyDepartmentId(String departmentName)
	{
		Optional<Department> opt=departmentrepository.findByName(departmentName);
		if(opt.isEmpty())
		{
			throw new RuntimeException("invalid department name"+departmentName);
			
		}
		Department dpt=opt.get();
		List<Employee>employees=employeerepository.findByDepartment_Id(dpt.getId());
		return employees;
				
	}
	public void deleteEmployeeByID(Long id) throws InterruptedException {
		// TODO Auto-generated method stub
//		employeerepository.deleteById(id);  //by deletebyid jpa fun
//		Employee emp=employeerepository.findById(id).orElseThrow(()->new RuntimeException("invalid emp id"+id));
//		employeerepository.delete(emp);
		
//	
		//employeerepository.deleteEmployeeByID(id);
		log.info("strated...");
		CompletableFuture<Void> future=asynchservice.samplewait(4);
		CompletableFuture<Void> future1=asynchservice.samplewait(6);
		CompletableFuture<Void> future2=asynchservice.samplewait(8);
		CompletableFuture<Void> future3=asynchservice.samplewait(10);
		CompletableFuture<Void> all=CompletableFuture.allOf(future,future1,future2,future3);
		all.join();
		log.info("completed...");
		
	}

}
