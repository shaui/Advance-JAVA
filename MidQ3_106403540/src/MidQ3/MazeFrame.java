package MidQ3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MazeFrame extends JFrame{
	private Maze maze;
	private JButton run;
	
	public MazeFrame() {
		setTitle("¤pµe®a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,750);
		setLocation((int)(ScreenSize.getX()*0.5)-375,(int)(ScreenSize.getY()*0.5)-375);	
		setLayout(new BorderLayout());
		maze = new Maze();
		add(maze);
		run = new JButton("run");
		run.addActionListener(new RunListener());
		add(run, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private class RunListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			maze.backtracking();
		}
		
	}
}
