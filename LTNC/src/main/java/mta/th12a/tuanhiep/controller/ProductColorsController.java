package mta.th12a.tuanhiep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mta.th12a.tuanhiep.auth.Auth;
import mta.th12a.tuanhiep.model.ProductColors;
import mta.th12a.tuanhiep.service.IProductCorlorsService;

@Controller
@RequestMapping(value="/admin/product-color")
public class ProductColorsController {
	@Autowired
	IProductCorlorsService productColorService;
	@RequestMapping(value="/index")
	@Auth(role=1)
	public ModelAndView Index()
	{
		return new ModelAndView("product-color-index","listProductColor",productColorService.getAll());
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView Create()
	{
		return new ModelAndView("product-color-create","productColor",new ProductColors());
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String Create(@ModelAttribute(value="productColor")  ProductColors productColor,ModelMap model)
	{
		productColor.setIsActive(true);
		productColorService.add(productColor);
		model.put("listProductColor", productColorService.getAll());
		return "redirect:/product-color/index";
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public ModelAndView Update(@PathVariable(value="id") int id)
	{
		ProductColors productcolor=productColorService.getByID(id);
		return new ModelAndView("product-color-update","productColor",productcolor);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String Update(@ModelAttribute(value="productColor") ProductColors productColor,ModelMap model)
	{
		productColorService.update(productColor);
		model.put("listProductColor", productColorService.getAll());
		return "redirect:/product-color/index";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String Delete(@PathVariable(value="id") int id,ModelMap model)
	{
		productColorService.delete(id);
		model.put("listProductColor", productColorService.getAll());
		return "redirect:/product-color/index";

	}
}
