package day5;

/**
 * 과제 3)<br>
 * Bicycle 객체 클래스
 */
public class Bicycle implements Vehicle {

	// 조건 2. speed는 비밀
	private int speed;

	// 조건 3. set/get 메서드로만 speed 조작 가능
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	// 메서드 구현
	@Override
	public void move() {
		System.out.println("(영차영차) 끼익..끼...익");
	}

}
