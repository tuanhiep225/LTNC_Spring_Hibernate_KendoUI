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
import mta.th12a.tuanhiep.model.Categories;
import mta.th12a.tuanhiep.service.ICategoriesService;

@Controller
@RequestMapping(value="/admin/category")
public class CategoriesController {
	@Autowired
	ICategoriesService categoryService;
	@Auth(role=1)
	@RequestMapping(value="/index")
	public ModelAndView Index()
	{
		return new ModelAndView("category-index","listCategory",categoryService.getAll());
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView Create()
	{
		return new ModelAndView("category-create","category",new Categories());
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String Create(@ModelAttribute(value="category")  Categories category,ModelMap model)
	{
		category.setIsActive(true);
		categoryService.add(category);
		model.put("listCategory", categoryService.getAll());
		return "redirect:/category/index";
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public ModelAndView Update(@PathVariable(value="id") int id)
	{
		Categories category=categoryService.getByID(id);
		return new ModelAndView("category-update","category",category);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String Update(@ModelAttribute(value="brand") Categories category,ModelMap model)
	{
		categoryService.update(category);
		model.put("listCategory", categoryService.getAll());
		return "redirect:/category/index";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String Delete(@PathVariable(value="id") int id,ModelMap model)
	{
		categoryService.delete(id);
		model.put("listCategory", categoryService.getAll());
		return "redirect:/category/index";

	}
}
