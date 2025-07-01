package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Vector;

import com.google.gson.Gson;



//서버측에서 메시지를 처리하는 쓰레드(아직 본점용인지, 지점용인지는 모호)
public class ServerThread extends Thread{

	Server server;
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	
	Message message;
	boolean flag=true; //쓰레드 루프를 결정짓는 변수
	
	public ServerThread(Server server,Socket socket) {
		this.server = server;
		this.socket = socket;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void listen() {
		String msg = null;
		
		try {
			msg = buffr.readLine();
			
			//전송된 메세지를 분석하여 적절한 처리를 해야 함
			//System.out.println(msg);
			Gson gson = new Gson();
			Message obj = gson.fromJson(msg, Message.class);
			
			if(obj==null) {
				flag=false;
				//명단에서 제거
				exit();
			}
			
			if(obj.getRequestType().equals("init")) {
				/*--------------------------------------------------------------------------
				처음 접속과 동시에, 초기화 정보를 받으면 처리..
				--------------------------------------------------------------------------*/
				Location location = obj.getTarget();
				//기존 본사와, 지점 쓰레드가 사용할 해시맵을 비운다.
				this.message=obj;
				
				//본점용 맵에 쓰레드 담기
				if(obj.getMe().equals("head")) {
					server.headList.add(this);
					
				}else if(obj.getMe().equals("location")) {
					server.locationList.add(this); //location.getLocationId()를 받는 이유가 본점에서
					
				}
				/*
				for(ServerThread st : server.headList) {
					System.out.println("맵에 들어있는 지점의 pk "+st.message.getTarget().getLocationId());
				}
				System.out.println("현재까지 " + server.headList.size());
				*/
				for(ServerThread st : server.locationList) {
					System.out.println("맵에 들어있는 지점의 pk "+st.message.getTarget().getLocationId()+",현재까지 " + server.locationList.size());
				}
				
			}else if(obj.getRequestType().equals("chat")) {
				/*--------------------------------------------------------------------------
				메시지가 전송되dj 오면..처리..
				--------------------------------------------------------------------------*/
				int locationId = obj.getTarget().getLocationId();
				
				if(obj.getMe().equals("head")) { //본사에서 전송된 메시지라면, locationList 에 들어있는 지사쓰레의 send() 호출
					int discoveredIndex = getIndexOfThreadInList(server.locationList ,locationId);
					send(msg); //나에게 보내기
					if(discoveredIndex != -1)server.locationList.get(discoveredIndex).send(msg);; //너에게 보내기
				}else if(obj.getMe().equals("location")) { //지사에서 전송된 메시지라면, headList 에 들어있는 지사쓰레드의 send() 호출
					int discoveredIndex = getIndexOfThreadInList(server.headList , locationId);
					send(msg); //나에게 보내기
					if(discoveredIndex != -1)server.headList.get(discoveredIndex).send(msg);; //너에게 보내기						
				};
			}else if(obj.getRequestType().equals("exit")){
				
				if(obj.getMe().equals("head")) {
					send("본사 상담자가 채팅을 종료하였습니다.");
					flag = false;
					exit();
				}else if(obj.getMe().equals("location")) {
					send(obj.getTarget().getLocationName() + " 가 채팅을 종료하였습니다.");
					flag = false;
					exit();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			flag=false;
			exit();//명단에서 제거			
		}
	}
	
	//특정 List안에 들어있는 쓰레드가 보유한 Message안의 locationId를 가진자를 찾기
	public int getIndexOfThreadInList(Vector<ServerThread> vec, int locationId) {
		int index=-1;
		
		for(int i=0;i<vec.size();i++) {
			ServerThread st=vec.get(i);
			if(locationId==st.message.getTarget().getLocationId()) {
				index=i;
				break;
			} ;
		}
		return index;
	}
	
	/*------------------------------------------------------
	 * 서버측 쓰레드 제거 (채팅 참가자에서 빼기)
	------------------------------------------------------*/
	public void exit() {
		//message 에 들어있는 me값에 따라 본점, 지점 리스트에서 제거
		if(message.getMe().equals("head")) {
			server.headList.remove(this);
			System.out.println("본사가 채팅을 중단하였습니다");
		}else if(message.getMe().equals("location")) {
			server.locationList.remove(this);			
			System.out.println(message.getTarget().getLocationName()+"지점이 채팅을 중단하였습니다");
		}
	}
	
	public void send(String msg) {
		
		//지점의 쓰레드 중 현재 쓰레드가 보유한 key값과 일치하는 쓰레드에게만 보내자
		
		try {
			buffw.write(msg + "\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(flag) {
			listen();
		}
	}
	
	
}
