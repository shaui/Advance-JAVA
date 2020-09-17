/*資管2B 106403540 陳志剛*/ //新增功能 : 當輸入相同檔名時，會覆蓋舊的資料額不是再次新增一則貼文。
/*使用JLable可讀取HTML格式的特性 ，用HTML美化編輯時間*/
/*另存新檔或匯入檔案時，若選擇取消並不會關閉畫面，而可以繼續編輯*/
package postTool;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		PostFrame pf = new PostFrame();
		pf.setTitle("Post Article");
		pf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pf.setSize(640,640);
		pf.setLocation((int)(ScreenSize.getX()*0.5)-320,(int)(ScreenSize.getY()*0.5)-320);
		pf.setVisible(true);
	}

}
