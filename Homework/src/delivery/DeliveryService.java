package delivery;

import java.util.List;
import java.util.Scanner;

/**
 * controller와 DAO의 중계
 */
public class DeliveryService {
	
	// Scanner
	Scanner sc = new Scanner(System.in);
	
	// index
	int INDEX;
	
	private DeliveryDAO dao;

	public DeliveryService(DeliveryDAO dao) {
		this.dao = dao;
		this.INDEX = getId();
	}

	/**
	 * 읽어온 파일에서 가장 큰 id값을 반환
	 */
	private int getId() {
		int max = 0;
		for (DeliveryDTO dto : dao.findAll()) {
			if(dto.getId() > max) max = dto.getId();
		}
		return max;
	}
	
	/**
	 * 객체 등록 Service
	 */
	public void saveDelivery(String name, int price, int posOrderCnt, int orderCnt) {
		
		DeliveryDTO dto = new DeliveryDTO(++INDEX, name, price, posOrderCnt, orderCnt);
		// DAO에서 데이터 저장
		dao.save(dto);
		
	}
	
	/**
	 * 전체 목록 반환
	 */
	public List<DeliveryDTO> getAllDelivery(){
		return dao.findAll();
	}
	
	/**
	 * 입력받은 번호에 해당하는 배달 조회
	 * @param id
	 */
	public void getDeliveryById(int id) {
		
		DeliveryDTO dto = dao.getDeliveryById(id);
		if(dto == null) {
			System.out.println("일치하는 항목이 없습니다.");
		} else {
			System.out.println(dto);
		}
		
	}

	/**
	 * 입력받은 번호에 해당하는 배달 삭제
	 * @param id
	 */
	public void deleteDeliveryById(int id) {
		
		// DAO에서 객체 삭제 및 결과 반환
		if(dao.deleteById(id)) {
			System.out.println("[" + id + "]번 배달주문 삭제 완료");
		} else {
			System.out.println("일치하는 항목이 없습니다.");
		}
		
	}

	/**
	 * 입력받은 번호에 해당하는 배달 수정
	 * @param id 
	 */
	public void updateDeliveryById(int id) {
		
		DeliveryDTO dto = dao.getDeliveryById(id);
		
		if(dto == null) {
			System.out.println("일치하는 항목이 없습니다.");
		} else {
			System.out.printf("품목명 변경 %s -> ", dto.getName());
			String reName = sc.nextLine();
			
			System.out.printf("가격 변경 %d -> ", dto.getPrice());
			int rePrice = sc.nextInt();
			sc.nextLine();
			
			System.out.printf("주문가능수량 변경 %d -> ", dto.getPosOrderCnt());
			int rePosOrderCnt = sc.nextInt();
			sc.nextLine();

			System.out.printf("주문수량 변경 %d -> ", dto.getOrderCnt());
			int reOrderCnt = sc.nextInt();
			sc.nextLine();
			
			// DAO에서 객체 수정
			dao.updateById(id, reName, rePrice, rePosOrderCnt, reOrderCnt);
			System.out.println("[" + id + "]번 배달주문 수정 완료");
		}
	}

	/**
	 * 통계 정보 출력
	 */
	public void getStat() {
		
		List<DeliveryDTO> list = getAllDelivery();
		
		if(list.size() == 0) {
			System.out.println("등록된 배달주문이 없습니다.");
		} else {
			int totalCnt = list.size();
			int totalSum = getTotalSum(list);

			System.out.println("전체 주문수: " + totalCnt + "건");
			System.out.println("전체 주문의 합계: " + String.format("%,d원", totalSum));
		}
		
	}

	/**
	 * 전체 주문 가격 반환
	 * @param list
	 */
	private int getTotalSum(List<DeliveryDTO> list) {
		
		int result = 0;
		
		for (DeliveryDTO dto : list) {
			result += (dto.getPrice() * dto.getOrderCnt());
		}
		
		return result;
	}

}
