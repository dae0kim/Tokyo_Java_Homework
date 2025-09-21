package day5;

/**
 * 과제 1)<br>
 * 동작 클래스
 */
public class PasswordMain {

	public static void main(String[] args) {
		
		// 비밀번호 객체 생성
		Password pwd = new Password();
		
		// 비밀번호 변경
		pwd.setPassword("qwer123");
		
		// 비밀번호 확인
		pwd.checkPwd();
		
	}
	
}
