package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

public class Server implements Runnable{
	
	ServerSocket server; //본점 및 지점은 이 소켓을 통해 접속한다.
	int port = 9999;
	Thread thread; //메인 실행부가 대기상태에 빠지지 않도록 (프로그램 멈추는 거 방지)
	
	Vector<ServerThread> locationList; //지점들 중 현재 접속한 지점들을 담게될 배열
	Vector<ServerThread> headList; //지점들의 채팅 쓰레드를 담게될 맵(key값은 지점 db의 pk값으로 지정)
	
	public Server() {
		locationList= new Vector<>();
		headList = new Vector<>(); 
				
		renServer();
	}
	
	public void renServer() {
		thread = new Thread(this); //runnable 구현자를 넣어준다.
		thread.start(); //쓰레드 가동 시작
	}
	
	 public void run() {
		 try {
			server = new ServerSocket(port);
			
			while(true){ //무한 루프로 다수의 접속자를 받는다.
				Socket socket = server.accept(); //접속전 까지 대기
				
				//생성된 소켓을 이용하여 쓰레드를 생성
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println(ip + " 님 접속"); //지점 수 만큼 접속
				
				ServerThread chatThread = new ServerThread(this, socket);
				chatThread.start();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}

}
