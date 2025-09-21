package day6;

/**
 * 과제2)<br>
 * 식자재 정보 관리 메인 클래스
 */
public class FoodMain {

	public static void main(String[] args) {
		
		FoodDAO dao = new FoodDAO();
		FoodService service = new FoodService(dao);
		FoodController controller = new FoodController(service);
		
		controller.run();
	}

}
