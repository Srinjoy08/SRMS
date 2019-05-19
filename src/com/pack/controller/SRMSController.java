package com.pack.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.model.Admin;
import com.pack.model.Resident;
import com.pack.service.AdminService;

@Controller
public class SRMSController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login()
	{
		return "login";
	}
	@RequestMapping(value="/addNewRecord", method=RequestMethod.GET)
	public String addNewRecord()
	{
		return "addNewRecord";
	}
	@RequestMapping(value="/editRecord", method=RequestMethod.GET)
	public String editRecord()
	{
		return "editRecord";
	}
	
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
			System.out.println(l.get(0).getFlatNumber());
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
	 		if(adminService.fetchResidentById(resident.getEmailId())==null) {
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
}
