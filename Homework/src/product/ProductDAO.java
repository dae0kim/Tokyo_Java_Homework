package product;

import java.util.ArrayList;
import java.util.List;

/**
 * 데이터 관리, Service에 데이터 제공하는 클래스
 */
public class ProductDAO {
	
	List<ProductDTO> productList = new ArrayList<>();

	/**
	 * 상품 정보를 전달받아 List에 추가
	 * @param dto
	 */
	public void save(ProductDTO dto) {
		productList.add(dto);
	}
	
	/**
	 * 전체 저장된 상품 목록을 호출
	 */
	public List<ProductDTO> findAll(){
		return productList;
	}
}
