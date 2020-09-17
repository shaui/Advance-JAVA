package enum_test;

public class ReadEnum {

	public static void main(String[] args) {
		StudentData[] data = StudentData.values();
		
		for(StudentData stData : data) {
			System.out.println(stData.getName() + " " + stData.getId());
		}
	}

}
