package product;

import java.util.List;

import product.ProductDao;
import productDto.CheckoutProdDto;
import productDto.DetailProdRespDto;
import productDto.HeaderBrandDto;
import productDto.IndexDto;
import productDto.InsertReqDto;

public class ProductService {
	private ProductDao productDao;
	
	public ProductService() {
		productDao = new ProductDao();
	}
	
	public List<IndexDto> 상품전체보기(int limitNum) {
		return productDao.findAllWithLimitNum(limitNum);
	}
	
	public List<IndexDto> 상품전체보기() {
		return productDao.findAll();
	}
	
	public int 상품등록(InsertReqDto dto) {
		return productDao.insert(dto);
	}
	
	public DetailProdRespDto 상품상세보기(int prodNo) {
		return productDao.findById(prodNo);
	}
	
	public List<IndexDto> 상품키워드찾기(String keyword) {
		return productDao.findByKeyword(keyword);
	}
	
	public List<IndexDto> 상품회사코드찾기(int compNo) {
		return productDao.findByCompNo(compNo);
	}
	
	public List<HeaderBrandDto> 회사명리스트() {
		return productDao.getAllCompName();
	}
	
	public List<IndexDto> 상품순위() {
		return productDao.findAllSortBySoldCount();
	}
	
	public CheckoutProdDto 구매상품정보(int id) {
		return productDao.findForBuy(id);
	}
	
	public List<CheckoutProdDto> 구매상품정보(List<Integer> cartList) {
		return productDao.findForBuy(cartList);
	}
	
	public void 구매수증가(int prodId) {
		productDao.updateSoldCount(prodId);
	}
}
