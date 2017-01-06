package mta.th12a.tuanhiep.controller.customerpage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mta.th12a.tuanhiep.dto.Cart;
import mta.th12a.tuanhiep.dto.CategoryDTO;
import mta.th12a.tuanhiep.dto.ProductDTO;
import mta.th12a.tuanhiep.model.Categories;
import mta.th12a.tuanhiep.model.Customers;
import mta.th12a.tuanhiep.service.ICategoriesService;
import mta.th12a.tuanhiep.service.ICustomersService;
import mta.th12a.tuanhiep.service.IOrderDetailsService;
import mta.th12a.tuanhiep.service.IOrdersService;
import mta.th12a.tuanhiep.service.IProductsService;
import mta.th12a.tuanhiep.service.impl.CategoriesServiceImpl;

@Controller
public class Home extends BaseController {
	@Autowired IProductsService product;
	@Autowired IOrdersService order;
	@RequestMapping("/home")
	public String home(ModelMap model)
	{
		List<ProductDTO> list=new ArrayList<>();
		list=product.getListNew();
		model.put("listNew", list);
		return "home-index";
	}
	
	@RequestMapping("/order")
	public String order()
	{
		return "order";
	}
	@RequestMapping(value="/authen_order",method=RequestMethod.POST)
	public String authen_order(String customerId,String name,String email, String sdt,String diaChi,HttpSession session)
	{
		Cart cart= (Cart)session.getAttribute("cart");
		if(cart!=null)
		{
			int countItem=cart.countItem();
			if(countItem>0)
			{
				order.insertOrder(customerId, name, email, sdt, diaChi, cart);
			}
		}
		return "home-index";
		
	}
}
