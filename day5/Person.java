package day5;

/**
 * 과제 4)<br>
 * 마을 주민 객체 클래스
 */
public class Person {
	
	// 조건 1. 이름, 나이는 private
	private String name;
	private int age;

	// 조건 2. set/get 메서드로만 정보 입력,확인 가능
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}
