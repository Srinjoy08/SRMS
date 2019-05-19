package com.pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.model.Admin;
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
	@RequestMapping(value="/adminHome", method=RequestMethod.GET)
	public String adminHome()
	{
		return "adminHome";
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
		
}
