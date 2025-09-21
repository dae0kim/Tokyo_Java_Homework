package day6;

/**
 * 과제2)<br>
 * 식자재 정보 담는 클래스
 */
public class FoodDTO {
	
	// 조건 1. 식자재번호, 식자재명, 수량, 등록날짜
	private int foodNum;
	private String name;
	private int count;
	private String rgstDate;
	
	// 생성자
	public FoodDTO() {}

	public FoodDTO(int foodNum, String name, int count, String rgstDate) {
		this.foodNum = foodNum;
		this.name = name;
		this.count = count;
		this.rgstDate = rgstDate;
	}

	// get/set
	public int getFoodNum() {
		return foodNum;
	}

	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getRgstDate() {
		return rgstDate;
	}

	public void setRgstDate(String rgstDate) {
		this.rgstDate = rgstDate;
	}

	@Override
	public String toString() {
		return "식자재 번호: " + foodNum + ", 식자재 이름: " + name + ", 수량: " + count + ", 등록날짜: " + rgstDate;
	}
	
}
