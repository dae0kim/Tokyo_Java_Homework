package product;

import java.util.List;
import java.util.Scanner;

/**
 * 비즈니스 로직 구현 클래스
 */
public class ProductService {
	
	// Scanner 정의
	Scanner sc = new Scanner(System.in);

	// 상품정보 담는 객체
	private ProductDAO dao;
	
	// 의존성 주입
	public ProductService(ProductDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * 상품 등록 메서드
	 * @param id
	 * @param name
	 * @param qty
	 * @param price
	 */
	public void addProduct() {
		
		System.out.print("상품번호: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("상품명: ");
		String name = sc.nextLine();
		
		System.out.print("수량: ");
		int qty = sc.nextInt();
		sc.nextLine();

		System.out.print("가격: ");
		int price = sc.nextInt();
		sc.nextLine();
		
		// 상품 정보가 담긴 객체 생성
		ProductDTO dto = new ProductDTO(id, name, qty, price);
		// 합계 갱신
		dto.setTotal();
		
		// 값 저장된 객체를 List에 저장
		dao.save(dto);
		
		// 안내문구
		System.out.println("상품 등록이 완료되었습니다.");
	}

	/**
	 * 등록된 모든 상품이 담긴 List 반환 메서드
	 */
	public List<ProductDTO> getAllProducts() {
		return dao.findAll();
	}

	/**
	 * 입력받은 상품번호에 해당하는 상품 정보를 출력 메서드
	 * @param productId
	 */
	public void showProduct() {
		
		System.out.print("조회하려는 상품의 번호를 입력하세요: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		// 입력받은 상품번호와 일치하는 객체 반환
		ProductDTO dto = findItem(id);
		
		if(dto == null) {
			System.out.println("일치하는 상품이 없습니다.");
		} else {
			// 상품번호에 해당하는 값만 출력
			System.out.println(dto);
		}
		
	}

	/**
	 * 입력받은 상품번호에 해당하는 상품 삭제 메서드
	 */
	public void delProduct() {
		
		System.out.print("삭제하려는 상품의 번호를 입력하세요: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		// 입력받은 상품번호와 일치하는 객체 반환
		ProductDTO dto = findItem(id);

		// 전체 상품 리스트 반환
		List<ProductDTO> products = getAllProducts();
		if(dto == null) {
			System.out.println("일치하는 상품이 없습니다.");
		} else {
			// 상품번호에 해당하는 값 삭제
			products.remove(dto);
			// 안내문구 출력
			System.out.println("상품번호 [" + id + "]가 삭제되었습니다.");
		}
		
	}

	/**
	 * 입력받은 상품번호에 해당하는 상품정보 업데이트 메서드
	 * @param updateId
	 * @param rePrice 
	 * @param reQty 
	 * @param reName2 
	 */
	public void updateProduct() {
		
		System.out.print("수정하려는 상품의 번호를 입력하세요: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		// 입력받은 상품번호와 일치하는 객체 반환
		ProductDTO dto = findItem(id);
		if(dto == null) {
			System.out.println("일치하는 상품이 없습니다.");
		} else {
			System.out.println("[현재 상품 정보]" + dto);

			System.out.print("변경후 상품명: ");
			String reName = sc.nextLine();
			dto.setName(reName);
			
			System.out.print("변경후 수량: ");
			int reQty = sc.nextInt();
			sc.nextLine();
			dto.setQty(reQty);
			
			System.out.print("변경후 가격: ");
			int rePrice = sc.nextInt();
			sc.nextLine();
			dto.setPrice(rePrice);
			
			// 안내문구
			System.out.println("정보 수정이 완료되었습니다.");
			System.out.println("[변경된 상품 정보]" + dto);
			
		}
		
		
	}

	/**
	 * 상품 분석 : 전체 상품의 갯수, 전체 상품의 합계
	 */
	public void getAnalysis() {
		
		// 전체 상품 리스트 반환
		List<ProductDTO> products = getAllProducts();
		
		// 전체 상품의 갯수
		if(products.isEmpty()) {
			System.out.println("등록된 상품이 없습니다.");
		} else {
			int totalCnt = products.size();
			int totalSum = getTotalSum(products);

			System.out.println("전체 상품의 갯수: " + totalCnt);
			System.out.println("전체 상품의 합계: " + String.format("%,d", totalSum));
		}
	
	}

	/**
	 * 전체 상품의 합계를 반환하는 메서드
	 * @param products 
	 */
	private int getTotalSum(List<ProductDTO> products) {

		int sum = 0;
		
		for (ProductDTO dto : products) {
			sum += dto.getTotal();
		}
		
		return sum;
	}

	/**
	 * 전체 상품 조회
	 */
	public void outAllProduct() {
		
		// 전체 상품 리스트 반환
		List<ProductDTO> products = getAllProducts();
		
		// 아직 등록된 데이터가 없는 경우 alert
		if(products.isEmpty()) {
			System.out.println("등록된 상품이 없습니다.");
		} else {
			for (ProductDTO dto : products) {
				System.out.println(dto);
			}
		}
	}
	
	/**
	 * 전체 리스트중에 입력한 상품번호와 일치하는 객체를 찾아서 반환
	 * @param id
	 */
	private ProductDTO findItem(int id) {
		
		// 전체 상품 리스트 반환
		List<ProductDTO> products = getAllProducts();
		
		// 일치하는 객체를 담을 변수
		ProductDTO dto;
		
		// 전체 리스트 순회하여 상품번호가 동일한 객체 저장
		for(int i = 0; i < products.size(); i++) {
			ProductDTO temp = products.get(i);
			if(temp.getId() == id) {
				dto = temp;
				return dto;
			}
		}
		return null;
	}

}
