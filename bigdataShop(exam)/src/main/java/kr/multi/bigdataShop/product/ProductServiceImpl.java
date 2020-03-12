package kr.multi.bigdataShop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	@Qualifier("productDAO")
	ProductDAO dao;

	@Override
	public List<ProductDTO> productlist(String category) {
		List<ProductDTO> productList = dao.productlist(category);
		
		return productList;
	}

	@Override
	public List<ProductDTO> hitproduct() {
		List<ProductDTO> hitList = dao.hitproduct();
		
		return hitList;
	}

	@Override
	public List<ProductDTO> newproduct() {
		List<ProductDTO> newList = dao.newproduct();
		
		return newList;
	}

	@Override
	public ProductDTO read(String prd_no) {
		// TODO Auto-generated method stub
		return null;
	}

}
