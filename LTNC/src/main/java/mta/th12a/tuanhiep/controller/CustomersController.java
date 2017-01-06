package mta.th12a.tuanhiep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mta.th12a.tuanhiep.auth.Auth;
import mta.th12a.tuanhiep.service.ICustomersService;

@Controller
@RequestMapping(value="/admin/customer")
public class CustomersController {
	@Autowired
	private ICustomersService customerService;
	@Auth(role=1)
	@RequestMapping(value="/index")
	public String Index()
	{
		return "customer-index";
	}
}
