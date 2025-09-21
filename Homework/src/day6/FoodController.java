package day6;

import java.util.List;
import java.util.Scanner;

/**
 * 과제2)<br>
 * 사용자의 입/출력 제어하는 클래스
 */
public class FoodController {
	
	// Scanner 정의
	Scanner sc = new Scanner(System.in);
	
	private FoodService service;
	
	public FoodController(FoodService service) {
		this.service = service;
	}
	
	// 동작 실현 메서드
	public void run() {
		
		while(true) {
			System.out.println("=======================================");
			System.out.println("번호입력>> 1.식자재 정보 입력, 2.식자재 정보 조회, 0.프로그램 종료");
			int q = sc.nextInt();
			sc.nextLine();
			
			switch (q) {
				case 1:
					addInfo();
					break;
				case 2:
					showFood();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("숫자만 입력해주세요.");
			}
			
		}// while end

	}// run end
	
	// case 1 식자재 정보 추가하는 메서드
	void addInfo() {
		System.out.print("식자재 번호: ");
		int foodNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("식자재 이름: ");
		String name = sc.nextLine();
		
		System.out.print("수량: ");
		int count = sc.nextInt();
		sc.nextLine();

		System.out.print("등록일: ");
		String rgstDate = sc.nextLine();
		
		// 입력받은 정보를 service로 넘겨줌
		service.addFood(foodNum, name, count, rgstDate);
		System.out.println("식자재 정보 등록 완료");
	}
	
	// case 2 반려동물 정보 출력 메서드
	void showFood() {
		List<FoodDTO> food = service.getAllFood();
		for(FoodDTO dto : food) {
			System.out.println(dto);
		}
	}
}
