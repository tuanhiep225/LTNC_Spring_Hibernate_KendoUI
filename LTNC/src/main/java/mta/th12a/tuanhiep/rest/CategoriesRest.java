package mta.th12a.tuanhiep.rest;

import java.io.IOException;
import java.util.List;

import mta.th12a.tuanhiep.dto.ModelDTO;
import mta.th12a.tuanhiep.model.Brands;
import mta.th12a.tuanhiep.model.Categories;
import mta.th12a.tuanhiep.service.IBrandsService;
import mta.th12a.tuanhiep.service.ICategoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@RequestMapping(value="/api/category")
public class CategoriesRest {
	@Autowired
	private ICategoriesService categoryService;
	@RequestMapping(value="/getall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelDTO<Categories> getAll()
	{
		ModelDTO<Categories> dto=new ModelDTO<Categories>();
		dto.setData(categoryService.getAll());
		dto.setItemCount(categoryService.getAll().size());
		return dto;
	}
	@RequestMapping(value="/getListChild",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelDTO<Categories> getListChild()
	{
		ModelDTO<Categories> dto=new ModelDTO<Categories>();
		dto.setData(categoryService.getListChild());
		dto.setItemCount(categoryService.getListChild().size());
		return dto;
	}
	@RequestMapping(value="/getListParent",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelDTO<Categories> getListParent()
	{
		ModelDTO<Categories> dto=new ModelDTO<Categories>();
		dto.setData(categoryService.getListParent());
		dto.setItemCount(categoryService.getListParent().size());
		return dto;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public int update(@RequestBody String models)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			Categories category=obj.readValue(models, Categories.class);
			categoryService.update(category);
			return 1;
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public int create(@RequestBody String models)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			Categories category = obj.readValue(models, Categories.class);
			categoryService.add(category);
			return 1;
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public int delete(@RequestBody String models)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			Categories category=obj.readValue(models, Categories.class);
			categoryService.delete(category.getCategoryId());
			return 1;
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
