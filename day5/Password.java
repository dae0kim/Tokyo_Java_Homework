package day5;

/**
 * 과제 1)<br>
 * 비밀번호 객체 클래스
 */
public class Password {
	
	// 조건 1. 비밀번호를 private 변수로 만들 것
	private String password;

	// 조건 2. 비밀번호 변경 및 확인 시 get/set 메서드 활용
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// 조건 3. 비밀번호 확인시 반드시 메서드 활용
	public void checkPwd() {
		System.out.println("내 비밀번호는 " + getPassword());
	}
	
}
