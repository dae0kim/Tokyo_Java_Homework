package day6;

import java.util.List;

/**
 * 과제1)<br>
 * 반려동물 정보 등록, 조회 기능 구현 서비스 클래스
 */
public class PetService {
	
	private PetDAO dao;
	
	public PetService(PetDAO dao) {
		this.dao = dao;
	}
	
	// 전체 반려동물 반환
	public List<PetDTO> getAllPet(){
		return dao.findAll();
	}
	
	// 반려동물 정보 등록
	public void addPet(String id, String masterName, String petName, int petAge, String phoneNum) {
		PetDTO dto = new PetDTO(id, masterName, petName, petAge, phoneNum);
		// 생성된 반려동물 객체를 저장
		dao.save(dto);
	}
}
