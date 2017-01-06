package mta.th12a.tuanhiep.rest;

import java.io.IOException;
import java.util.List;

import mta.th12a.tuanhiep.dto.ModelDTO;
import mta.th12a.tuanhiep.model.Brands;
import mta.th12a.tuanhiep.model.Products;
import mta.th12a.tuanhiep.service.IBrandsService;
import mta.th12a.tuanhiep.service.IProductsService;

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
@RequestMapping(value="/api/product")
public class ProductsRest {
	@Autowired
	private IProductsService productService;
	@RequestMapping(value="/getall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelDTO<Products> getAll()
	{
		ModelDTO<Products> dto=new ModelDTO<Products>();
		dto.setData(productService.getAll());
		dto.setItemCount(productService.getAll().size());
		return dto;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public int update(@RequestBody String models)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			Products product=obj.readValue(models, Products.class);
			productService.update(product);
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
			Products product = obj.readValue(models, Products.class);
			productService.add(product);
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
			Products product = obj.readValue(models, Products.class);
			productService.delete(product.getProductId());
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
