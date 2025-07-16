package malltest.school;

//애플리케션에 중복되는 공통 코드를, 별도의 객체로 분리시켜 공통 관심사로 놓자 
//즉, 하나의 외부의 관점(Aspect)으로 둔다 
public class Student {
	
	public void getUp() {
		//sound();
		System.out.println("기상합니다");
	}
	public void gotoSchool() {
		//sound();
		System.out.println("등교합니다");
	}
	public void study() {
		//sound();
		System.out.println("수업시작");
	}
	
	public void rest() {
		//sound();
		System.out.println("쉬는 시간 갖기");
	}
	
	public void haveLunch() {
		//sound();
		System.out.println("점심 먹기");
	}
	
	public void goHome() {
		//sound();
		System.out.println("집에 갑니다");
	}
	
	
}



