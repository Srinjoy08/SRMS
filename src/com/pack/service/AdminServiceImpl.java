package com.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.AdminDao;
import com.pack.model.Admin;
import com.pack.model.MaintainenceBill;
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
	public boolean checkFlat(Resident resident) {
		// TODO Auto-generated method stub
		return adminDao.checkFlat(resident);
	}
	@Override
	@Transactional
	public void addResident(Resident resident) {
		// TODO Auto-generated method stub
		adminDao.addResident(resident);
	}
	@Override
	@Transactional
	public Resident fetchResidentByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return adminDao.fetchResidentByEmailId(emailId);
	}
	@Override
	@Transactional
	public void deleteResident(Integer id) {
		// TODO Auto-generated method stub
		 adminDao.deleteResident(id);
	}
	@Override
	@Transactional
	public Resident fetchResidentById(Integer id) {
		// TODO Auto-generated method stub
		return adminDao.fetchResidentById(id);
	}
	@Override
	@Transactional
	public void updateResident(Resident resident) {
		// TODO Auto-generated method stub
		adminDao.updateResident(resident);		
	}
	@Override
	@Transactional
	public boolean checkEmail(Resident resident) {
		return adminDao.checkEmail(resident);
	}
	@Override
	@Transactional
	public void generateBills(List<MaintainenceBill> l) {
		// TODO Auto-generated method stub
		 adminDao.generateBills(l);
	}
	@Override
	@Transactional
	public List<MaintainenceBill> getBills() {
		// TODO Auto-generated method stub
		return adminDao.getBills();
	}
	@Override
	@Transactional
	public boolean payResidentBill(MaintainenceBill bill) {
		// TODO Auto-generated method stub
		return adminDao.payResidentBill(bill);
	}
	@Override
	
	public void mailMaintainenceBill(MaintainenceBill bill) {
		// TODO Auto-generated method stub
		adminDao.mailMaintainenceBill(bill);
		
	}
	@Override
	@Transactional
	public MaintainenceBill fetchBill(Integer id, String month, String year) {
		// TODO Auto-generated method stub
		return adminDao.fetchBill(id,month,year);
	}
}
