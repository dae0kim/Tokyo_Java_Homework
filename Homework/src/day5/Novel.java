package day5;

/**
 * 과제 2)<br>
 * Book을 상속받는 소설 클래스
 */
public class Novel extends Book {

	// 조건 5. 장르 추가
	private String genre;

	// getter/setter 생성
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	// 정보를 출력할 메서드 생성
	public void novelInfo() {
		System.out.println("소설 제목: " + getTitle() + ", 저자: " + getAuthor() + ", 가격: " + getPrice() + ", 장르: " + getGenre());
	}
	
}
