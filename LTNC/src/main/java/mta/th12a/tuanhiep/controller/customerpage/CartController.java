package mta.th12a.tuanhiep.controller.customerpage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mta.th12a.tuanhiep.dto.Cart;
import mta.th12a.tuanhiep.dto.ItemDTO;
import mta.th12a.tuanhiep.model.ProductColors;
import mta.th12a.tuanhiep.model.ProductSizes;
import mta.th12a.tuanhiep.model.ProductStores;
import mta.th12a.tuanhiep.service.IProductCorlorsService;
import mta.th12a.tuanhiep.service.IProductSizesService;
import mta.th12a.tuanhiep.service.IProductsService;
import mta.th12a.tuanhiep.service.IProductsStoresService;

@Controller
@RequestMapping(value="/cart")
public class CartController extends BaseController {
	@Autowired IProductsService product;
	@Autowired IProductCorlorsService color;
	@Autowired IProductSizesService size;
	@Autowired IProductsStoresService productStore;
	@RequestMapping(value="/insert",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,Double> insertToCart(int productId,int sizeId,int colorId,int soLuong,HttpSession session)
	{
		Cart cart =null;
		double status=0;
		double total=0;
		double count=0;
		ProductStores sp=(ProductStores) productStore.FindByColorAndSize(productId, colorId, sizeId);
		if(sp!=null)
		{
			if(session.getAttribute("cart")!=null){
				cart=(Cart)session.getAttribute("cart");			
				cart.insertToCart(sp.getProductStoreId(), new ItemDTO(sp,soLuong));
				total= cart.total();
				count=cart.countItem();
				session.setAttribute("cart", cart);
			}
			else
			{
				cart=new Cart();				
				cart.insertToCart(sp.getProductStoreId(), new ItemDTO(sp,soLuong));
				total= cart.total();
				count=cart.countItem();
				session.setAttribute("cart", cart);
			}
			status=1;
		}
		else
		{
			if(session.getAttribute("cart")!=null)
			{
				cart=(Cart)session.getAttribute("cart");			
				total= cart.total();
				count=cart.countItem();
			}
		}
		Map<String,Double> result= new HashMap<>();
		result.put("total", total);
		result.put("count", count);
		result.put("status", status);
		return result;
	}
	@RequestMapping(value="/checkout")
	public String viewCheckout()
	{
		return "checkout";
	}
	@RequestMapping(value="/getlistcolor",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProductColors> getListColor(int id)
	{
		return color.getByIdProduct(id);
	}
	
	@RequestMapping(value="/getlistsize",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProductSizes> getListSize(int id)
	{
		return size.getByIdProduct(id);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,Double> updateCart(int productStoreId,int soLuong,HttpSession session)
	{
		Cart cart =null;
		double status=0;
		double total=0;
		double count=0;
		if(session.getAttribute("cart")!=null){
			cart=(Cart)session.getAttribute("cart");			
			status=cart.updatToCart(productStoreId, soLuong);
			total= cart.total();
			count=cart.countItem();
			session.setAttribute("cart", cart);
			status=1;
		}
		Map<String,Double> result= new HashMap<>();
		result.put("total", total);
		result.put("count", count);
		result.put("status", status);
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,Double> removeItem(int productStoreId,HttpSession session)
	{
		Cart cart =null;
		double status=0;
		double total=0;
		double count=0;
		if(session.getAttribute("cart")!=null){
			cart=(Cart)session.getAttribute("cart");			
			status=cart.removeToCart(productStoreId);
			total= cart.total();
			count=cart.countItem();
			session.setAttribute("cart", cart);
			status=1;
		}
		Map<String,Double> result= new HashMap<>();
		result.put("total", total);
		result.put("count", count);
		result.put("status", status);
		return result;
	}
}
