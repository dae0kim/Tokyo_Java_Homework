package day5;

/**
 * 과제 3)<br>
 * 동작 클래스
 */
public class VehicleMain {

	public static void main(String[] args) {
		
		// 각 객체 생성
		Car car = new Car();
		Bicycle bicycle = new Bicycle();
		
		// 조건 4. move 전에 속도 설정
		car.setSpeed(400);
		bicycle.setSpeed(30);
		
		// 조건 5. move 후에 속도를 get 메서드로 출력
		car.move();
		System.out.println("속도: " + car.getSpeed() + "km");
		bicycle.move();
		System.out.println("속도: " + bicycle.getSpeed() + "km");
	}

}
