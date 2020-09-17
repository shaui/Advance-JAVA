package address_book;

public class Members {
	
	private String memberID;
	private String name;
	private String type;
	private String phone;
	
	public Members(String memberID, String name, String type, String phone) {
		setMemberID(memberID);
		setName(name);
		setType(type);
		setPhone(phone);
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
	
	public String getPhone() {
		return phone;	
	}
	
	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
