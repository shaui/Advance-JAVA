package MidQ3;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Maze extends JPanel{

	private static final int row_num = 10;
	private static final int coluimn_num = 10;
	
	private static Scanner s;
	private static int[][] record = new int[row_num][coluimn_num];
	private JPanel[] block = new JPanel[100];
	
	private static Stack<Integer> recordRow = new Stack<>(); //Store the row
	private static Stack<Integer> recordColumn = new Stack<>();//Store the column
	private static ArrayList<Integer> deleteRow = new ArrayList<>();
	private static ArrayList<Integer> deleteColumn = new ArrayList<>();
	
	private Stack<JPanel> redBlock = new Stack<>();
	
	public Maze() {
		readMap();
		setLayout(new GridLayout(10,10));
		for(int i=0; i<block.length; i++) {
			add(block[i]);
		}
	}
	
	private void readMap() {	
		try {
			s = new Scanner(Paths.get("map.txt"));
			int count = 0;
			while(s.hasNext()) {
				String[] data = s.nextLine().split(" ");
				for(int i=0; i<record[count].length; i++) {
					for(int j=0; j<data.length; j++) {
						if(i == Integer.valueOf(data[j])-1) {
							record[count][i] = 1;
							break;
						}
						else {
							record[count][i] = 0;
						}
					}
				}
				count++;
			}
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		setMap();
	}
	
	private void setMap() {
		int index = 0;
		for(int i=0; i<record.length; i++) { //draw the maze
			for(int j=0; j<record[i].length; j++) {
				if(i==0 && j==0) { //Start point
					block[index] = new JPanel();
					block[index].setBackground(Color.BLUE);
					index++;
				}
				else if(i==6 && j==0) { //End point
					block[index] = new JPanel();
					block[index].setBackground(Color.BLUE);
					index++;
				}
				else if(record[i][j] == 0) { //non-obstacle
					block[index] = new JPanel();
					block[index].setBackground(Color.WHITE);
					index++;
				}
				else if(record[i][j] == 1) { //obstacle
					block[index] = new JPanel();
					block[index].setBackground(Color.BLACK);
					index++;
				}
				else { //Walking path
					block[index] = new JPanel();
					block[index].setBackground(Color.RED);
					index++;
				}
			}
		}
	}
	
	private void updateMap() {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		
		executor.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				if(!redBlock.isEmpty()) {
					JPanel temp = redBlock.pop();
					temp.setBackground(Color.RED);
				}
				else {
					executor.shutdown();
					JOptionPane.showMessageDialog(null, "You arrive the end. Congratulation!");	
					
				}
			}
		}, 0, 500, TimeUnit.MILLISECONDS);
		
	}
	
	public void backtracking() {
		int i = 1;
		int j = 0;
		recordRow.push(1);
		recordColumn.push(0);
		while(i!=6 || j!=1) {	//Arrive the End point
			boolean status = true;
			for(int k=0; k<recordRow.size(); k++) { //是否走過了
				if(i+1 == recordRow.get(k) && j == recordColumn.get(k)) {
					status = false;
				}
			}
			for(int x=0; x<deleteRow.size(); x++) { //是否被刪掉過了
				if(i+1 == deleteRow.get(x) && j == deleteColumn.get(x)) {
					status = false;
				}
			}
			if(i+1<10 && record[i+1][j] == 0 && status ) {	
				i++;
				recordRow.push(i);
				recordColumn.push(j);
				System.out.println(0);
				continue;
			}
			
			status = true;
			for(int k=0; k<recordRow.size(); k++) {
				if(i == recordRow.get(k) && j+1 == recordColumn.get(k)) {
					status = false;
				}
			}
			for(int x=0; x<deleteRow.size(); x++) { //是否被刪掉過了
				if(i == deleteRow.get(x) && j+1 == deleteColumn.get(x)) {
					status = false;
				}
			}
			if(j+1<10 && record[i][j+1] == 0 && status ) {
				j++;
				recordRow.push(i);
				recordColumn.push(j);
				System.out.println(1);
				continue;
			}
			
			status = true;
			for(int k=0; k<recordRow.size(); k++) {
				if(i == recordRow.get(k) && j-1 == recordColumn.get(k)) {
					status = false;
				}
			}
			for(int x=0; x<deleteRow.size(); x++) { //是否被刪掉過了
				if(i == deleteRow.get(x) && j-1 == deleteColumn.get(x)) {
					status = false;
				}
			}
			if(j-1>=0 && record[i][j-1] == 0 && status ) {
				j--;
				recordRow.push(i);
				recordColumn.push(j);
				System.out.println(2);
				continue;
			}
			
			status = true;
			for(int k=0; k<recordRow.size(); k++) {
				if(i-1 == recordRow.get(k) && j == recordColumn.get(k)) {
					status = false;
				}
			}
			for(int x=0; x<deleteRow.size(); x++) { //是否被刪掉過了
				if(i-1 == deleteRow.get(x) && j == deleteColumn.get(x)) {
					status = false;
				}
			}
			if(i-1>=0 && record[i-1][j] == 0 && status ) {
				i--;
				recordRow.push(i);
				recordColumn.push(j);
				System.out.println(3);
				continue;
			}
			else {
				if(!recordRow.isEmpty()) {
					deleteRow.add( recordRow.pop() );
				}
				if(!recordColumn.isEmpty()) {
					deleteColumn.add( recordColumn.pop() );
				}
				
				if(recordRow.isEmpty()) {
					i = 0;
				}
				else {
					i = recordRow.peek();
					System.out.print(i + " ");
				}
				if(recordColumn.isEmpty()) {
					j = 0;
				}
				else {
					j = recordColumn.peek();
					System.out.println(j);
				}
			}
		}
		int count = recordRow.size(); 
		//Because when enter the for loop the recordRow.size() will be changed by the pop() method, we should take it out in advance
		for(int k=0; k<count; k++) {
			int x = recordRow.pop();
			int y = recordColumn.pop();
			redBlock.add(block[x*10 + y]);
			record[x][y] = 2;
		}
		updateMap();
	}
	
}
