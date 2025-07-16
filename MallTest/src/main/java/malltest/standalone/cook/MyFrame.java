package malltest.standalone.cook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyFrame {

	public static void main(String[] args) {
	
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		Cook cook=(Cook)context.getBean(Cook.class);
		cook.doCook();

	}

}
