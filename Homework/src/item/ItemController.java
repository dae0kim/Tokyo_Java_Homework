package item;

import java.util.Scanner;

public class ItemController {

	// Scanner 정의
	Scanner sc = new Scanner(System.in);
	
	private ItemService service;
	
	public ItemController(ItemService service) {
		this.service = service;
	}
	
	// 사용자 동작
	public void run() {
		
		while(true) {
			System.out.println("1.아이템등록 || 2.전체 아이템조회 || 3. 개별 아이템조회 || 4. 아이템 삭제 || 5. 아이템 수정 || 6. 통계 || 0. 프로그램 종료");
			int n = sc.nextInt();
			sc.nextLine();
			
			switch (n) {
				// 아이템 등록
				case 1: service.addItem(); break;
				
				// 아이템 전체 조회
				case 2: service.outAllItem(); break;
				
				// 아이템 개별 조회	
				case 3: service.showItem(); break;
				
				// 아이템 삭제	
				case 4:	service.deleteItem(); break;
				
				// 아이템 수정	
				case 5: service.updateItem(); break;
				
				// 통계
				case 6: service.getStat(); break;
				
				// 프로그램 종료
				case 0: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("숫자만 입력하세요.");
			}
			
		}
		
	}
	
}
