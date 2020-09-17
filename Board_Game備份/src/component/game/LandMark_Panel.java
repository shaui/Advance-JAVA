package component.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import component.base.RisePanel;
import component.card.Card_Panel;
import component.card.Landmark;
import event.LandMark_MouseListener;

public class LandMark_Panel extends RisePanel{

	private static final long serialVersionUID = 1L;
	private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

	public LandMark_Panel() {
		super(1920/2-735, 1081);
		setLayout(null);
		addMouseListener(new LandMark_MouseListener(this));
		setLocation(1920/2-735, 1080-10);
		setSize(1470, 364);
		add();
		service.scheduleAtFixedRate(this, 0, 15, TimeUnit.MILLISECONDS);
	}
	
	private void add() {
		for(int i = 0;i < Landmark.getCardList().length;i++) {
			Card_Panel c = new Card_Panel(Landmark.getCardList()[i], 1, 20+240*i, 20);
			c.buyStateIstrue();
			add(c);
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(new Color(0, 0, 0, 90));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	@Override
	public void run() {
		if(GamePanel.getLandmark()) {
			setEntered(true);
		}
		super.run();
		GamePanel.setLandmark_y(this.getLocation().y);
	}
}
