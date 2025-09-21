package day5;

/**
 * 과제 2)<br>
 * 책 객체 클래스
 */
public class Book {
	
	// 조건 1. 제목, 저자, 가격 private 변수
	private String title;
	private String author;
	private int price;

	// 조건 2. 책 정보는 getter/setter로만 접근 가능
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	// 정보를 출력할 메서드 생성
	public void bookInfo() {
		System.out.println("제목: " + getTitle() + ", 저자: " + getAuthor() + ", 가격: " + getPrice());
	}
	
}
