package mta.th12a.tuanhiep.controller.customerpage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mta.th12a.tuanhiep.dto.CategoryDTO;
import mta.th12a.tuanhiep.dto.ProductDTO;
import mta.th12a.tuanhiep.model.Categories;
import mta.th12a.tuanhiep.model.Products;
import mta.th12a.tuanhiep.service.ICategoriesService;
import mta.th12a.tuanhiep.service.IProductsService;

@Controller
public class ProductCustomerController extends BaseController{
	@Autowired
	ICategoriesService category;
	@Autowired
	IProductsService product;
	@RequestMapping("/product")
	public String index(ModelMap model)
	{
		return "product-customer";
	}
	@RequestMapping("/product/{id}")
	public String categoryProduct(@PathVariable(value="id") int id,ModelMap model)
	{
		ArrayList<ProductDTO> listProduct=new ArrayList<ProductDTO>();
		listProduct=(ArrayList<ProductDTO>) product.getListByCategoryID(id);
		model.put("listProduct", listProduct);
		return "product-customer";
	}
}
