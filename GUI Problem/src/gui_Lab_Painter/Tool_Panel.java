/*���2B_106403540_���ӭ�*/
package gui_Lab_Painter;

import javax.swing.JPanel;

/*�p�e�a�W�Ƥu��C*/
public class Tool_Panel extends JPanel{

	public Tool_Panel()
	{	
		/*�[�J�ܤu��C�����*/
		add(new Paint_Tool_Panel());
		add(new Brush_Size_Panel());
		add(new Filler_Panel());
		add(new Btn_Panel());
	}
}
