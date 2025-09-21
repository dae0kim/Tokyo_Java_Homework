package day6;

/**
 * 과제1)<br>
 * 반려동물 정보 관리 메인 클래스
 */
public class PetMain {

	public static void main(String[] args) {
		
		PetDAO dao = new PetDAO();
		PetService service = new PetService(dao);
		PetController controller = new PetController(service);
		
		controller.run();
	}

}
