package day5;

/**
 * 과제 5)<br>
 * 상품 정보 객체 클래스
 */
public class Product {
	
	// 조건 1. name, price는 private
	private String name;
	private int price;

	// get/set
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

	// 조건 2. toString() 메서드로만 출력
	@Override
	public String toString() {
		return "상품명: " + name + ", 가격: " + price + "원";
	}
	
}
