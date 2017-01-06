package mta.th12a.tuanhiep.rest;

import java.io.IOException;
import java.util.List;

import mta.th12a.tuanhiep.model.OrderDetails;
import mta.th12a.tuanhiep.service.IOrderDetailsService;

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
public class OrderDetailsRest {
	@Autowired
	private IOrderDetailsService orderDetailService;
	@RequestMapping(value="/orderdetail/getall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDetails> getAll()
	{
		return orderDetailService.getAll();
	}	
	@RequestMapping(value="/orderdetail/update",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public int update(@RequestBody String data)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			OrderDetails orderdetail=obj.readValue(data, OrderDetails.class);
			orderDetailService.update(orderdetail);
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
	@RequestMapping(value="/orderdetail/create",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public int create(@RequestBody String data)
	{
		ObjectMapper obj= new ObjectMapper();
		try {
			OrderDetails orderdetail = obj.readValue(data, OrderDetails.class);
			orderDetailService.add(orderdetail);
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
	@RequestMapping(value="/orderdetail/delete/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public int delete(@PathVariable("id") int data)
	{
		try{
			
			orderDetailService.delete(data);
			return 1;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return 0;
	}
}
