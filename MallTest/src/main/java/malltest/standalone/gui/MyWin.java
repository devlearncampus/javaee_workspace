package malltest.standalone.gui;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyWin extends JFrame{
	
	JComponent name;
	JComponent email;
	JComponent bt;
	ApplicationContext context=new AnnotationConfigApplicationContext();
	
	public MyWin(JComponent name, JComponent email, JComponent bt) {
		this.name=name;
		this.email=email;
		this.bt=bt;
		
		setLayout(new FlowLayout());
		
		add(name);
		add(email);
		add(bt);
		
		setSize(200,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(MyWin.class);		
	}
}
