package chat;

public class Location {
    private int locationId;
    private String locationName;
    private String address;
    
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String toString() {
	    return locationName;  // 콤보박스에서 보일 텍스트
	}
}
