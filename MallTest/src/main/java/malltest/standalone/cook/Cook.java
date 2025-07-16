package malltest.standalone.cook;

public class Cook {
	private Pan pan;
	
	public void setPan(Pan pan) {
		this.pan = pan;
	}
	
	//요리하다 
	public void doCook() {
		pan.boil();
	}
}
