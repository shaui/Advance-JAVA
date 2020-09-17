package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
	private static final int row_num = 10;
	private static final int coluimn_num = 10;
	
	private static Scanner s;
	private static int[][] record = new int[row_num][coluimn_num];
	private static Stack<Integer> recordRow = new Stack<>(); //Store the row
	private static Stack<Integer> recordColumn = new Stack<>();//Store the column
	private static ArrayList<Integer> deleteRow = new ArrayList<>();
	private static ArrayList<Integer> deleteColumn = new ArrayList<>();
	
	static ArrayList<String[]> rows = new ArrayList<>();
	public static void main(String[] arge) {
		readFile();
		insertData();
		drawMaze();
		solveMaze();
		drawMaze();
	}
	
	public static void readFile() {
		JFileChooser chooser = new JFileChooser(new File(Paths.get("src\\maze").toString()));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = chooser.showOpenDialog(null);
		if(result != JFileChooser.CANCEL_OPTION) {
			try {
				s = new Scanner(chooser.getSelectedFile());		
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, chooser.getSelectedFile().getName() + " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		else {
			System.exit(1);
		}	
	}
	
	public static void insertData() {
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
	}
	
	public static void drawMaze() {
		for(int i=0; i<record.length; i++) { //draw the maze
			for(int j=0; j<record[i].length; j++) {
				if(i==0 && j==0) { //Start point
					System.out.printf("%1s","S");
				}
				else if(i==4 && j==0) { //End point
					System.out.printf("%1s","E");
				}
				else if(record[i][j] == 0) { //non-obstacle
					System.out.printf("%1s","　");
				}
				else if(record[i][j] == 1) { //obstacle
					System.out.printf("%1s", "▉");
				}
				else { //Walking path
					System.out.printf("%1s", "@");
				}
			}
			System.out.println();
		}
	}
	public static void solveMaze(){
		int i = 0;
		int j = 0;
		recordRow.push(0);
		recordColumn.push(0);
		while(i!=4 || j!=0) {	//Arrive the End point
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
			record[recordRow.pop()][recordColumn.pop()] = 2;
		}
		
	}

}
