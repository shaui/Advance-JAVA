package q3;

public class Members {
	
	private String memberID;
	private String name;
	private String type;
	private String phone;
	private String cls;
	
	public Members(String memberID, String name, String type, String phone, String cls) {
		setMemberID(memberID);
		setName(name);
		setType(type);
		setPhone(phone);
		setCls(cls);
	}
	
	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
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
