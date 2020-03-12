package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("productdao")
public class ProductCommentDAOImpl implements ProductCommentDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<ProductCommentDTO> productCommentList(String prd_no) {
		List<ProductCommentDTO> pCommentList 
			= sqlSession.selectList("kr.multi.bigdataShop.product.comment.selectComment", prd_no);
		return pCommentList;
	}

	@Override
	public int addComment(ProductCommentDTO pComment) {
		int resInsert
			= sqlSession.insert("kr.multi.bigdataShop.product.comment.insertComment", pComment);
		return resInsert;
	}

}













