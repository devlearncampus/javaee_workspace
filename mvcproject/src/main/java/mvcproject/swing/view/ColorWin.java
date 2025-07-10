package mvcproject.swing.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//mvc
public class ColorWin extends JFrame{
	JComboBox box;
	JButton bt;
	
	public ColorWin() {
		box = new JComboBox<>();
		bt = new JButton("판단요청");
		
		//style 
		box.setPreferredSize(new Dimension(175, 30));
		
		//데이터 채우기 
		box.addItem("red");
		box.addItem("blue");
		box.addItem("yellow");
		box.addItem("green");
		
		setLayout(new FlowLayout());
		add(box);
		add(bt);
		
		bt.addActionListener((e)->{
			getAdvice();
		});
		
		setSize(200,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void getAdvice() {
		//혈액형에 대한 판단 
		String color=(String)box.getSelectedItem();
		
		String msg="";
		if(color.equals("red")){
			msg="열정적이고 활동적";
		}else if(color.equals("blue")){
			msg="신중하고 분석적";
		}else if(color.equals("yellow")){
			msg="낙천적이고 외향적";
		}else if(color.equals("green")){
			msg="온화하고 배려심 깊음";
		}
		
		JOptionPane.showMessageDialog(this, msg);
	}
	
	public static void main(String[] args) {
		new ColorWin();
	}
}



