package item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemDAO {
	
	List<ItemDTO> itemList = new ArrayList<>();
	
	/**
	 * 아이템 객체 List에 저장
	 * @param dto
	 */
	public void save(ItemDTO dto) {
		itemList.add(dto);
	}
	
	/**
	 * 전체 아이템 리스트 반환
	 */
	public List<ItemDTO> findAll() {
		return itemList;
	}
	

	/**
	 * 아이템 아이디에 해당하는 객체 반환
	 * @param id
	 */
	public ItemDTO getItemById(int id) {
		for (ItemDTO dto : itemList) {
			if(dto.getId() == id) return dto;
		}
		return null;
	}
	
	/**
	 * 아이템 번호에 해당하는 객체 삭제
	 * @param id
	 */
	public boolean deleteById(int id) {

		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getId() == id) {
				itemList.remove(i);
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 아이템 번호에 해당하는 객체 수정
	 * @param id
	 * @param reName
	 * @param rePrice
	 * @param reQty
	 */
	public void updateById(int id, String reName, int rePrice, int reQty) {
		Iterator<ItemDTO> it = itemList.iterator();
		while(it.hasNext()) {
			ItemDTO dto = it.next();
			if(dto.getId() == id) {
				dto.setName(reName);
				dto.setPrice(rePrice);
				dto.setQty(reQty);
				break;
			}
		}
	}
	
}
