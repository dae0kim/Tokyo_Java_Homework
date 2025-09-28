package delivery;

import java.util.List;
import java.util.Scanner;

/**
 * 사용자 기능 구현<br>
 * 등록, 전체조회, 개별조회, 삭제, 수정, 통계
 */
public class DeliveryController {
	
	// Scanner
	Scanner sc = new Scanner(System.in);
	
	private DeliveryService service;

	public DeliveryController(DeliveryService service) {
		this.service = service;
	}
	
	// 사용자 동작
	public void run() {
		
		while(true) {
			System.out.println("1.등록 || 2.전체조회 || 3. 개별조회 || 4. 삭제 || 5. 수정 || 6. 통계 || 0. 종료");
			int n = sc.nextInt();
			sc.nextLine();
			
			switch (n) {
				// 등록
				case 1: addDelivery(); break;
				
				// 전체조회
				case 2: outAllDelivery(); break;
				
				// 개별조회	
				case 3: showDelivery(); break;
				
				// 삭제	
				case 4:	deleteDelivery(); break;
				
				// 수정	
				case 5: updateDelivery(); break;
				
				// 통계
				case 6: getStat(); break;
				
				// 프로그램 종료
				case 0: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("숫자만 입력하세요.");
			}
			
		}
		
	}

	/**
	 * 등록
	 */
	private void addDelivery() {
		
		System.out.print("상품명:");
		String name = sc.nextLine();
		
		System.out.print("가격:");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("주문가능수량:");
		int posOrderCnt = sc.nextInt();
		sc.nextLine();

		System.out.print("주문수량:");
		int orderCnt = sc.nextInt();
		sc.nextLine();
	
		service.saveDelivery(name, price, posOrderCnt, orderCnt);
		System.out.println("배달 주문 등록이 완료되었습니다.");
		
	}
	
	/**
	 * 전체 목록 출력
	 */
	public void outAllDelivery() {

		List<DeliveryDTO> list = service.getAllDelivery();
		
		if(list.size() == 0) {
			System.out.println("등록된 배달 주문 리스트가 없습니다.");
		} else {
			for (DeliveryDTO dto : list) {
				System.out.println(dto);
			}
		}
	
	}
	
	/**
	 * 개별 조회
	 */
	private void showDelivery() {
		
		System.out.print("조회하려는 배달 주문 번호: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		service.getDeliveryById(id);
		
	}
	
	/**
	 * 삭제
	 */
	private void deleteDelivery() {
		
		System.out.println("삭제하려는 배달 번호: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		service.deleteDeliveryById(id);
	}
	
	/**
	 * 수정
	 */
	private void updateDelivery() {
		
		System.out.println("수정하려는 배달 번호: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		service.updateDeliveryById(id);
		
	}
	
	/**
	 * 통계
	 */
	private void getStat() {
		service.getStat();
	}
}
