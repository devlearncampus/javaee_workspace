package springapp.school;

//이 클래스는 학생의 모든 행동에 적용될 공통코드이며, 스프링을 이용하여 하나의 관점으로 
//정의하고, 학생의 메서드 중 원하는 메서드 호출 시, 관점이 보유한 메서드를 호출하게 만들자!!
public class Bell {
	public void sound() {
		System.out.println("딩동댕");		
	}	
}
