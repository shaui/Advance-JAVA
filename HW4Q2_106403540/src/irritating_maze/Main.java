//資管2B 106403540 陳志剛 //加分部分 : 1.視窗大小不論怎麼調整，圖片都會跟著縮放 2.血條會顯示準確的剩餘血量 3.撞到愛心會吃掉它並回復十點生命值 4.鼠標起始位置設定於右下角
 
package irritating_maze;

public class Main {
	private static MazeFrame mf ;
	public static void main(String[] args) {
		mf = new MazeFrame();
	}
	
	public static void reStart() {
		IrritatingMaze.pool.shutdownNow();
		IrritatingMaze.heartPool.shutdownNow();
		mf.dispose();
		mf = new MazeFrame();
	}

}
