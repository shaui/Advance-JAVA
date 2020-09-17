/*���2B_106403540_���ӭ�*/
package call_order;


import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.naming.SizeLimitExceededException;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


/*����j�p*/
public class Brush_Size_Panel extends JPanel{
	
	private JRadioButton[] brush_size = new JRadioButton[3];
	private ButtonGroup single_select;
	private JLabel[] text = new JLabel[3];
	public static int sizeX = 7;
	public static int sizeY = 7;
	public Brush_Size_Panel()
	{
		setLayout(new GridLayout(2,3));
		
		
		text[0] = new JLabel("����j�p");
		/*���F�ƪ��Ϊ�2�Ӫťհ϶�*/
		text[1] = new JLabel();
		text[2] = new JLabel();
		
		/*3�ӿﶵ*/
		brush_size[0]= new JRadioButton("�p",false);
		brush_size[1]= new JRadioButton("��",true);
		brush_size[2]= new JRadioButton("�j",false);
		
		/*�s�@�����*/
		single_select = new ButtonGroup();
		single_select.add(brush_size[0]);
		single_select.add(brush_size[1]);
		single_select.add(brush_size[2]);
		
		/*�[�J��ť��*/
		brush_size[0].addItemListener(new RadioBoxItemLis(0));
		brush_size[1].addItemListener(new RadioBoxItemLis(1));
		brush_size[2].addItemListener(new RadioBoxItemLis(2));
		
		/*��iPanel�̭�*/
		for(int i=0; i<text.length; i++)
		{
			add(text[i]);
		}
		for(int i=0; i<brush_size.length; i++)
		{
			add(brush_size[i]);
		}
	}
	
	private class RadioBoxItemLis implements ItemListener
	{
		private int order;
		public RadioBoxItemLis(int order) {
			this.order = order;
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				switch(order) {
					case 0:
						sizeX = 4;
						sizeY = 4;
						break;
					case 1:
						sizeX = 7;
						sizeY = 7;
						break;
					case 2:
						sizeX = 10;
						sizeY = 10;
						break;
				}
				//System.out.println(sizeX + "  " + sizeY); �T�{�j�p���S������
				
			}	
		}	
	}

}
