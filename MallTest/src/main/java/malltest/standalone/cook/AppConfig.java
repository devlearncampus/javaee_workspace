package malltest.standalone.cook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Cook cook() {
		Cook cook=new Cook();
		cook.setPan(firePan()); //setter injection		
		return cook;
	}
	
	@Bean
	public FirePan firePan() {
		return new FirePan();
	}
	
	@Bean
	public ElectPan eletPan() {
		return new ElectPan();
	}
	
}
