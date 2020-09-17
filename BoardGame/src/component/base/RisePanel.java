package component.base;

import component.game.GamePanel;

public abstract class RisePanel extends MyPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	private int y = 0, a, b;
	private boolean down = false, entered = false;
	
	public RisePanel(int x, int y) {
		a = x;
		b = y;
	}
	
	protected void setDirectionIsDown(boolean b) {
		down = b;
	}
	
	
	public void setEntered(boolean b) {
		entered = b;
	}

	public boolean isEntered() {
		return entered;
	}
	
	@Override
	public void run() {
		if(!GamePanel.getBuyTime() && !GamePanel.getChooseCard()) {
			if(isEntered()) {
				if(y < 354) {
					y += 10;
				}
				if(y >= 354) {
					y = 354;
				}
			}
			else {
				if(y > 0) {
					y -= 20;
				}
				if(y < 0) {
					y = 0;
				}
			}
		}
		else {
			if(GamePanel.getBuyTime()) {
				y = 354;
			}
			if(GamePanel.getChooseCard()) {
				y = 0;
			}
		}
		if(down) {
			setLocation(a, b+10+y);
		}
		else {
			setLocation(a, b-10-y);
		}
		this.revalidate();
	}
}