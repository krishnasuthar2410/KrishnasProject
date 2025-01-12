package com.session.KrishnasProject.healthcontroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.session.KrishnasProject.commonservices.DepartmentService;
import com.session.KrishnasProject.entities.Department;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
	private final DepartmentService departmentService;
	@GetMapping("/all")
	public ResponseEntity<List<Department>> getalldepartment()
	{
		return ResponseEntity.ok(departmentService.getalldepartment());
		
	}

}
