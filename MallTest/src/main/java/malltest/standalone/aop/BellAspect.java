package malltest.standalone.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BellAspect {
	
	@Autowired
	private Bell bell;
	
	//어떤 로직을? 
	@Before("execution(* Student.*(..))")
	public void ringBell() {
		bell.sound();
	}
}
