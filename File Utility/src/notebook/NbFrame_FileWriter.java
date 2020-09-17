package notebook;
/*fail*/
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;


public class NbFrame_FileWriter extends JFrame{
	
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem storeNewFile;
	private JMenuItem openOldFile;
	private FileWriter output;
	private Scanner input;
	
	
	public NbFrame_FileWriter() {
		setTitle("Notebook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,640);
		
		textArea = new JTextArea();
		add(new JScrollPane(textArea));
		
		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED)); //set the Border
		menu = new JMenu("檔案");
		openOldFile = new JMenuItem("開啟舊檔");
		storeNewFile = new JMenuItem("另存新檔");
		
		menu.add(openOldFile);
		menu.add(storeNewFile);
		menuBar.add(menu);
		
		openOldFile.addActionListener(new OpenListener());
		storeNewFile.addActionListener(new StoreListener());
		
		
		add(menuBar,BorderLayout.NORTH);
		setVisible(true);
	}

	private void closeInFile() {
		if(input != null) {
			input.close();
		}
	}
	
	private class StoreListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int selectResult = chooser.showSaveDialog(null);

			if(selectResult != JFileChooser.CANCEL_OPTION) {
				String path = chooser.getSelectedFile().getPath();
				//File newFile = new File(path); //if the file isn't existing, we should create one otherwise it will have the FileNotFoundException
				try {
					output = new FileWriter(path,false);
					String[] s = textArea.getText().split("\n");
					for(int i=0; i<s.length; i++) {
						output.write(s[i] + "\n");
					}
					output.close();
				} catch (IOException e) {
					// TODO 自動產生的 catch 區塊
					e.printStackTrace();
				}
			}
			else {
				System.exit(1);
			}
		}	
	}
	
	private class OpenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int selectResult = chooser.showOpenDialog(null);
			
			if(selectResult == JFileChooser.APPROVE_OPTION) {
				try {
					input = new Scanner(chooser.getSelectedFile());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				String text = "";
				while(input.hasNext()) {
					text += input.nextLine() + "\n";
				}
				textArea.setText(text);
			}
			else {
				System.exit(1);
			}
			
		}
		
	}
}
