package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.AdminFeedback;
import com.repo.AdminRepo;
@Service
public class AdminDaoImpl implements AdminDao{

	@Autowired
	AdminRepo repo;
	@Override
	public AdminFeedback addAdminFeedBack(AdminFeedback adminfeedback) {
		// TODO Auto-generated method stub
		return repo.save(adminfeedback) ;
	}

	@Override
	public Iterable<AdminFeedback> getAllFeedBack() {
		// TODO Auto-generated method stub
		return  repo.findAll();
	}

}
