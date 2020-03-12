package kr.multi.bigdataShop.product.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProductCommentController {
	@Autowired
	ProductCommentService service;
	
	@RequestMapping("/product/list.do")
	public ModelAndView commentList(String prd_no){
		System.out.println("[comment] prd_no => " + prd_no);
		
		ModelAndView mav = new ModelAndView();
		List<ProductCommentDTO> list = service.productlist(prd_no);
		/*List<ProductCommentDTO> list = service.productlist(category);
		mav.addObject("prdlist", list);//db에서 조회한 결과 
		                               //- 서블릿에서 request.setAttribute
		mav.setViewName("product/list");*/
		return mav;
	}
	

	@RequestMapping("/product/read.do")
	public String showProduct(String prd_no,String category,
									Model model,HttpServletRequest req) {
		
		/*ProductCommentDTO product = service.read(prd_no);
		model.addAttribute("product", product);*/
		return "product/read";
	}
}









