package day6;

/**
 * 과제3)<br>
 * 회원 정보 담는 클래스
 */
public class GymDTO {

	// 조건 1. 회원명, 회원번호, 기준칼로리, 소비칼로리
	private String name;
	private int num;
	private int stdKcal;
	private int csuKcal;
	
	// 생성자
	public GymDTO() {}

	public GymDTO(String name, int num, int stdKcal, int csuKcal) {
		this.name = name;
		this.num = num;
		this.stdKcal = stdKcal;
		this.csuKcal = csuKcal;
	}

	// get/set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStdKcal() {
		return stdKcal;
	}

	public void setStdKcal(int stdKcal) {
		this.stdKcal = stdKcal;
	}

	public int getCsuKcal() {
		return csuKcal;
	}

	public void setCsuKcal(int csuKcal) {
		this.csuKcal = csuKcal;
	}

	@Override
	public String toString() {
		return "회원명: " + name + ", 회원번호: " + num + ", 기준칼로리: " + stdKcal + ", 소비칼로리: " + csuKcal;
	}
	
}
