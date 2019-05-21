package com.pack.dao;

import java.util.List;

import com.pack.model.Admin;
import com.pack.model.MaintainenceBill;
import com.pack.model.Resident;

public interface AdminDao {
	Admin fetchAdminByEmailId(String emailId);
	boolean checkPassword(Admin admin);
	List<Resident> getAllResidents();
	Resident fetchResidentByEmailId(String emailId);
	void addResident(Resident resident);
	void deleteResident(Integer id);
	Resident fetchResidentById(Integer id);
	void updateResident(Resident resident);
	boolean checkEmail(Resident resident);
	void generateBills(List<MaintainenceBill> l);
	List<MaintainenceBill> getBills();
	boolean payResidentBill(MaintainenceBill bill);
	void mailMaintainenceBill(MaintainenceBill bill);
	MaintainenceBill fetchBill(Integer id, String month, String year);
	boolean checkFlat(Resident resident);
}
