package component.module;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class SearchPanel extends JPanel{

	public SearchPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		add(new LeftPanel());
		add(new RightPanel());
	}
}
