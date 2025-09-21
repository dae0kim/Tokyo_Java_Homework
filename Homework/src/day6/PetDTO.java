package day6;

/**
 * 과제1)<br>
 * 동물병원 환자 정보를 담는 클래스
 */
public class PetDTO {
	
	// 조건1. 아이디, 보호자명, 반려동물명, 반려동물나이, 연락처
	private String id;
	private String masterName;
	private String petName;
	private int petAge;
	private String phoneNum;

	// 생성자
	public PetDTO() {}
	
	public PetDTO(String id, String masterName, String petName, int petAge, String phoneNum) {
		this.id = id;
		this.masterName = masterName;
		this.petName = petName;
		this.petAge = petAge;
		this.phoneNum = phoneNum;
	}

	// get/set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "아이디: " + id + ", 보호자 이름: " + masterName + ", 반려동물 이름: " + petName + ", 반려동물 나이: " + petAge
				+ ", 연락처: " + phoneNum;
	}
	
}
