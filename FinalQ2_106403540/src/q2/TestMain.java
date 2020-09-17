package q2;

public abstract class TestMain {

	
	public static void main(String[] args) {
		UserDBMS dbms = new UserDBMS();
		UserData play = dbms.searchData("P1");
		dbms.updateData(play.getID(), 1);

	}

}
