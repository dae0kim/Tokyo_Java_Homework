package day6;

import java.util.List;
import java.util.Scanner;

/**
 * 과제1)<br>
 * 사용자의 입/출력 제어하는 클래스
 */
public class PetController {
	
	// Scanner 정의
	Scanner sc = new Scanner(System.in);
	
	private PetService service;
	
	public PetController(PetService service) {
		this.service = service;
	}
	
	// 동작 실현 메서드
	public void run() {
		
		while(true) {
			System.out.println("=======================================");
			System.out.println("번호입력>> 1.반려동물 정보 입력, 2.반려동물 정보 조회, 0.프로그램 종료");
			int q = sc.nextInt();
			sc.nextLine();
			
			switch (q) {
				case 1:
					addInfo();
					break;
				case 2:
					showPet();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("숫자만 입력해주세요.");
			}
			
		}// while end

	}// run end
	
	// case 1 반려동물 정보 추가하는 메서드
	void addInfo() {
		System.out.print("아이디: ");
		String id = sc.nextLine();
		
		System.out.print("보호자 이름: ");
		String masterName = sc.nextLine();
		
		System.out.print("반려동물 이름: ");
		String petName = sc.nextLine();

		System.out.print("반려동물 나이: ");
		int petAge = sc.nextInt();
		sc.nextLine();

		System.out.print("연락처: ");
		String phoneNum = sc.nextLine();
		
		// 입력받은 정보를 service로 넘겨줌
		service.addPet(id, masterName, petName, petAge, phoneNum);
		System.out.println("반려동물 정보 등록 완료");
	}
	
	// case 2 반려동물 정보 출력 메서드
	void showPet() {
		List<PetDTO> pet = service.getAllPet();
		for(PetDTO dto : pet) {
			System.out.println(dto);
		}
	}
}
