package day6;

/**
 * 과제3)<br>
 * 회원 정보 관리 메인 클래스
 */
public class GymMain {

	public static void main(String[] args) {
		
		GymDAO dao = new GymDAO();
		GymService service = new GymService(dao);
		GymController controller = new GymController(service);
		
		controller.run();
	}

}
