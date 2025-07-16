package malltest.standalone.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public JTextField name() {
		return new JTextField(15);
	}
	
	@Bean
	public JTextField email() {
		return new JTextField(15);
	}
	
	@Bean
	public JButton bt() {
		return new JButton("버튼");
	}
	
	@Bean
	public MyWin myWin() {
		return new MyWin(name(), email(), bt());
	}
	
}
