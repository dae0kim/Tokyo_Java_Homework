package day6;

import java.util.List;

/**
 * 과제3)<br>
 * 회원 정보 등록, 조회 기능 구현 서비스 클래스
 */
public class GymService {
	
	private GymDAO dao;
	
	public GymService(GymDAO dao) {
		this.dao = dao;
	}
	
	// 전체 회원 반환
	public List<GymDTO> getAllGym() {
		return dao.findAll();
	}
	
	// 식자재 정보 등록
	public void addGym(String name, int num, int stdKcal, int csmKcal) {
		GymDTO dto = new GymDTO(name, num, stdKcal, csmKcal);
		// 생성된 회원정보 객체를 저장
		dao.save(dto);
	}
}
