package com.pack.dao;

import com.pack.model.Admin;

public interface AdminDao {
	Admin fetchAdminByEmailId(String emailId);
	boolean checkPassword(Admin admin);
}
