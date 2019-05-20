package com.pack.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.model.Admin;
import com.pack.model.MaintainenceBill;
import com.pack.model.Resident;
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

	@Override
	public List<Resident> getAllResidents() {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("from Resident");
        return q.list();
	}
	@Override
	public Resident fetchResidentByEmailId(String emailId) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("from Resident l where l.emailId=:email");
        q.setParameter("email", emailId);
        Resident l1=(Resident)q.uniqueResult();
        if(l1!=null)
        	return l1;
        else
        	return null;
	}
	@Override
	public void addResident(Resident resident) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(resident);
		System.out.println("Resident Added Successfully");
	}

	@Override
	public void deleteResident(Integer id) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("delete from Resident l where l.id=:id");
        q.setParameter("id", id);
        q.executeUpdate();
	}

	@Override
	public Resident fetchResidentById(Integer id) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("from Resident l where l.id=:id");
        q.setParameter("id", id);
        Resident l1=(Resident)q.uniqueResult();
        if(l1!=null)
        	return l1;
        else
        	return null;
	}

	@Override
	public void updateResident(Resident resident) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(resident);
	}
	@Override
	public boolean checkEmail(Resident resident)
	{
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("from Resident l where l.id!=:id and emailid=:email");
        q.setParameter("id", resident.getId());
        q.setParameter("email", resident.getEmailId());
        Resident l1=(Resident)q.uniqueResult();
        if(l1!=null)
        	return false;
        else
        	return true;
	}

	@Override
	public void generateBills(List<MaintainenceBill> l) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.getCurrentSession();
		for (MaintainenceBill maintainenceBill : l) {
			s.saveOrUpdate(maintainenceBill);
		}
	}

	@Override
	public List<MaintainenceBill> getBills() {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("from MaintainenceBill");
        return q.list();
	}

	@Override
	public boolean payResidentBill(Integer id) {
		// TODO Auto-generated method stub
		String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
        Calendar cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];
        String year = String.valueOf(cal.get(Calendar.YEAR));
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("update MaintainenceBill l set billStatus='PAID' where l.id!=:id and month=:month and year=:year");
        q.setParameter("id", id);
        q.setParameter("month", month);
        q.setParameter("year", year);
        int i=q.executeUpdate();
        if(i>0)
        	return true;
        else
        	return false;
	}
}
