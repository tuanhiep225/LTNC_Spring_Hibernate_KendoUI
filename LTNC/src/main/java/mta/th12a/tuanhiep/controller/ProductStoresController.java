package mta.th12a.tuanhiep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mta.th12a.tuanhiep.auth.Auth;

@Controller
@RequestMapping(value="/admin/product-store")
public class ProductStoresController {
	@Auth(role=1)
	@RequestMapping(value="/index")
	public String Index()
	{
		return "product-store-index";
	}
}
