package com.session.KrishnasProject.commonservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.session.KrishnasProject.entities.Department;
import com.session.KrishnasProject.respositories.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {
	private final DepartmentRepository departmentRepository;
	public List<Department> getalldepartment()
	{
		return departmentRepository.findAll();
		
	}

}
