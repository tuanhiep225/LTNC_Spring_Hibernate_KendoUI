package mta.th12a.tuanhiep.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import mta.th12a.tuanhiep.dto.BaseDTO;
import mta.th12a.tuanhiep.dto.ModelDTO;
import mta.th12a.tuanhiep.model.Brands;
import mta.th12a.tuanhiep.service.IBrandsService;

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

import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

@RestController
@RequestMapping(value="/api/brand")
public class BrandsRest {
	@Autowired
	private IBrandsService brandService;
	@RequestMapping(value="/getall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelDTO<Brands> getAll()
	{
		ModelDTO<Brands> dto=new ModelDTO<Brands>();
		dto.setData(brandService.getAll());
		dto.setItemCount(brandService.getAll().size());
		return dto;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public int update(@RequestBody String models)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			Brands brand=obj.readValue(models, Brands.class);
			brandService.update(brand);
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
			Brands brand = obj.readValue(models, Brands.class);
			brandService.add(brand);
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
			Brands brand = obj.readValue(models, Brands.class);
			brandService.delete(brand.getBrandId());
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
