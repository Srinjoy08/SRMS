package com.pack.service;

import java.util.List;

import com.pack.model.Admin;
import com.pack.model.Resident;

public interface AdminService {
	Admin fetchAdminByEmailId(String emailId);
	
	boolean checkPassword(Admin admin);

	List<Resident> getAllResidents();

	void addResident(Resident resident);

	Resident fetchResidentById(String emailId);

	void deleteResident(Integer id);
}
