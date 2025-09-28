package delivery;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 외부 csv 파일 읽기, 데이터 처리 기능 구현
 */
public class DeliveryDAO {

	// 외부 파일
	private String fileName;
	List<DeliveryDTO> deliveryList;

	// 외부 파일을 받아 리스트 생성
	public DeliveryDAO(String fileName) {
		this.fileName = fileName;
		this.deliveryList = loadCsv(fileName);
	}

	/**
	 * csv 파일에서 목록을 읽어오는 메서드
	 * @param fileName
	 */
	private List<DeliveryDTO> loadCsv(String fileName) {
		
		List<DeliveryDTO> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			
			// 읽어온 파일의 한 줄을 저장
			String line;
			boolean skip = true;
			
			// 모든 라인을 다 읽으면 종료
			while((line = br.readLine()) != null) {
				// 첫 줄 스킵
				if(skip) {
					skip = false;
					continue;
				}
				
				String[] part = line.split(",");
				
				int id = Integer.parseInt(part[0].trim());
				String name = part[1].trim();
				int price = Integer.parseInt(part[2].trim());
				int orderCnt = Integer.parseInt(part[3].trim());
				int posOrderCnt = Integer.parseInt(part[4].trim());
				
				// 읽어온 데이터로 새로운 객체를 만들어 list에 추가
				list.add(new DeliveryDTO(id, name, price, orderCnt, posOrderCnt));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일 읽기 실패:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타 오류:" + e.getMessage());
		}
		
		return list;
	}
	
	/**
	 * 객체를 List에 저장
	 * @param dto
	 */
	public void save(DeliveryDTO dto) {
		deliveryList.add(dto);
		// csv 파일에 해당 정보 추가 
		writeCsv();
	}
	
	/**
	 * 입력받은 객체 정보를 csv 파일에 반영
	 */
	private void writeCsv() {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
			pw.println("id,name,price,posOrderCnt,orderCnt"); // csv파일 머릿말
			
			for (DeliveryDTO dto : deliveryList) {
				pw.printf("%d,%s,%d,%d,%d\n", dto.getId(), dto.getName(), dto.getPrice(), dto.getPosOrderCnt(), dto.getOrderCnt());
			}
			
		} catch (Exception e) {
			System.out.println("csv 저장 실패: " + e.getMessage());
		}
	}

	/**
	 * 전체 리스트 반환
	 */
	public List<DeliveryDTO> findAll() {
		return deliveryList;
	}

	/**
	 * id값에 해당하는 객체 반환
	 * @param id
	 */
	public DeliveryDTO getDeliveryById(int id) {
		for (DeliveryDTO dto : deliveryList) {
			if(dto.getId() == id) return dto;
		}
		return null;
	}
	
	/**
	 * id에 해당하는 객체 삭제
	 * @param id
	 */
	public boolean deleteById(int id) {

		for(int i = 0; i < deliveryList.size(); i++) {
			if(deliveryList.get(i).getId() == id) {
				deliveryList.remove(i);
				return true;
			}
		}
		
		return false;
	}

	/**
	 * id에 해당하는 객체 정보 수정
	 * @param id
	 * @param reName
	 * @param rePrice
	 * @param rePosOrderCnt
	 * @param reOrderCnt
	 */
	public void updateById(int id, String reName, int rePrice, int rePosOrderCnt, int reOrderCnt) {
		
		Iterator<DeliveryDTO> it = deliveryList.iterator();
		while(it.hasNext()) {
			DeliveryDTO dto = it.next();
			if(dto.getId() == id) {
				dto.setName(reName);
				dto.setPrice(rePrice);
				dto.setPosOrderCnt(rePosOrderCnt);
				dto.setOrderCnt(reOrderCnt);
				break;
			}
		}
		
	}
	
}
