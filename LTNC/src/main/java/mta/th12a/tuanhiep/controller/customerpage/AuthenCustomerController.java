package mta.th12a.tuanhiep.controller.customerpage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mta.th12a.tuanhiep.model.Customers;
import mta.th12a.tuanhiep.service.ICustomersService;

@Controller
@RequestMapping(value="/customer")
public class AuthenCustomerController {
	@Autowired ICustomersService custommer;
	@ResponseBody
	@RequestMapping(value="/authen",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public  Map<String,Object> doLogin(String userName,String passWord,HttpSession session)
	{
		Map<String,Object> map= new HashMap<String,Object>();
		Customers result=custommer.authen(userName, passWord);
		if(result!=null){
			 session.setAttribute("customer", result);
			 map.put("customer", result);
             return map;
		}
		return null;
	}
}
