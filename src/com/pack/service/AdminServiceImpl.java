package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.AdminDao;
import com.pack.model.Admin;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	@Override
	@Transactional
	public Admin fetchAdminByEmailId(String emailId) {
		// TODO Auto-generated method stub
		Admin u=adminDao.fetchAdminByEmailId(emailId);
		return u;
	}

	@Override
	@Transactional
	public boolean checkPassword(Admin admin) {
		// TODO Auto-generated method stub
		boolean i=adminDao.checkPassword(admin);
		return i;
	}

}
