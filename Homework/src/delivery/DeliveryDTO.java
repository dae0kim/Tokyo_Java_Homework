package delivery;

import java.text.DecimalFormat;

/**
 * 배달 주문 리스트 DTO
 */
public class DeliveryDTO {
	
	// field
	private int id;				// 번호
	private String name;		// 상품명
	private int price;			// 가격
	private int posOrderCnt;	// 주문가능수량(possible order count)
	private int orderCnt;		// 주문수량
	private int stock;			// 현재 재고(주문 후 남은 수량 = 주문가능수량 - 주문수량)
	
	// 생성자
	public DeliveryDTO() {}

	public DeliveryDTO(int id, String name, int price, int posOrderCnt, int orderCnt) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.posOrderCnt = posOrderCnt;
		this.orderCnt = orderCnt;
		this.stock = posOrderCnt - orderCnt;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPosOrderCnt() {
		return posOrderCnt;
	}
	
	public void setPosOrderCnt(int posOrderCnt) {
		this.posOrderCnt = posOrderCnt;
		setStock();	// 주문가능 수량 변경 시 재고 자동갱신
	}

	public int getOrderCnt() {
		return orderCnt;
	}

	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
		setStock();	// 주문 수량 변경 시 재고 자동갱신
	}

	public int getStock() {
		return stock;
	}

	public void setStock() {
		this.stock = this.posOrderCnt - this.orderCnt;
	}
	
	DecimalFormat df = new DecimalFormat("#,###");
	
	@Override
	public String toString() {
		return String.format("번호:%d | 품명:%s | 가격:%s | 주문가능수량:%d | 주문수량:%d | 현재재고:%d ", id, name, df.format(price), posOrderCnt, orderCnt, stock);
	}
}
