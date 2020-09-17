package component.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import component.base.RisePanel;
import event.CardType_MouseListener;
import main.Main;
import main.Size;

public class CardType_Panel extends RisePanel{

	private static final long serialVersionUID = 1L;
	private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
	private GamePanel gp;
	private Font namef = new Font(Font.DIALOG, Font.BOLD , 30), supf = new Font(Font.DIALOG, Font.BOLD , 20);

	public CardType_Panel(GamePanel panel) {
		super(1920/2-495, -364);
		setDirectionIsDown(true);
		gp = panel;
		setLayout(null);
		addMouseListener(new CardType_MouseListener(this));
		setLocation(1920/2-495, -364+10);
		setSize(990, 364);
		service.scheduleAtFixedRate(this, 0, 15, TimeUnit.MILLISECONDS);
	}
	
	public GamePanel getGamePanel() {
		return gp;
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(new Color(0, 0, 0, 90));
		g.fillRect(0, 0, getWidth(), getHeight());
		drawCardType(g);
	}
	
	private void drawCardType(Graphics g) {
		g.setColor(new Color(0, 176, 240));
		g.fillRect(Size.getX_Scale(20), Size.getY_Scale(20), Size.getX_Scale(230), Size.getY_Scale(324));
		g.setColor(new Color(43, 230, 70));
		g.fillRect(Size.getX_Scale(260), Size.getY_Scale(20), Size.getX_Scale(230), Size.getY_Scale(324));
		g.setColor(new Color(255, 0, 64));
		g.fillRect(Size.getX_Scale(500), Size.getY_Scale(20), Size.getX_Scale(230), Size.getY_Scale(324));
		g.setColor(new Color(158, 47, 225));
		g.fillRect(Size.getX_Scale(740), Size.getY_Scale(20), Size.getX_Scale(230), Size.getY_Scale(324));
		g.setColor(Color.white);
		g.setFont(namef);
		Main.drawStringAtCenter(g, "基礎建設", 135, 162);
		Main.drawStringAtCenter(g, "加工廠", 375, 162);
		Main.drawStringAtCenter(g, "娛樂設施", 615, 162);
		Main.drawStringAtCenter(g, "重要建築", 855, 162);
		g.setFont(supf);
		Main.drawStringAtCenter(g, "(全益卡)", 135, 200);
		Main.drawStringAtCenter(g, "(自益卡)", 375, 200);
		Main.drawStringAtCenter(g, "(攻擊卡)", 615, 200);
		Main.drawStringAtCenter(g, "(只能擁有一棟)", 855, 200);
	}

}
