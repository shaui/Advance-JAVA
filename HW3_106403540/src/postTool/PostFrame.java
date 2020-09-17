package postTool;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class PostFrame extends JFrame{
	private ObjectInputStream input;
	private PostSerializable post ;
	private Scanner s;

	private JLabel editTime;
	private Date time;
	private JTextArea content;
	private String text;
	
	private JPanel viewActivity;
	private JButton isLike;
	private Icon img;
	private boolean btnStatus;
	private JPanel tool;
	//private JButton edit;
	private JButton newPost;
	
	private JPanel editActivity;
	private JButton store;
	private JButton storeAs;
	private JButton readIn;
	private JButton cancel;
	
	private JComboBox<String> postContent;
	private String inputName;
	private String fileName = "";
	private String[] postName;
	private JPanel northPanel;
	
	public PostFrame() {
		try {
			input = new ObjectInputStream( Files.newInputStream( Paths.get("HW1 Paint GUI")) ); // 預設貼文
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			post = (PostSerializable) input.readObject();
		} catch (ClassNotFoundException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		
		//text
		try {
			s = new Scanner(Paths.get("posts.txt")); //notice that the Scanner will use the parameter --> (Path or File)
			String loadName = "";
			while(s.hasNext()) {
				loadName += s.nextLine() + "\n";
			}
			postName = loadName.split("\n");
			s.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/*for(int i=0; i<postName.length; i++) {
			System.out.println(postName[i]);
		}*/

		postContent = new JComboBox<String>(postName);
		postContent.setMaximumRowCount(postName.length);
		postContent.addItemListener(new PostListener());
		time = post.getEditTime();
		text = post.getContent();
		editTime = new JLabel("<html>" + "<h1><I><u>"+ "<font color=\"red\">" + time  + "</font>" + "<u/></I></h1><br>" + "</html>");
		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(postContent, BorderLayout.NORTH);
		northPanel.add(editTime);
				
		content = new JTextArea(text);
		content.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		content.setBackground(Color.LIGHT_GRAY);
		content.setEditable(false);
		
		//the bottom's viewActivity
		viewActivity = new JPanel();
		viewActivity.setLayout(new BorderLayout());
		viewActivity.setBackground(Color.GREEN);
		btnStatus = post.getIsLike();
		
		//isLike button
		setIconImage(btnStatus);
		isLike = new JButton(img);
		isLike.setBackground(Color.YELLOW);
		isLike.addActionListener(new IsLiseListener());
		
		//tool
		tool = new JPanel();
		tool.setBackground(Color.GREEN);
		//edit = new JButton("編輯");
		//edit.setBackground(Color.YELLOW);
		newPost = new JButton("New Post");
		newPost.setBackground(Color.YELLOW);
		//edit.addActionListener(new EditListener());
		newPost.addActionListener(new NewPostListener());
		//tool.add(edit);
		tool.add(newPost);
		viewActivity.add(isLike, BorderLayout.WEST);
		viewActivity.add(tool, BorderLayout.EAST);
		
		//the bottom's editActivity
		editActivity = new JPanel();
		editActivity.setBackground(Color.GREEN);
		store =  new JButton("Save");
		store.setBackground(Color.YELLOW);
		storeAs = new JButton("Save as");
		storeAs.setBackground(Color.YELLOW);
		readIn = new JButton("Import");
		readIn.setBackground(Color.YELLOW);
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.YELLOW);
		store.addActionListener(new StoreListener());
		storeAs.addActionListener(new StoreAsListener()); 
		readIn.addActionListener(new ReadInListener());
		cancel.addActionListener(new CancelListener()); 
		editActivity.add(store);
		editActivity.add(storeAs);
		editActivity.add(readIn);
		editActivity.add(cancel);
		editActivity.setVisible(false);
		tool.add(editActivity);
		
		//check the identity
		String[] select = {"取消","否(N)","是(Y)"};
		int result = JOptionPane.showOptionDialog(null, "是否為發布者", "登入", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION, null, select, 0);
		if(result == 0) {
			System.exit(1);
		}
		else if(result == 1) {
			//is not the owner
			tool.setVisible(false);
		}
		else {
			isLike.setEnabled(false);
		}
		//add the component
		add(northPanel, BorderLayout.NORTH);
		add(new JScrollPane(content));
		add(viewActivity, BorderLayout.SOUTH);
		//add(editActivity, BorderLayout.SOUTH);
		
	}
	
	//According the button status to set the icon
	private void setIconImage(boolean status) {
		if(status) {
			img = new ImageIcon(getClass().getResource("like.png"));
			( (ImageIcon)img ).setImage( ( (ImageIcon)img ).getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT) );
		}
		else {
			img = new ImageIcon(getClass().getResource("unlike.png"));
			( (ImageIcon)img ).setImage( ( (ImageIcon)img ).getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT) );
		}
	}
	
	//Change the icon when click the button
	private class IsLiseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(btnStatus) {
				btnStatus = false;
			}
			else {
				btnStatus = true;
			}
			setIconImage(btnStatus);
			isLike.setIcon(img);
		}
		
	}
	
	//change to the editView
	private class EditListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			content.setEditable(true);
			content.setBackground(Color.white);
			editActivity.setVisible(true);
			isLike.setVisible(false);
			//edit.setVisible(false);
			newPost.setVisible(false);
		}
		
	}
	
	//create a new post
	private class NewPostListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			inputName = JOptionPane.showInputDialog("Please input the file name.");
			if(inputName != null) {
				content.setEditable(true);
				content.setBackground(Color.white);
				content.setText("");
				editActivity.setVisible(true);
				isLike.setVisible(false);
				//edit.setVisible(false);
				newPost.setVisible(false);
			}
			
			
		}
	}
	
	//store the content
	private class StoreListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			text = content.getText();
			time = new Date();
			content.setText(text);
			editTime.setText("<html>" + "<h1><I><u>"+ "<font color=\"red\">" + time  + "</font>" + "<u/></I></h1><br>" + "</html>");
			content.setEditable(false);
			content.setBackground(Color.LIGHT_GRAY);
			editActivity.setVisible(false);
			isLike.setVisible(true);
			//edit.setVisible(true);
			newPost.setVisible(true);
			try {
				s = new Scanner(Paths.get("posts.txt")); //notice that the Scanner will use the parameter --> (Path or File)
				while(s.hasNext()) {
					fileName += s.nextLine() + "\n";
				}
				s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(fileName);
			OuputFile_Direct output = new OuputFile_Direct(fileName + inputName);
			StoreObject storeObject = new StoreObject(inputName, text, btnStatus, time);
	
		}
		
	}
	
	//Store as the file
	private class StoreAsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String textBuffer = text; //Because we don's click the store Button so the text should be temporary stored
			text = content.getText();
			StoreAsFile storeAsObject = new StoreAsFile(text);
			text = textBuffer;
		}
		
	}
	
	//Read in the File
	private class ReadInListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ReadFile readFile = new ReadFile();
			if(readFile.getText() != "") {
				content.setText(readFile.getText());
			}
			
		}
		
	}
	
	//Cancel the edit
	private class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			content.setEditable(false);
			content.setBackground(Color.LIGHT_GRAY);
			content.setText(text);
			editActivity.setVisible(false);
			isLike.setVisible(true);
			//edit.setVisible(true);
			newPost.setVisible(true);
		}
		
	}
	
	private class PostListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				String newPost = (String) e.getItem();
				try {
					input = new ObjectInputStream( Files.newInputStream( Paths.get(newPost)) ); // 預設貼文
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				try {
					post = (PostSerializable) input.readObject();
				} catch (ClassNotFoundException e3) {
					// TODO 自動產生的 catch 區塊
					e3.printStackTrace();
				} catch (IOException e4) {
					// TODO 自動產生的 catch 區塊
					e4.printStackTrace();
				}
				Date time = post.getEditTime();
				String text = post.getContent();
				editTime.setText("<html>" + "<h1><I><u>"+ "<font color=\"red\">" + time  + "</font>" + "<u/></I></h1><br>" + "</html>");
				content.setText(text);
			}
			
		}
	}
}
