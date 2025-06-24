package admin;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class AdminMain extends JFrame{
	JTextField t_title;
	JFileChooser chooser;
	JButton bt_file;
	JButton bt_regist;
	JPanel p_preview;
	File[] files;
	
	public AdminMain() {
		t_title = new JTextField(20);
		chooser = new JFileChooser();
		bt_file = new JButton("파일선택");
		bt_regist = new JButton("등록");
		
		p_preview = new JPanel() {
			protected void paintComponent(Graphics g) {
				for(int i=0;i<files.length;i++) {
					//ImageIO.read("http://192.168.60.20:8282/data/");
					//g.drawImage(getIconImage(), MAXIMIZED_BOTH, DISPOSE_ON_CLOSE, WIDTH, HEIGHT, rootPane)
				}
			}
		};
		
		setLayout(new FlowLayout());
		chooser.setMultiSelectionEnabled(true);
		
		add(t_title);
		add(bt_file);
		add(bt_regist);
		
		bt_file.addActionListener((e)->{
			if(chooser.showOpenDialog(AdminMain.this) == JFileChooser.APPROVE_OPTION) {
				files=chooser.getSelectedFiles();
			};
		});
		
		bt_regist.addActionListener((e)->{
			upload();
		});
		
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void upload() {
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpPost post = new HttpPost("http://192.168.60.20:8282/upload/regist");
		
		/*------------------------------------------------
			데이터 구성하기
		------------------------------------------------*/
		StringBody titleBody = new StringBody(t_title.getText(), ContentType.create("text/plain", Consts.UTF_8));
		MultipartEntityBuilder builder=MultipartEntityBuilder.create();
		builder.addPart("title", titleBody);
		
		for(int i=0;i<files.length;i++) {
			FileBody fileBody = new FileBody(files[i]);					
			builder.addPart("photo"+i, fileBody);
		}
		HttpEntity entity=builder.build();
		post.setEntity(entity);
		
		
		CloseableHttpResponse response=null; //응답 객체 선언 
		try {
			response=httpClient.execute(post);
			int status = response.getStatusLine().getStatusCode();
			if(status ==200) {
				JOptionPane.showMessageDialog(this, "업로드 완료");				
			}else {
				JOptionPane.showMessageDialog(this, "업로드 실패");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new AdminMain();

	}

}
