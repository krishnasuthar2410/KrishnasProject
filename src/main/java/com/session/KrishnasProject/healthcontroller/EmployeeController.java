package com.session.KrishnasProject.healthcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.session.KrishnasProject.commonservices.EmployeeService;
import com.session.KrishnasProject.dto.EmployeeRequest;
import com.session.KrishnasProject.entities.Employee;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	private static Map<Integer,Object> employees=new HashMap<>();
	{
		Map<String,Object> emp1=new HashMap<>();
		emp1.put("id",1);
		emp1.put("name", "krishna");
		employees.put(1, emp1);
		
		Map<String,Object> emp2=new HashMap<>();
		emp2.put("id",2);
		emp2.put("name", "Riya");
		employees.put(2, emp2);
		
		Map<String,Object> emp3=new HashMap<>();
		emp3.put("id",3);
		emp3.put("name", "raj");
		employees.put(3, emp3);
		
		Map<String,Object> emp4=new HashMap<>();
		emp4.put("id",4);
		emp4.put("name", "Smital");
		employees.put(4, emp4);
		
		Map<String,Object> emp5=new HashMap<>();
		emp5.put("id",5);
		emp5.put("name", "Dev");
		employees.put(5, emp5);
		
		Map<String,Object> emp6=new HashMap<>();
		emp6.put("id",6);
		emp6.put("name", "megha");
		employees.put(6, emp6);
		
		Map<String,Object> emp7=new HashMap<>();
		emp7.put("id",7);
		emp7.put("name", "rahul");
		employees.put(7, emp7);
		
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getallemployees()
	{
		return ResponseEntity.ok(employees);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getemployees(@PathVariable int id)
	{
		return ResponseEntity.ok(employees.get(id));
		
	}
	
	@PostMapping
	public ResponseEntity<?> createmployees(@RequestBody Map<String,Object> request)
	{
		if(request.get("id")==null)
			{
			return ResponseEntity.internalServerError().body("no ID found");
			}
		
		if(employees.get((int) request.get("id"))!=null) {
			return ResponseEntity.badRequest().body("Same Employee ID existed already");
			
		}
		int id=(int)request.get("id");
		employees.put(id, request);
		return ResponseEntity.ok(employees.get(id));
		
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateemployee(@PathVariable int id,@RequestBody Map<String,String> request)
	{
		if(employees.get(id)==null)
		{
		return ResponseEntity.internalServerError().body("no ID found");
		}
		Map<String,Object> newmap=(Map<String,Object>)employees.get(id);
		String prevname= (String) newmap.put("name", request.get("name"));
		log.info("{} name updated to {}  for emp id {} ",prevname,request.get("name"),id);
		return ResponseEntity.ok(employees.get(id));
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteempbyid(@PathVariable int id)
	{
		Map<String,Object> name=(Map<String,Object>)employees.remove(id);
		log.info("employee removed with id {} and name {}",id,name.get("name"));
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/new")
	public ResponseEntity<Employee> createemployee(@RequestBody @Validated EmployeeRequest request)
	{
		return ResponseEntity.ok(employeeService.createemployee(request));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
	}
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> fetchEmployeebyDepartmentId(@RequestParam(name="name") String departmentName)
	{
		return ResponseEntity.ok(employeeService.fetchEmployeebyDepartmentId(departmentName));
		
	}
	@DeleteMapping("/new/{id}")
	
	public ResponseEntity<HttpStatus> deleteEmployeeByID(@PathVariable Long id) throws InterruptedException
	{
		employeeService.deleteEmployeeByID(id);
		 return ResponseEntity.ok().build();
	}
	
	
	
}
