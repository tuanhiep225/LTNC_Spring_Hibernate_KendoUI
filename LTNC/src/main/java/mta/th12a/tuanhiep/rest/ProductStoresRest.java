package mta.th12a.tuanhiep.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import antlr.collections.List;
import mta.th12a.tuanhiep.dto.ModelDTO;
import mta.th12a.tuanhiep.dto.Result;
import mta.th12a.tuanhiep.model.Brands;
import mta.th12a.tuanhiep.model.ProductStores;
import mta.th12a.tuanhiep.service.IBrandsService;
import mta.th12a.tuanhiep.service.IProductsStoresService;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
@RestController
@RequestMapping(value="/api/product-store")
public class ProductStoresRest {
	@Autowired
	private IProductsStoresService productStoreService;
	@RequestMapping(value="/getall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelDTO<ProductStores> getAll()
	{
		ModelDTO<ProductStores> dto=new ModelDTO<ProductStores>();
		ArrayList<ProductStores> list=(ArrayList<ProductStores>) productStoreService.getAll();
		dto.setData(list);
		dto.setItemCount(list.size());
		return dto;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public int update(@RequestBody String models)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			ProductStores productStore=obj.readValue(models, ProductStores.class);
			productStoreService.update(productStore);
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
	@RequestMapping(value="/create",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Result create(@RequestBody String models)
	{
		String data="";
		Result result=new Result();
		try {
			data= URLDecoder.decode(models,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ObjectMapper obj= new ObjectMapper();
		try {
			ProductStores productStore = obj.readValue(data, ProductStores.class);
			productStoreService.add(productStore);
			result.setStatus(1);
			return result;
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
		result.setStatus(0);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public int delete(@RequestBody String models)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			ProductStores productStore = obj.readValue(models, ProductStores.class);
			productStoreService.delete(productStore.getProductStoreId());
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
