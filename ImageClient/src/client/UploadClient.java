package client;

import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class UploadClient extends JFrame{
	JTextField t_title;
	JFileChooser chooser;
	JButton bt_file;//파일선택 버튼
	JButton bt_regist;
	File[] files; // 유저가선택한 파일들... 
	
	public UploadClient() {
		t_title= new JTextField(15);
		bt_file = new JButton("파일 선택");
		bt_regist = new JButton("업로드");
		
		chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true); //여러 파일선택 옵션 추가
		
		//Flow 
		setLayout(new FlowLayout());
		add(t_title);
		add(bt_file);
		add(bt_regist);
		
		
		//파일선택
		bt_file.addActionListener((e)->{
			files=chooser.getSelectedFiles();
		});
		
		//파일업로드
		bt_regist.addActionListener((e)->{
			upload();
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200,170);
		setVisible(true);
	}
	
	//유저가 선택한 파일 수만큼 반복하면서 서버로  바이너리 파일까지 전송해야 함..
	public void upload() {
		//Http통신이 가능한 api를 이용해야 한다.. 2가지 객체가 있다. 
		//1) 고전적인 방식  HttpURLConnection 객체 이용 
		//2) 최신 방식 : HttpClient 객체 이용   javase 미포함, apache
		
	}
	
	public static void main(String[] args) {
		new UploadClient();
	}

}


