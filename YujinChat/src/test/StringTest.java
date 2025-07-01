package test;

import com.google.gson.Gson;

public class StringTest {

	public static void main(String[] args) {
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"msg\" :\"배고파\",");
		sb.append("\"location\":\"A\"");
		sb.append("}");
		
		
		PayLoad p = new PayLoad();
		Branch b = new Branch();
		b.setBranch_id(23);
		p.setRequestType("user");
		p.setBranch(b);
		
		//보내기 위해 스트링으로...
		Gson gson = new Gson();
		System.out.println(gson.toJson(p));
		
		
		//스트링으로 전달된 데디터를 다시 객체로 
		Gson g2 = new Gson();
		PayLoad p2=g2.fromJson(gson.toJson(p), PayLoad.class);
		System.out.println(p2.getRequestType());
		Branch branch=p2.getBranch();
		System.out.println(branch.getBranch_id());
		
		/*
		Message message = new Message();
		Location location = new Location();
		location.setLocation_id(23);
		location.setName("무지개 지점");
		location.setAddr("개포동");
		
		message.setRequestType("user");
		message.setContent(location);
		
		Gson gson=new Gson();
		String result=gson.toJson(message);
		*/
		
		//문자열을 다시 객체로 복원
		/*
		Gson gson2 = new Gson();
		Message obj=gson2.fromJson(result, Message.class);
		Map map=(Map)obj.getContent();
		double d=(Double)map.get("location_id");
		System.out.println((int)d);
		System.out.println("클라이언트가원하는 요청은 "+obj.getRequestType());
		*/
		//System.out.println(loc.getLocation_id());
		//System.out.println(loc.getName());
		//System.out.println(loc.getAddr());
		
		
		
	
/*		
		Message message= new Message();
		message.setRequestType("chat");
		message.setContent("나는 오늘 병원갔다");
		Gson gson=new Gson();
		String result=gson.toJson(message);		
		System.out.println(result);
		*/
		/*
		 * {
		 * 		"msg" :"배고파",
		 * 		"location":"A"
		 * }
		 * */
		
		
	}

}
