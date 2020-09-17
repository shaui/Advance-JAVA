package component.module;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import component.module.MyListFrame.ListListener;

public class TestPanel extends JPanel{
	
	private JList<String> colorList;
	private JLabel jlb;
	private String[] colors = {"Red","Black","Gray","LightGray","Blue","Yellow","陳志剛","A","A","A","A","A","A","A"};
	private int maxCount = 13;
	private Color[] c = {Color.RED, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.blue, Color.YELLOW,Color.RED, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.blue, Color.YELLOW,Color.RED, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.blue, Color.YELLOW};
	public TestPanel()
	{
		jlb = new JLabel("name",SwingConstants.CENTER);
		jlb.setBorder(BorderFactory.createEtchedBorder());
		jlb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setLayout(new BorderLayout());
		add(jlb, BorderLayout.NORTH);
		colorList = new JList<String>(colors);
		if(colors.length > maxCount) {
			colorList.setVisibleRowCount(maxCount);
		}
		else {
			colorList.setVisibleRowCount(colors.length);
		}
		
		colorList.setFixedCellWidth(420);
		colorList.setFixedCellHeight(35);
		colorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		add(new JScrollPane(colorList));
		colorList.addListSelectionListener(new ListListener());
		
		setVisible(true);
		
		/*setListData(Object[] object) 用來把東西丟到JList裡面*/
		
	}

	public class ListListener implements ListSelectionListener /*每次都跑兩次*/
	{
		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			setBackground(c[colorList.getSelectedIndex()]);
			System.out.print(colorList.getSelectedIndex());
		}
		
	}
}
