package shaui.server;

public class Boss {
	private Integer HP = 500;
	private String name = "BOSS";
	private boolean actionPhase = false;
	
	public Boss() {
		
	}

	public Integer getHP() {
		return HP;
	}

	public void setHP(Integer hP) {
		HP = hP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getActionPhase() {
		return actionPhase;
	}

	public void setActionPhase(boolean actionPhase) {
		this.actionPhase = actionPhase;
	}

	
	
	
}
