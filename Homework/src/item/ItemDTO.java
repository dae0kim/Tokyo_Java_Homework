package item;

/*
 * 요구사항
 * - 아이템 번호(index 자동 증가), 아이템명, 수량, 가격, 합계
 * 1. 아이템 입력(외부문서)
 * 2. 아이템 전체 조회
 * 3. 아이템 개별 조회
 * 4. 아이템 삭제
 * 5. 아이템 수정 : 아이템명, 수량, 가격
 * 6. 통계
 * 0. 프로그램 종료
 */
public class ItemDTO {
	
	// field
	private int id;			// 아이템 번호
	private String name;	// 아이템명
	private int qty;		// 수량
	private int price;		// 가격
	private int total;		// 합계
	
	// 생성자
	public ItemDTO() {}

	public ItemDTO(int id, String name, int qty, int price) {
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
		setTotal();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		setTotal();
	}

	public int getTotal() {
		return total;
	}

	// 수량, 가격 변동 시 자동 갱신
	public void setTotal() {
		this.total = this.price * this.qty;
	}
	
	private String formatMoney(int money) {
		return String.format("%,d원", money);
	}
	
	@Override
	public String toString() {
		return String.format("아이템번호:%d, 아이템명:%s, 수량:%d, 가격:%s, 합계:%s", id, name, qty, formatMoney(price), formatMoney(total));
	}
	
}
