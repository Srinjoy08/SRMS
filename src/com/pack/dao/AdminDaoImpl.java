package com.pack.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.model.Admin;
@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Admin fetchAdminByEmailId(String emailId) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("from Admin l where l.emailId=:emailId");
        q.setParameter("emailId", emailId);
        Admin l1=(Admin)q.uniqueResult();
        if(l1!=null )
       		return l1;
        else       	
        	return null;
	}

	@Override
	public boolean checkPassword(Admin admin) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("from Admin l where l.id=:id and l.password=:pass");
        q.setParameter("id", admin.getId());
        q.setParameter("pass", admin.getPassword());
        Admin l1=(Admin)q.uniqueResult();
        System.out.println("ok"+l1);
        if(l1!=null)
        	return true;
        else
        	return false;
	}

}
