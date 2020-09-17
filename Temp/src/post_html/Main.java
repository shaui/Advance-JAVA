/*¸êºÞ2B 106403540 ³¯§Ó­è*/
package post_html;

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
