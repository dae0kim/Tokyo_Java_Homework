package product;

/*
 * 상품관리 프로그램
 * 1. 상품 등록 : 상품명, 수량, 가격, 상품번호
 * 2. 전체 상품 조회 : 상품번호, 상품명, 수량, 가격, 합계 출력
 * 3. 개별 상품 조회 : 원하는 번호 입력 시 해당 상품 출력
 * 4. 상품 정보 삭제 : 원하는 번호 입력 시 해당 상품 삭제
 * 5. 상품 정보 수정 : 원하는 번호 입력 시 해당 상품만 수정(상품번호는 수정x)
 * 6. 상품 분석 : 전체 상품의 갯수, 전체 상품의 합계
 * 0. 프로그램 종료
 * 
 * 
 */
/**
 * 상품 정보를 담는 객체 클래스
 */
public class ProductDTO {

	// field
	private int id;			// 상품번호
	private String name;	// 상품명
	private int qty;		// 수량
	private int price;		// 가격
	private int total;		// 합계(qty * price)
	
	// 기본생성자
	public ProductDTO() {}
	
	// 생성자
	public ProductDTO(int id, String name, int qty, int price) {
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	
	// get/set
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
		setTotal();	// 자동갱신
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
		setTotal();	// 자동갱신
	}
	
	public int getTotal() {
		return total;
	}
	// 수량과 가격이 바뀔 때 마다 자동 계산하여 갱신
	public void setTotal() {
		this.total = this.price * this.qty;
	}
	
	/*
	 * %,d -> 정수 3자리마다 , 자동 삽입
	 */
	// 가격, 합계에 사용
	private String formatMoney(int money) {
		return String.format("%,d원", money);
	}

	@Override
	public String toString() {
		return String.format("상품번호:%d, 상품명:%s, 수량:%d, 가격:%s, 합계:%s", id, name, qty, formatMoney(price), formatMoney(total));
	}
	
}
