package com.pack.dao;

import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
			Query q=s.createQuery("from MaintainenceBill where id=:id and month=:month and year=:year and billStatus='PAID')");
			q.setParameter("id", maintainenceBill.getId());
			q.setParameter("month", maintainenceBill.getMonth());
			q.setParameter("year", maintainenceBill.getYear());
			if(q.uniqueResult()==null)
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
	public boolean payResidentBill(MaintainenceBill bill) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("update MaintainenceBill l set billStatus='PAID' where l.id=:id and month=:month and year=:year");
        q.setParameter("id", bill.getId());
        q.setParameter("month", bill.getMonth());
        q.setParameter("year", bill.getYear());
        int i=q.executeUpdate();
        if(i>0)
        	return true;
        else
        	return false;
	}

	@Override
	public void mailMaintainenceBill(MaintainenceBill bill) {
		// TODO Auto-generated method stub
		String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
        Calendar cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];
        String year = String.valueOf(cal.get(Calendar.YEAR));
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465"); 
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("testprojectmail101","test@1234");
			}
		}); 
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("testprojectmail101gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(bill.getEmailId()));
			message.setSubject("Password Reset");
			/*message.setText("Dear User," +
					"\n\n Your OTP for new Password Generation is :"+otp);*/
			String msg;
			if(bill.getBillStatus().equals("NOT_PAID") && bill.getMonth().equals(month) && bill.getYear().equals(year))
				 msg = "<body><div class='header' style='width: 100%; height: 50px; background-color: #b3b3ff; border-radius: 15px 15px 0 0; font-size: 40px;'><center><b>SUNRISE SOCIETY</b></center></div><br><br><span><p style='padding-left: 100px; font-size: 20px;'>Dear "+bill.getOwnerName()+",<br>Your MaintainenceBill for "+bill.getMonth()+", "+bill.getYear()+" is Rs: <b>" + bill.getBillAmount() + "</b></p></span><br><br><div class='footer' style='width: 100%; height: 50px; background-color: #b3b3ff; border-radius: 0 0 15px 15px;'/></body>";
			else
				 msg = "<body><div class='header' style='width: 100%; height: 50px; background-color: #b3b3ff; border-radius: 15px 15px 0 0; font-size: 40px;'><center><b>SUNRISE SOCIETY</b></center></div><br><br><span><p style='padding-left: 100px; font-size: 20px;'>Dear "+bill.getOwnerName()+",<br>Your MaintainenceBill for "+bill.getMonth()+", "+bill.getYear()+" is unpaid. Please pay it as soon as possible. Bill Amount is Rs: <b>" + bill.getBillAmount() + "</b></p></span><br><br><div class='footer' style='width: 100%; height: 50px; background-color: #b3b3ff; border-radius: 0 0 15px 15px;'/></body>";
			message.setContent(msg, "text/html");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		
	}

	@Override
	public MaintainenceBill fetchBill(Integer id, String month, String year) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.getCurrentSession();
        Query q=s.createQuery("from MaintainenceBill where id=:id and month=:month and year=:year");
        q.setParameter("id", id);
        q.setParameter("month", month);
        q.setParameter("year", year);
        return (MaintainenceBill) q.uniqueResult();
	}
}
