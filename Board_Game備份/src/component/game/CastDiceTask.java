package component.game;

public class CastDiceTask implements Runnable{
	
	private int a = 0, xi, yi, xf = 910, yf = 590, s = 100;
	private double xc, yc, sc;
	private Dice d;

	public CastDiceTask(Dice dice, int x, int y) {
		d = dice;
		xi = x;
		yi = y;
		xc = (xf-xi)/200.0;
		yc = (yf-yi)/200.0;
	}

	@Override
	public void run() {
		if(a <= 200) {
		d.setLocation(xi+(int) (xc*a)-50, yi+(int) (yc*a)-50);
		sc = 3-0.0002*(a-100)*(a-100);
		d.setSize((int) (s*sc), (int) (s*sc));
		}
		if(a > 200 && a <= 300) {
			d.setLocation(xf+(int) (xc/2*(a-200))-50, yf+(int) (yc/2*(a-200))-50);
			sc = 1.25-0.0001*(a-250)*(a-250);
			d.setSize((int) (s*sc), (int) (s*sc));
		}
		if(a == 301) {
			d.setCastState(true);
		}
		if(a == 450) {
			d.getFuture().cancel(true);
			GamePanel.setBuyTime(true);
		}
		a++;
	}
}
