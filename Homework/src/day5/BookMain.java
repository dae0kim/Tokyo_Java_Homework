package day5;

/**
 * 과제 2)<br>
 * 동작 클래스
 */
public class BookMain {

	public static void main(String[] args) {
		
		// 1. 각 객체 생성
		Book book = new Book();
		TextBook textBook = new TextBook();
		Novel novel = new Novel();
		
		// 2. 각 객체의 정보를 setter로 저장
		book.setAuthor("김저자");
		book.setTitle("김책");
		book.setPrice(10000);
		
		textBook.setAuthor("박생물");
		textBook.setTitle("Cambel Biology");
		textBook.setPrice(65000);
		textBook.setSubject("Biology");
		
		novel.setAuthor("최셜록");
		novel.setTitle("셜록홈즈");
		novel.setPrice(21000);
		novel.setGenre("추리");
		
		// 3. getter와 메서드로 출력
		book.bookInfo();
		textBook.textBookInfo();
		novel.novelInfo();
	}

}
