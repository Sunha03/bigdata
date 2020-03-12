package kr.multi.bigdataShop.product.comment;

import java.util.List;

public interface ProductCommentDAO {
	List<ProductCommentDTO> productCommentList(String prd_no);
	int addComment(ProductCommentDTO pComment);
}