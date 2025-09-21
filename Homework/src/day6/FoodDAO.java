package day6;

import java.util.ArrayList;
import java.util.List;

/**
 * 과제2)<br>
 * 식자재 정보를 담은 리스트 저장, 조회
 */
public class FoodDAO {

	// 식자재 정보 저장할 리스트 생성
	private List<FoodDTO> foodList = new ArrayList<>();
	
	// 식자재 리스트에 추가
	public void save (FoodDTO dto) {
		foodList.add(dto);
	}
	
	// 식자재 리스트 조회
	public List<FoodDTO> findAll(){
		return foodList;
	}
	
}
