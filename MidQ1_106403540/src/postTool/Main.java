/*���2B 106403540 ���ӭ�*/ //�s�W�\�� : ���J�ۦP�ɦW�ɡA�|�л\�ª�����B���O�A���s�W�@�h�K��C
/*�ϥ�JLable�iŪ��HTML�榡���S�� �A��HTML���ƽs��ɶ�*/
/*�t�s�s�ɩζפJ�ɮ׮ɡA�Y��ܨ����ä��|�����e���A�ӥi�H�~��s��*/
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
