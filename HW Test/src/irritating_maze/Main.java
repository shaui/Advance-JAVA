//資管2B 106403540 陳志剛 //加分部分 : 1.鼠標自動移至右下角開始 2.變愛心和變牆壁的部分可以一直隨機執行 3.多了一個picture在螢幕上隨著時間移動，每次重新開始時，移動的方向和速度都是隨機的，撞到牆壁會反彈。4.碰到移動中的圖片時會依照圖片顯示的內容有1.不會扣寫的效果 2.一份驚喜~
 
package irritating_maze;

import javax.swing.JOptionPane;

public class Main {
	private static MazeFrame mf ;
	public static void main(String[] args) {
		
		mf = new MazeFrame();
	}
	
	public static void reStart() {
		IrritatingMaze.pool.shutdownNow();
		IrritatingMaze.heartPool.shutdownNow();
		BloodStripe.hp = 100;
		BloodStripe.setHp();
		mf.dispose();
		mf = new MazeFrame();
	}

}
