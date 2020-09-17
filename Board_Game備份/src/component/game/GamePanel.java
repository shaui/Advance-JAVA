package component.game;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import component.base.MyPanel;

public class GamePanel extends MyPanel{
	
	private static final long serialVersionUID = 1L;
	private Image c1, c2;
	private static CardShop cc = new CardShop();
	private static CardInfo ci = new CardInfo();
	private static CheckPanel cp = new CheckPanel(cc);
	private static Dice dice_a = new Dice(), dice_b = new Dice();
	private static boolean infoState = true, chooseCard = false, buyTime = false, landmark = false, doubleDice = false;
	private static int landmark_y;
	
	public GamePanel() {
		loadImage();
		setLayout(null);
		add(cp);
		add(ci);
		add(cc);
		add(new LandMark_Panel());
		add(new CardType_Panel(this));
		add(new Character(0, "休比", c1));
		add(new Character(1, "里克", c2));
		add(dice_a);
		add(dice_b);
		add(new MyPanel());
	}
	
	public static void cast() {
		if(!dice_a.getCastState()) {
			dice_a.cast();
			if(doubleDice) {
				dice_b.cast();
			}
		}
	}
	
	public static void setDice() {
		if(doubleDice) {
			doubleDice = false;
		}
		else {
			doubleDice = true;
		}
	}
	
	public static CardInfo getCardInfo() {
		return ci;
	}
	
	public static CardShop getCardContainer() {
		return cc;
	}
	
	public static CheckPanel getCheckPanel() {
		return cp;
	}
	
	public static void setLandmark_y(int y) {
		landmark_y = y;
	}
	
	public static int getLandmark_y() {
		return landmark_y;
	}
	
	public static void setInfoState(boolean b) {
		infoState = b;
	}
	
	public static boolean getInfoState() {
		return infoState;
	}
	
	public static void setChooseCard(boolean b) {
		chooseCard = b;
	}
	
	public static boolean getChooseCard() {
		return chooseCard;
	}
	
	public static void setBuyTime(boolean b) {
		buyTime = b;
		if(b) {
			dice_a.setVisible(false);
			dice_b.setVisible(false);
		}
		else {
			dice_a.setCastState(false);
			dice_b.setCastState(false);
		}
	}
	
	public static boolean getBuyTime() {
		return buyTime;
	}
	
	public static void setLandmark(boolean b) {
		landmark = b;
	}
	
	public static boolean getLandmark() {
		return landmark;
	}
	
	private void loadImage() {
		try {
			c1 = ImageIO.read(getClass().getResource("/image/character/Character1.jpg"));
			c2 = ImageIO.read(getClass().getResource("/image/character/Character2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
