package day5;

/**
 * 과제 2)<br>
 * Book을 상속받는 전공서적 클래스
 */
public class TextBook extends Book {	// 조건 3. Book을 상속
	
	// 조건 4. 과목명 추가
	private String subject;

	// getter/setter 생성
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	// 정보를 출력할 메서드 생성
	public void textBookInfo() {
		System.out.println("전공책 제목: " + getTitle() + ", 저자: " + getAuthor() + ", 가격: " + getPrice() + ", 과목: " + getSubject());
	}
}
