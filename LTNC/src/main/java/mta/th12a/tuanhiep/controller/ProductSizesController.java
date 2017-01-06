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
import mta.th12a.tuanhiep.model.ProductSizes;
import mta.th12a.tuanhiep.service.IProductCorlorsService;
import mta.th12a.tuanhiep.service.IProductSizesService;

@Controller
@RequestMapping(value="/admin/product-size")
public class ProductSizesController {
	@Autowired
	IProductSizesService productSizeService;
	@RequestMapping(value="/index")
	@Auth(role=1)
	public ModelAndView Index()
	{
		return new ModelAndView("product-size-index","listProductSize",productSizeService.getAll());
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView Create()
	{
		return new ModelAndView("product-size-create","productSize",new ProductSizes());
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String Create(@ModelAttribute(value="productSize")  ProductSizes productSize,ModelMap model)
	{
		productSize.setIsActive(true);
		productSizeService.add(productSize);
		model.put("listProductSize", productSizeService.getAll());
		return "redirect:/product-size/index";
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public ModelAndView Update(@PathVariable(value="id") int id)
	{
		ProductSizes productsize=productSizeService.getByID(id);
		return new ModelAndView("product-size-update","productSize",productsize);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String Update(@ModelAttribute(value="productSize") ProductSizes productSize,ModelMap model)
	{
		productSizeService.update(productSize);
		model.put("listProductSize", productSizeService.getAll());
		return "redirect:/product-size/index";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String Delete(@PathVariable(value="id") int id,ModelMap model)
	{
		productSizeService.delete(id);
		model.put("listProductSize", productSizeService.getAll());
		return "redirect:/product-size/index";

	}
}
