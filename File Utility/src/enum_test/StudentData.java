package enum_test;

public enum StudentData {
	
	ST1("John",123456789),
	ST2("Merty",987654321),
	ST3("Zoue",100000000);
	
	private final String name;
	private final int id;
	
	StudentData(String s, int i){
		name = s;
		id = i;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
}
