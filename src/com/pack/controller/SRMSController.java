package com.pack.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.model.Admin;
import com.pack.model.MaintainenceBill;
import com.pack.model.Resident;
import com.pack.service.AdminService;

@Controller
public class SRMSController {
	@Autowired
	private AdminService adminService;
	
	//Admin Login Page
    @RequestMapping(value = "/loginAdminPage", method = RequestMethod.GET)
    public String loginAdminPage(ModelMap model) {
    	int check=-1;
    	System.out.println("Inside Admin Login Page");
    	model.addAttribute("admin", new Admin());
    	model.addAttribute("check", check);
        return "adminLogin";
    }
    
	
	//Admin Login
		@RequestMapping(value="/loginAdmin", method=RequestMethod.POST)
		public String loginAdmin(@ModelAttribute(value="admin") Admin admin,BindingResult result,ModelMap model, HttpServletRequest req){
			System.out.println(admin.getEmailId()+admin.getPassword());
			HttpSession session = req.getSession();
			System.out.println("Session is new? - > " + session.isNew());
			Admin u=adminService.fetchAdminByEmailId(admin.getEmailId());	
			System.out.println(u);
			int check=0;
			if(u!=null)
			{
				check=1;
				u.setPassword(admin.getPassword());
				if(adminService.checkPassword(u))
		    	{
		    		check=2;
		    	}
			}
			model.addAttribute("check", check);
			if(check==2) {
				session.setMaxInactiveInterval(10*60);
				session.setAttribute("user", u);
				return "redirect:/adminHome";
			}
			return "adminLogin";
		}
		
		@RequestMapping(value="/adminHome", method=RequestMethod.GET)
		public String adminHome(ModelMap model)
		{
			List<Resident> l=adminService.getAllResidents();
			model.addAttribute("residentList",l);
			return "adminHome";
		}
		@RequestMapping(value="/addNewResidentPage", method =RequestMethod.GET)
		public String addNewResidentPage(ModelMap model)
		{
			model.addAttribute("resident",new Resident());
			return "addNewRecord";
		}
		
		@RequestMapping(value="/addNewResident", method =RequestMethod.POST)
		public String addNewResident(@ModelAttribute(value="resident") Resident resident,BindingResult result,ModelMap model)
		{
			int check=0;
			Random r = new Random();
	 		int x = r.nextInt(900000)+100000;
	 		resident.setId(x);
	 		if(adminService.fetchResidentByEmailId(resident.getEmailId())==null) {
	 			adminService.addResident(resident);
	 			check=2;
	 		}
	 		else check=1;
	 		model.addAttribute("check",check);
	 		if(check==1)
	 			return "addNewRecord";
			return "redirect:/adminHome";
		}
		
		@RequestMapping(value="removeResident/{id}",method=RequestMethod.GET)
		public String removeResident(@PathVariable("id") Integer id) {
			adminService.deleteResident(id);
			return "redirect:/adminHome";
		}
		@RequestMapping(value="editResidentPage/{id}",method=RequestMethod.GET)
		public String editResidentPage(@PathVariable("id") Integer id,ModelMap model) {
			model.addAttribute("resident",adminService.fetchResidentById(id));
			return "editRecord";
		}
		
		@RequestMapping(value="/editResident/{id}", method =RequestMethod.POST)
		public String editResident(@PathVariable("id")Integer id,@ModelAttribute(value="resident") Resident resident,BindingResult result,ModelMap model)
		{
			int check=0;
			resident.setId(id);
	 		if(adminService.checkEmail(resident)) {
	 			adminService.updateResident(resident);
	 			check=2;
	 		}
	 		else check=1;
	 		model.addAttribute("check",check);
	 		if(check==1)
	 			return "editRecord";
			return "redirect:/adminHome";
		}
		
		@RequestMapping(value="/billListPage", method=RequestMethod.GET)
		public String billListPage(ModelMap model)
		{
			List<MaintainenceBill> l=adminService.getBills();
			model.addAttribute("billList",l);
			return "maintainenceBillList";
		}
		@RequestMapping(value="/generateBill", method=RequestMethod.GET)
		public String generateBill()
		{
			String[] monthName = {"January", "February",
	                "March", "April", "May", "June", "July",
	                "August", "September", "October", "November",
	                "December"};
	        Calendar cal = Calendar.getInstance();
	        String month = monthName[cal.get(Calendar.MONTH)];
	        String year = String.valueOf(cal.get(Calendar.YEAR));
			List<Resident> l=adminService.getAllResidents();
			List<MaintainenceBill> l2 = new ArrayList<MaintainenceBill>();
			MaintainenceBill m;
			for (Resident resident : l) {
				m=new MaintainenceBill(resident.getId(),resident.getOwnerName(),resident.getContactNumber(),resident.getEmailId(),resident.getFlatNumber(),resident.getBlock(),resident.getFloorNumber(),resident.getFlatType(),resident.getArea(),month,year,resident.getArea()*2,"NOT_PAID");
				l2.add(m);
			}
			adminService.generateBills(l2);
			return "redirect:/billListPage";
		}
		
		@RequestMapping(value="/payBill/{id}/{month}/{year}", method =RequestMethod.GET)
		public String payBill(@PathVariable("id")Integer id,@PathVariable("month")String month,@PathVariable("year")String year,ModelMap model)
		{
			MaintainenceBill bill=adminService.fetchBill(id,month,year);
			if(adminService.payResidentBill(bill))
				return "redirect:/billListPage";
			return "redirect:/billListPage";
		}
		@RequestMapping(value="/mailBill/{id}/{month}/{year}", method =RequestMethod.GET)
		public String mailBill(@PathVariable("id")Integer id,@PathVariable("month")String month,@PathVariable("year")String year,ModelMap model)
		{
			MaintainenceBill bill=adminService.fetchBill(id,month,year);
			adminService.mailMaintainenceBill(bill);
			return "redirect:/billListPage";
		}
}
