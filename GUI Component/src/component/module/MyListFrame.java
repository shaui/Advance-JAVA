package component.module;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;

public class MyListFrame extends MyFrame{

	private JList<String> colorList;
	private String[] colors = {"Red","Black","Gray","LightGray","Blue","Yellow"};
	private Color[] c = {Color.RED, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.blue, Color.YELLOW};
	public MyListFrame()
	{
		colorList = new JList<String>(colors);
		colorList.setVisibleRowCount(4);
		colorList.setFixedCellWidth(600);
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
			getContentPane().setBackground(c[colorList.getSelectedIndex()]);
			System.out.print(colorList.getSelectedIndex());
		}
		
	}
}
