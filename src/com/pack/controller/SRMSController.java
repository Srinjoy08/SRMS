package com.pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SRMSController {

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
}
