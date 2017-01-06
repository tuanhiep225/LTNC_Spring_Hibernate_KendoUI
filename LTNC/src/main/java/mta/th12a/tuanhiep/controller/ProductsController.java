package mta.th12a.tuanhiep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mta.th12a.tuanhiep.auth.Auth;
import mta.th12a.tuanhiep.service.ICustomersService;
import mta.th12a.tuanhiep.service.IProductsService;

@Controller
@RequestMapping(value="/admin/product")
public class ProductsController {
	@Auth(role=1)
	@RequestMapping(value="/index")
	public String Index()
	{
		return "product-index";
	}
}
