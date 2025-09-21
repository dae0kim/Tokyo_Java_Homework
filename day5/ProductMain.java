package day5;

/**
 * 과제 5)<br>
 * 동작 클래스
 */
public class ProductMain {

	public static void main(String[] args) {
		
		// 객체 생성
		Product pd = new Product();
		
		// set 메서드로 값 저장
		pd.setName("키보드");
		pd.setPrice(200000);
		
		// toString()으로 출력
		System.out.println(pd.toString());
	}

}
