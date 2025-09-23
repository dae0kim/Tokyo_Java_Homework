package product;

import java.util.Scanner;

/**
 * 사용자 입,출력 제어 클래스
 */
public class ProductController {

	// Scanner 정의
	Scanner sc = new Scanner(System.in);
	
	// Service 호출하기 위해 선언
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	// 사용자 동작
	public void run() {
		
		// 종료 입력전까지 계속 실행
		while(true) {
			System.out.println("번호입력>> 1.상품등록, 2.전체 상품조회, 3. 개별 상품조회, 4. 상품정보 삭제, 5. 상품정보 수정, 6. 상품분석, 0. 프로그램 종료");
			int n = sc.nextInt();
			sc.nextLine();
			
			switch (n) {
				// 상품 등록
				case 1: service.addProduct(); break;
				
				// 전체 상품 조회
				case 2: service.outAllProduct(); break;
				
				// 개별 상품 조회	
				case 3: service.showProduct(); break;
				
				// 상품 정보 삭제	
				case 4:	service.delProduct(); break;
				
				// 상품 정보 수정	
				case 5: service.updateProduct(); break;
				
				// 상품 분석
				case 6: service.getAnalysis(); break;
				
				// 프로그램 종료
				case 0: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("숫자만 입력하세요.");
			}
		}
	}
}
