package com.pack.service;

import com.pack.model.Admin;

public interface AdminService {
	Admin fetchAdminByEmailId(String emailId);
	
	boolean checkPassword(Admin admin);
}
