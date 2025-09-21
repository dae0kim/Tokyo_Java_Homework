package day6;

import java.util.List;
import java.util.Scanner;

/**
 * 과제3)<br>
 * 사용자의 입/출력 제어하는 클래스
 */
public class GymController {
	
	// Scanner 정의
	Scanner sc = new Scanner(System.in);
	
	private GymService service;
	
	public GymController(GymService service) {
		this.service = service;
	}
	
	// 동작 실현 메서드
	public void run() {
		
		while(true) {
			System.out.println("=======================================");
			System.out.println("번호입력>> 1.회원 정보 입력, 2.회원 정보 조회, 0.프로그램 종료");
			int q = sc.nextInt();
			sc.nextLine();
			
			switch (q) {
				case 1:
					addInfo();
					break;
				case 2:
					showGym();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("숫자만 입력해주세요.");
			}
			
		}// while end

	}// run end
	
	// case 1 회원 정보 추가하는 메서드
	void addInfo() {
		System.out.print("회원 이름: ");
		String name = sc.nextLine();

		System.out.print("회원 번호: ");
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("기준칼로리: ");
		int stdKcal = sc.nextInt();
		sc.nextLine();

		System.out.print("소비칼로리: ");
		int csmKcal = sc.nextInt();
		sc.nextLine();
		
		// 입력받은 정보를 service로 넘겨줌
		service.addGym(name, num, stdKcal, csmKcal);
		System.out.println("회원 정보 등록 완료");
	}
	
	// case 2 회원 정보 출력 메서드
	void showGym() {
		List<GymDTO> gym = service.getAllGym();
		for(GymDTO dto : gym) {
			System.out.println(dto);
		}
	}
	
}
