package q1;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		setGroup();
	}

	public static void setGroup() {
		FPDB dbms = new FPDB();
		ArrayList<MemberData> data = dbms.selectAllData();
		
		data.stream()
		.forEach(x -> dbms.updateData(x.getMemberID(), "classmate"));
	}
}
