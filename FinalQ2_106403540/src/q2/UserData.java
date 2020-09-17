package q2;

public class UserData {
	private String userID;
	private int level;
	
	public UserData() {
		System.out.println("a player");
	}
	
	public void setID(String id) {
		userID = id;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getID() {
		return userID;
	}
	
	public int getLevel() {
		return level;
	}
	
}
