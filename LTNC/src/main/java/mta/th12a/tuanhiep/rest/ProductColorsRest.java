package mta.th12a.tuanhiep.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mta.th12a.tuanhiep.dto.ModelDTO;
import mta.th12a.tuanhiep.model.ProductColors;
import mta.th12a.tuanhiep.service.IProductCorlorsService;

@RestController
@RequestMapping(value="/api/product-color")
public class ProductColorsRest {
	@Autowired
	private IProductCorlorsService productColorService;
	@RequestMapping(value="/getall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelDTO<ProductColors> getAll()
	{
		ModelDTO<ProductColors> dto=new ModelDTO<ProductColors>();
		dto.setData(productColorService.getAll());
		dto.setItemCount(productColorService.getAll().size());
		return dto;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public int update(@RequestBody String models)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			ProductColors productColor=obj.readValue(models, ProductColors.class);
			productColorService.update(productColor);
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
			ProductColors productColor = obj.readValue(models, ProductColors.class);
			productColorService.add(productColor);
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
			ProductColors productColor = obj.readValue(models, ProductColors.class);
			productColorService.delete(productColor.getProductColorId());
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
