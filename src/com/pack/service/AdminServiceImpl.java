package com.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.AdminDao;
import com.pack.model.Admin;
import com.pack.model.Resident;
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
	@Override
	@Transactional
	public List<Resident> getAllResidents() {
		// TODO Auto-generated method stub
		return adminDao.getAllResidents();
	}
	@Override
	@Transactional
	public void addResident(Resident resident) {
		// TODO Auto-generated method stub
		adminDao.addResident(resident);
	}
	@Override
	@Transactional
	public Resident fetchResidentById(String emailId) {
		// TODO Auto-generated method stub
		return adminDao.fetchResidentByEmailId(emailId);
	}
	@Override
	@Transactional
	public void deleteResident(Integer id) {
		// TODO Auto-generated method stub
		 adminDao.deleteResident(id);
	}

}
