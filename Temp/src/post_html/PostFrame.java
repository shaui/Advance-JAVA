package post_html;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PostFrame extends JFrame{
	private ObjectInputStream input;
	private PostSerializable post ;

	private JPanel view;
	private JLabel editTime;
	private Date time;
	private JLabel content;
	private String text;
	
	private JPanel viewActivity;
	private JButton isLike;
	private Icon img;
	private boolean btnStatus;
	private JPanel tool;
	private JButton edit;
	private JButton newPost;
	
	private JPanel editActivity;
	private JButton store;
	private JButton storeAs;
	private JButton readIn;
	private JButton cancel;
	
	private JTextArea editArea;
	
	public PostFrame() {
		try {
			input = new ObjectInputStream( Files.newInputStream( Paths.get("post1")) );
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
		view = new JPanel();
		view.setLayout(new BorderLayout());
		time = post.getEditTime();
		text = post.getContent();
		editTime = new JLabel("<html>" + "<h1>"+ time + "</h1><br>" + "</html>");
		content = new JLabel(text);
		view.add(editTime, BorderLayout.NORTH);
		view.add(content);
		
		
		//the bottom's viewActivity
		viewActivity = new JPanel();
		viewActivity.setLayout(new BorderLayout());
		viewActivity.setBackground(Color.GREEN);
		btnStatus = post.getIsLike();
		
		//isLike button
		setIconImage(btnStatus);
		isLike = new JButton(img);
		isLike.setBackground(Color.GREEN);
		isLike.addActionListener(new IsLiseListener());
		
		//tool
		tool = new JPanel();
		tool.setBackground(Color.GREEN);
		edit = new JButton("編輯");
		edit.setBackground(Color.GREEN);
		newPost = new JButton("全新貼文");
		newPost.setBackground(Color.GREEN);
		edit.addActionListener(new EditListener());
		newPost.addActionListener(new NewPostListener());
		tool.add(edit);
		tool.add(newPost);
		viewActivity.add(isLike, BorderLayout.WEST);
		viewActivity.add(tool, BorderLayout.EAST);
		
		//the bottom's editActivity
		editActivity = new JPanel();
		editActivity.setBackground(Color.GREEN);
		store =  new JButton("儲存");
		store.setBackground(Color.GREEN);
		storeAs = new JButton("另存新檔");
		storeAs.setBackground(Color.GREEN);
		readIn = new JButton("匯入檔案");
		readIn.setBackground(Color.GREEN);
		cancel = new JButton("取消");
		cancel.setBackground(Color.GREEN);
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
		
		//editArea
		editArea = new JTextArea();
		editArea.setVisible(false);
		
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
		add(view,BorderLayout.NORTH);
		add(new JScrollPane(editArea));
		add(viewActivity, BorderLayout.SOUTH);

		
	}
	
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
	
	private class EditListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			content.setVisible(false);
			editArea.setText(text);
			editArea.setVisible(true);
			editActivity.setVisible(true);
			isLike.setVisible(false);
			edit.setVisible(false);
			newPost.setVisible(false);
		}
		
	}
	
	private class NewPostListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			content.setVisible(false);
			editArea.setVisible(true);
			editArea.setText("");
			editActivity.setVisible(true);
			isLike.setVisible(false);
			edit.setVisible(false);
			newPost.setVisible(false);
		}
	}
	
	private class StoreListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			text = editArea.getText();
			String[] s = text.split("\n");
			String changeText = "";
			for(int i=0; i<s.length; i++) {
				changeText += s[i] + "<br>";
			}
			time = new Date();
			editTime.setText("<html>" + "<h1>"+ time + "</h1><br>" + "</html>");
			content.setText("<html>" + changeText + "</html>");
			content.setVisible(true);
			editArea.setVisible(false);
			editActivity.setVisible(false);
			isLike.setVisible(true);
			edit.setVisible(true);
			newPost.setVisible(true);
			StoreObject storeObject = new StoreObject(text, btnStatus, time);
		}
		
	}
	private class StoreAsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String textBuffer = text; //Because we don's click the store Button so the text should be temporary stored
			text = editArea.getText();
			StoreAsFile storeAsObject = new StoreAsFile(text);
			text = textBuffer;
		}
		
	}
	private class ReadInListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ReadFile readFile = new ReadFile();
			editArea.setText(readFile.getText());
		}
		
	}
	private class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			content.setVisible(true);
			editArea.setVisible(false);
			editActivity.setVisible(false);
			isLike.setVisible(true);
			edit.setVisible(true);
			newPost.setVisible(true);
		}
		
	}
}
