package mta.th12a.tuanhiep.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mta.th12a.tuanhiep.auth.Auth;
import mta.th12a.tuanhiep.dto.LoginDTO;
import mta.th12a.tuanhiep.model.Customers;
import mta.th12a.tuanhiep.service.ICustomersService;

@Controller
@RequestMapping(value="/admin/authen")
public class AuthenticationController {
	@Autowired
	ICustomersService custommer;
	@RequestMapping(value="/login")
	public ModelAndView login()
	{
		LoginDTO loginDTO=new LoginDTO();
		return new ModelAndView("login", "loginDTO",loginDTO);
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String doLogin(@ModelAttribute("loginDTO") LoginDTO loginDTO ,HttpSession session)
	{
		Customers result=custommer.authen(loginDTO.getUserName(), loginDTO.getPassWord());
		if(result!=null){
			 session.setAttribute("isLogin", true);
             session.setAttribute("user", result.getAccount());
             session.setAttribute("role", result.getRole());
             return "redirect:/admin/brand/index";
		}
		return "login";
	}
	@Auth(role=1)
	@RequestMapping(value = "/deny", method = RequestMethod.GET)
    public String deny() {
 
        return "deny";
    }
}
