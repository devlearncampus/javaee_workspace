package springapp.cook;

public class Cook {
	//Fripan pan; //너무 정확한 자료형으로 has a 관계를 사용 시 , 객체간 결합도가 너무 높음
	Pan pan;// 따라서 결합도를 낮추기 위해서 부품이 되는 객체는 느슨하게 보유해야 함
	
	public Cook(Pan pan) {
		this.pan = pan;
	}
	
	//음식을 만드는 행위
	public void makeFood() {
		pan.boil();
	}
	 
}
