package component.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import component.base.MyPanel;

public class Dice extends MyPanel{

	private static final long serialVersionUID = 1L;
	private Image i = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/image/dice/Dice.gif")),
			point;
	private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
	@SuppressWarnings("rawtypes")
	private ScheduledFuture f;
	private boolean castEnd = false, casting = false;
	private Random r = new Random();
	private int a;

	public Dice() {
		setVisible(false);
		setLocation(1920/2-60, 1080/2-60);
		setSize(100, 100);
		setLayout(null);
	}

	public void cast() {
		if(casting) {
			f.cancel(true);
		}
		castEnd = false;
		a = r.nextInt(6)+1;
		setVisible(true);
		int x = r.nextInt(1821)+50;
		int y;
		if(x < 250 || x > 1670) {
			y = r.nextInt(981)+50;
		}
		else {
			y = 540+(r.nextInt(201)+290)*(r.nextInt(2)*2-1);
		}
		f = service.scheduleAtFixedRate(new CastDiceTask(this, x, y), 0, 5, TimeUnit.MILLISECONDS);
		casting = true;
	}

	public void setCastState(boolean b) {
		castEnd = b;
	}
	
	public boolean getCastState() {
		return castEnd;
	}

	@SuppressWarnings("rawtypes")
	public ScheduledFuture getFuture() {
		return f;
	}

	public void setAppear(boolean b) {
		setVisible(b);
	}
	
	public int getPoint() {
		return a;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		if(castEnd) {
			try {
				point = ImageIO.read(getClass().getResource("/image/dice/Dice" + a + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(point, 0, 0, getWidth(), getHeight(), null);
		}
		else {
			g.drawImage(i, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
