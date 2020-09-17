/*資管2B_106403540_陳志剛*/
package HW1_106403540_陳志剛;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


/*小畫家上排工具列*/
public class Tool_Panel extends JPanel{

	private JPanel left_panel;
	private JPanel right_panel;
	
	private JLabel left_top_point;
	private JTextArea point_x;
	private JTextArea point_y;
	private JLabel pic_len_wid;
	private JTextArea pic_len;
	private JTextArea pic_wid;
	private JButton drawBtn;
	
	private JButton catch_point;
	private JLabel roundRect_len_wid;
	private JTextArea roundRect_len;
	private JTextArea roundRect_wid;
	private JButton deleteBtn;
	
	public static String state = "";
	public static int px ;
	public static int py ;
	public static int length ;
	public static int width ;
	public static int r_len ;
	public static int r_wid ;
	
	public Tool_Panel()
	{	
		
		/*加入至工具列的原件*/
		left_panel = new JPanel();
		right_panel = new JPanel();
		left_panel.setLayout(new GridBagLayout());
		right_panel.setLayout(new GridBagLayout());
		
		left_top_point = new JLabel("左上座標:");
		point_x = new JTextArea(1,5);
		point_x.setBorder(BorderFactory.createLoweredBevelBorder());
		point_y = new JTextArea(1,5);
		point_y.setBorder(BorderFactory.createLoweredBevelBorder());
		
		pic_len_wid = new JLabel("圖形長寬:");
		pic_len = new JTextArea(1,7);
		pic_len.setBorder(BorderFactory.createLoweredBevelBorder());
		pic_wid = new JTextArea(1,7);
		pic_wid.setBorder(BorderFactory.createLoweredBevelBorder());

		drawBtn = new JButton("draw");
		drawBtn.addActionListener(new DrawListener());
		
		GridBagConstraints bag1 = new GridBagConstraints();
		bag1.gridx = 0;
		bag1.gridy = 0;
		bag1.fill = GridBagConstraints.BOTH;
		
		left_panel.add(left_top_point,bag1);
		
		bag1.gridx = 1;
		left_panel.add(point_x,bag1);
		
		bag1.gridx = 2;
		left_panel.add(point_y,bag1);
		
		bag1.gridy = 1;
		bag1.gridx = 0;
		left_panel.add(pic_len_wid,bag1);
		
		bag1.gridx = 1;
		left_panel.add(pic_len,bag1);
		
		bag1.gridx = 2;
		left_panel.add(pic_wid,bag1);
		
		bag1.gridy = 2;		
		bag1.gridx = 1;
		bag1.gridwidth = 0;
		left_panel.add(drawBtn,bag1);
		
		catch_point = new JButton("取點");
		catch_point.addActionListener(new CatchPointListener());
		roundRect_len_wid = new JLabel("圓角長寬:");
		roundRect_len = new JTextArea(1,7);
		roundRect_len.setBorder(BorderFactory.createLoweredBevelBorder());
		roundRect_wid = new JTextArea(1,7);
		roundRect_wid.setBorder(BorderFactory.createLoweredBevelBorder());
		deleteBtn = new JButton("刪除最新圖形");
		deleteBtn.addActionListener(new LastStepListener());
		
		GridBagConstraints bag2 = new GridBagConstraints();
		bag2.gridy = 0;
		bag2.gridx = 1;
		bag2.gridwidth = 2;
		bag2.fill = GridBagConstraints.BOTH;
		
		right_panel.add(catch_point,bag2);
		
		bag2.gridy = 1;
		bag2.gridx = 0;
		bag2.gridwidth = 1;
		right_panel.add(roundRect_len_wid,bag2);
		
		bag2.gridx = 1;
		right_panel.add(roundRect_len,bag2);
		
		bag2.gridx = 2;
		right_panel.add(roundRect_wid,bag2);
		
		bag2.gridy = 2;
		bag2.gridx = 1;
		bag2.gridwidth = 2;
		right_panel.add(deleteBtn,bag2);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.weightx = 1; //要加這個她才可以這塊區域可以延伸
		gbc.weighty = 1;
		//gbc.fill = GridBagConstraints.BOTH; 
		//不知道為啥加了就不能用，大概是因為加了之後元件自動往左右延伸，所以其實有向右對齊，只是因為panel延伸，但裡面的component(要自己在panel裡面設定)沒延伸，所以看不出來。
		gbc.anchor = GridBagConstraints.EAST;
		add(left_panel,gbc);
		gbc.gridy = 0;
		gbc.gridx = 1;
		add(right_panel,gbc);
		
	}
	private class LastStepListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			state = e.getActionCommand();
			//last-step implements
			Painter_Frame.paint_pane.repaint();
			
		}
	}
	
	private class CatchPointListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "開始取點", "訊息", JOptionPane.INFORMATION_MESSAGE);
			state = e.getActionCommand();
		}
	}
	
	
	private class DrawListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			state = e.getActionCommand();
			try {
				px = Integer.valueOf(point_x.getText());
				py = Integer.valueOf(point_y.getText());
				length = Integer.valueOf(pic_len.getText());
				width = Integer.valueOf(pic_wid.getText());
				r_len = Integer.valueOf(roundRect_len.getText());
				r_wid = Integer.valueOf(roundRect_wid.getText());
				if(px + length > PaintPanel.paint_wid || py + width > PaintPanel.paint_height) {
					JOptionPane.showMessageDialog(null, "超出畫布範圍", "訊息", JOptionPane.INFORMATION_MESSAGE);
				}
				Painter_Frame.paint_pane.repaint();
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "請確認所有欄位都有填入數字", "訊息", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
	}
}
