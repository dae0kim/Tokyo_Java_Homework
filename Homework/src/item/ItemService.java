package item;

import java.util.List;
import java.util.Scanner;

public class ItemService {
	
	// Scanner
	Scanner sc = new Scanner(System.in);
	
	// 아이템번호 INDEX
	int INDEX = 1;
	
	private ItemDAO dao;
	
	public ItemService(ItemDAO dao) {
		this.dao = dao;
	}
	
	public List<ItemDTO> getAllItems(){
		return dao.findAll();
	}

	/**
	 * 아이템 등록
	 */
	public void addItem() {
		
		System.out.print("아이템명: ");
		String name = sc.nextLine();
		
		System.out.print("수량: ");
		int qty = sc.nextInt();
		sc.nextLine();

		System.out.print("가격: ");
		int price = sc.nextInt();
		sc.nextLine();
		
		ItemDTO dto = new ItemDTO(INDEX++, name, qty, price);
		dto.setTotal();
		// DAO에서 데이터 저장
		dao.save(dto);
		
		System.out.println("아이템 등록이 완료되었습니다.");
	}

	/**
	 * 전체 아이템 목록 출력
	 */
	public void outAllItem() {

		List<ItemDTO> item = getAllItems();
		
		if(item.size() == 0) {
			System.out.println("등록된 아이템이 없습니다.");
		} else {
			for (ItemDTO dto : item) {
				System.out.println(dto);
			}
		}
	
	}

	/**
	 * 입력받은 번호에 해당하는 아이템 조회
	 */
	public void showItem() {
		
		System.out.print("조회하려는 아이템 번호: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		ItemDTO dto = dao.getItemById(id);
		if(dto == null) {
			System.out.println("일치하는 아이템이 없습니다.");
		} else {
			System.out.println(dto);
		}
		
	}

	/**
	 * 입력받은 번호에 해당하는 아이템 삭제
	 */
	public void deleteItem() {
		
		System.out.println("삭제하려는 아이템 번호: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		// DAO에서 객체 삭제 및 결과 반환
		if(dao.deleteById(id)) {
			System.out.println("[" + id + "]번 아이템 삭제 완료");
		} else {
			System.out.println("일치하는 아이템이 없습니다.");
		}
		
	}

	/**
	 * 입력받은 번호에 해당하는 아이템 수정
	 */
	public void updateItem() {
		
		System.out.println("수정하려는 아이템 번호: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		ItemDTO dto = dao.getItemById(id);
		
		if(dto == null) {
			System.out.println("일치하는 아이템이 없습니다.");
		} else {
			System.out.printf("아이템명 변경 %s -> ", dto.getName());
			String reName = sc.nextLine();
			
			System.out.printf("가격 변경 %d -> ", dto.getPrice());
			int rePrice = sc.nextInt();
			sc.nextLine();
			
			System.out.printf("수량 변경 %d -> ", dto.getQty());
			int reQty = sc.nextInt();
			sc.nextLine();
			
			// DAO에서 객체 수정
			dao.updateById(id, reName, rePrice, reQty);
			System.out.println("[" + id + "]번 아이템 수정 완료");
		}
		
	}

	/**
	 * 통계 정보 출력
	 */
	public void getStat() {
		
		List<ItemDTO> itemList = getAllItems();
		
		if(itemList.size() == 0) {
			System.out.println("등록된 아이템이 없습니다.");
		} else {
			int totalCnt = itemList.size();
			int totalSum = getTotalSum(itemList);

			System.out.println("전체 상품의 갯수: " + totalCnt + "개");
			System.out.println("전체 상품의 합계: " + String.format("%,d원", totalSum));
		}
	}

	/**
	 * 전체 상품 총 합계 반환
	 * @param itemList
	 */
	private int getTotalSum(List<ItemDTO> itemList) {
		
		int result = 0;
		
		for (ItemDTO dto : itemList) {
			result += dto.getTotal();
		}
		
		return result;
	}

}
