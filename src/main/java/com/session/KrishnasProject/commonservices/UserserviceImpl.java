package com.session.KrishnasProject.commonservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.session.KrishnasProject.entities.User;
import com.session.KrishnasProject.respositories.Userrepository;
@Service
public class UserserviceImpl implements UserService {
	@Autowired
	private Userrepository userrepository;

	@Override
	public User craeteUser(User user) {
		return userrepository.save(user);
		
	}

}
