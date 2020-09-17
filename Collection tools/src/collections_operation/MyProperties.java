package collections_operation;
//可以寫檔的Map，順序不知道，只是不重要，因為Map的概念是從key找value，不需要知道順序。

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Properties;
import java.util.Set;

public class MyProperties {

	public static void main(String[] arge) {
		
		Properties p = new Properties();
		p.setProperty("ad2", "Zour");
		p.setProperty("bd3", "Zoue");
		p.setProperty("id4", "Shaui");
		p.setProperty("id1", "OGsin");
		p.setProperty("id3", "Zour");
		System.out.println(p);
		Set<Object> key = p.keySet();
		for(Object index : key) {
			System.out.println(index);
		}
		
		
		FileOutputStream output;
		try {
			output = new FileOutputStream("properties2.txt"); //use the path'String as the parameter, No need to change it to Paths.getPath().
			p.store(output, "Properties test");
			output.close();
		} catch (IOException e)  {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		
		FileInputStream input1;
		try {
			input1 = new FileInputStream("properties.txt");
			p.load(input1); //The load method will "add" the File's content to the original Properties. "Not replace".
			input1.close();
			System.out.println("p : " + p);
		} catch (IOException e)  {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		
		FileInputStream input2;
		try {
			input2 = new FileInputStream("properties.txt");
			Properties p2 = new Properties();
			p2.load(input2);
			input2.close();
			System.out.println("p2 : " + p2);
		} catch (IOException e)  {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
