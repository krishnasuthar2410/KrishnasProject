package com.session.KrishnasProject.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.session.KrishnasProject.entities.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}