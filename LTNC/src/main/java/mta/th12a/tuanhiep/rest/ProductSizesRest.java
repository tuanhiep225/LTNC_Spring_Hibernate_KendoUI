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
import mta.th12a.tuanhiep.model.Brands;
import mta.th12a.tuanhiep.model.ProductSizes;
import mta.th12a.tuanhiep.service.IBrandsService;
import mta.th12a.tuanhiep.service.IProductSizesService;

@RestController
@RequestMapping(value="/api/product-size")
public class ProductSizesRest {
	@Autowired
	private IProductSizesService productSizeService;
	@RequestMapping(value="/getall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelDTO<ProductSizes> getAll()
	{
		ModelDTO<ProductSizes> dto=new ModelDTO<ProductSizes>();
		dto.setData(productSizeService.getAll());
		dto.setItemCount(productSizeService.getAll().size());
		return dto;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public int update(@RequestBody String models)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			ProductSizes productSize=obj.readValue(models, ProductSizes.class);
			productSizeService.update(productSize);
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
			ProductSizes productSize = obj.readValue(models, ProductSizes.class);
			productSizeService.add(productSize);
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
			ProductSizes productSize = obj.readValue(models, ProductSizes.class);
			productSizeService.delete(productSize.getProductSizeId());
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
