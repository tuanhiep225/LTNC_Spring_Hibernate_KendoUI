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
import mta.th12a.tuanhiep.model.Brands;
import mta.th12a.tuanhiep.service.IBrandsService;

@Controller
@RequestMapping(value="/admin/brand")
public class BrandsController {
	@Autowired
	IBrandsService brandService;
	@Auth(role=1)
	@RequestMapping(value="/index")
	public ModelAndView Index()
	{
		return new ModelAndView("brand-index","listBrand",brandService.getAll());
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView Create()
	{
		return new ModelAndView("brand-create","brand",new Brands());
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String Create(@ModelAttribute(value="brand")  Brands brand,ModelMap model)
	{
		brand.setIsActive(true);
		brandService.add(brand);
		model.put("listBrand", brandService.getAll());
		return "redirect:/brand/index";
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public ModelAndView Update(@PathVariable(value="id") int id)
	{
		Brands brand=brandService.getByID(id);
		return new ModelAndView("brand-update","brand",brand);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String Update(@ModelAttribute(value="brand") Brands brand,ModelMap model)
	{
		brandService.update(brand);
		model.put("listBrand", brandService.getAll());
		return "redirect:/brand/index";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public String Delete(@PathVariable(value="id") int id,ModelMap model)
	{
		brandService.delete(id);
		model.put("listBrand", brandService.getAll());
		return "redirect:/brand/index";

	}
}
