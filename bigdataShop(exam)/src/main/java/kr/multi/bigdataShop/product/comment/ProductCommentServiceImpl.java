package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class ProductCommentServiceImpl implements ProductCommentService {
	@Autowired
	@Qualifier("productdao")
	ProductCommentDAO dao;

	@Override
	public List<ProductCommentDTO> productCommentList(String prd_no) {
		List<ProductCommentDTO> pCommentList = dao.productCommentList(prd_no);
		return pCommentList;
	}

	@Override
	public int addComment() {
		int resInsert = dao.addComment(ProductCommentDTO pComment);
		return resInsert;
	}


}











