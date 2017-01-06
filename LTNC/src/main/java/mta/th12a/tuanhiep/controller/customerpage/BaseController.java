package mta.th12a.tuanhiep.controller.customerpage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import mta.th12a.tuanhiep.dto.CategoryDTO;
import mta.th12a.tuanhiep.model.Categories;
import mta.th12a.tuanhiep.service.ICategoriesService;

@Controller
public class BaseController {
	@Autowired
	ICategoriesService category;
	@ModelAttribute
	public void getMenu(ModelMap model) {
		List<CategoryDTO> listCategoryDTO=new ArrayList<CategoryDTO>();
		List<Categories> listParentCategory=category.getListParent();
		for (Categories categories : listParentCategory) {
			CategoryDTO categoryDTO=new CategoryDTO();
			categoryDTO.setParentCategory(categories);
			List<Categories> listchild=category.getByIDParent(categories.getCategoryId());
			categoryDTO.setChildCategory(listchild);
			listCategoryDTO.add(categoryDTO);
		}
		model.put("listCategory", listCategoryDTO);
	}
}
