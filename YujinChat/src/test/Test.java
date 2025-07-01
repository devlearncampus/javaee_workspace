package test;

public class Test {


		
				
	
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"requestType\" : \"chat\",");
		sb.append("\"me\" : \"head\",	");
		sb.append("\"target\": \"지점모델객체\"");
		sb.append("\"msg\" : \"sdfsfsfd\",");
		sb.append("}");
	}
	
}


class Message{
	String requestType;
	String me;
	Location location;
	String msg;
}
