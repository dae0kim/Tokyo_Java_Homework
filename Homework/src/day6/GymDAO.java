package day6;

import java.util.ArrayList;
import java.util.List;

/**
 * 과제3)<br>
 * 회원 정보를 담은 리스트 저장, 조회
 */
public class GymDAO {

	// 회원 정보 저장할 리스트 생성
	private List<GymDTO> gymList = new ArrayList<>();
	
	// 회원정보 리스트에 추가
	public void save (GymDTO dto) {
		gymList.add(dto);
	}
	
	// 회원정보 리스트 조회
	public List<GymDTO> findAll(){
		return gymList;
	}
}
