package day6;

import java.util.List;

/**
 * 과제2)<br>
 * 식자재 정보 등록, 조회 기능 구현 서비스 클래스
 */
public class FoodService {

	private FoodDAO dao;
	
	public FoodService(FoodDAO dao) {
		this.dao = dao;
	}
	
	// 전체 식자재 반환
	public List<FoodDTO> getAllFood() {
		return dao.findAll();
	}
	
	// 식자재 정보 등록
	public void addFood(int foodNum, String name, int count, String rgstDate) {
		FoodDTO dto = new FoodDTO(foodNum, name, count, rgstDate);
		// 생성된 식자재 객체를 저장
		dao.save(dto);
	}
}
