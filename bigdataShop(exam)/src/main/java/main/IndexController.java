package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.multi.bigdataShop.product.ProductDTO;
import kr.multi.bigdataShop.product.ProductService;


@Controller
public class IndexController{
	@Autowired
	ProductService service;
	
	@RequestMapping("/index.do")
	public ModelAndView main(){
		ModelAndView mav = new ModelAndView();
		
		List<ProductDTO> hitList = service.hitproduct();
		List<ProductDTO> newList = service.newproduct();
		
		mav.addObject("hitList", hitList);
		mav.addObject("newList", newList);
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/admin/index.do")
	public String adminMain(){
		return "admin/index";
	}
}
