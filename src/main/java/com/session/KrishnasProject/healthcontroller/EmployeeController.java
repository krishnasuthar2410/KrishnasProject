package com.session.KrishnasProject.healthcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
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
}
