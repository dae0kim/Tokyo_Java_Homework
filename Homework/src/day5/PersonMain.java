package day5;

/**
 * 과제 4)<br>
 * 동작 클래스
 */
public class PersonMain {
	
	public static void main(String[] args) {
		
		// 조건 3. 5명의 Person 객체 배열 생성
		Person[] person = new Person[5];
		
		// set 메서드로 값 저장
		for(int i = 0; i < person.length; i++){
			// 객체 배열의 각 요소에 객체 생성
			person[i] = new Person();
			person[i].setName("비공개" + i);
			person[i].setAge(999);
		}
		
		// get 메서드로 출력
		for(int i = 0; i < person.length; i++){
			System.out.println("이름: " + person[i].getName() + ", 나이: " + person[i].getAge());
		}
	
	}

}
