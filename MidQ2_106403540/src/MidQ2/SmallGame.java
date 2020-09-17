package MidQ2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class SmallGame {
	private HashSet<Integer> hs;
	private String post = "";
	private boolean status = true;
	public SmallGame() {
		displayWin();
	}
	
	private void displayWin() {
		String input;
		do {
			input = JOptionPane.showInputDialog("Please enter a positive integer");
			if(input != null) {
				for(int i=0; i<input.length(); i++) {
					if(!Character.isDigit(input.charAt(i))) {
						status = false;
					}
				}
			}
			if(input != null && status) {		
				
				double inputNum = Double.valueOf(input);			
				if(inputNum > 0 && inputNum%1 == 0) {
					hs = new HashSet<>((int)inputNum);
					for(int i=1; i<inputNum+1; i++) {
						if(i%3 == 0) {
							hs.add(i);
						}
						else{
							String s = String.valueOf(i);
							String[] splitValue = s.split("");
							for(int j=0; j<splitValue.length; j++) {
								int sv = Integer.valueOf(splitValue[j]);
								if(sv == 3) {
									hs.add(i);
								}
							}
						}
					}
					Iterator<Integer> it = hs.iterator();
					if(it.hasNext()) {
						while(it.hasNext()) {
							if(post == "") {
								post += it.next();
							}
							else {
								post += "," + it.next();
							}
						}
						JOptionPane.showMessageDialog(null, post);
						post = "";
					}
					else{
						JOptionPane.showMessageDialog(null, "Nothing QQ");
					}
				}
			}		
			status = true;
//			TreeSet ts = new TreeSet(hs);
//			Iterator<Integer> it = ts.iterator();
//			while(it.hasNext()) {
//				System.out.println(it.next());
//			}

		}while(input != null);
		
	}
}
