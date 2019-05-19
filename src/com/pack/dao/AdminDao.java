package com.pack.dao;

import java.util.List;

import com.pack.model.Admin;
import com.pack.model.Resident;

public interface AdminDao {
	Admin fetchAdminByEmailId(String emailId);
	boolean checkPassword(Admin admin);
	List<Resident> getAllResidents();
	Resident fetchResidentByEmailId(String emailId);
	void addResident(Resident resident);
	void deleteResident(Integer id);
}
