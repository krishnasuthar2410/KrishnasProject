package com.session.KrishnasProject.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.session.KrishnasProject.entities.User;

public interface Userrepository extends JpaRepository <User,Integer>{
	

}
