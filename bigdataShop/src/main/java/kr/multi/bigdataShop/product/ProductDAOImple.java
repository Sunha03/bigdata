package kr.multi.bigdataShop.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productDAO")
public class ProductDAOImple implements ProductDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<ProductDTO> productlist(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> hitproduct() {		//히트상품의 목록을 조회하는 메소드
		List<ProductDTO> hitList = sqlSession.selectList("kr.mulit.bigdataShop.hitproduct");
		return hitList;
	}

	@Override
	public List<ProductDTO> newproduct() {		//new상품의 목록을 조회하는 메소드
		List<ProductDTO> newList = sqlSession.selectList("kr.mulit.bigdataShop.newproduct");
		return newList;
	}

	@Override
	public ProductDTO read(String prd_no) {
		// TODO Auto-generated method stub
		return null;
	}

}
