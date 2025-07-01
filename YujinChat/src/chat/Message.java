package chat;

public class Message {
	private String requestType;
	private String me;
	private Location target;
	private String msg;
	
	
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getMe() {
		return me;
	}
	public void setMe(String me) {
		this.me = me;
	}
	public Location getTarget() {
		return target;
	}
	public void setTarget(Location target) {
		this.target = target;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}