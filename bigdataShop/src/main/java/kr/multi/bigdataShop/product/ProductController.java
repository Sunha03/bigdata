package kr.multi.bigdataShop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@RequestMapping("product/list.do")
	public ModelAndView getProductList(String category) {
		ModelAndView mav = new ModelAndView();
		
		List<ProductDTO> productList = service.productlist(category);
		
		mav.addObject("productList", productList);
		mav.setViewName("product/list");
		
		return mav;
	}
}
