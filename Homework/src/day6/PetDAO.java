package day6;

import java.util.ArrayList;
import java.util.List;

/**
 * 과제1)<br>
 * 반려동물 정보를 담은 리스트를 저장, 조회
 */
public class PetDAO {
	
	// 반려동물 정보 저장할 리스트 생성
	private List<PetDTO> petList = new ArrayList<>();
	
	// 반려동물 리스트에 추가
	public void save (PetDTO dto) {
		petList.add(dto);
	}
	
	// 반려동물 리스트 조회
	public List<PetDTO> findAll(){
		return petList;
	}
	
}
