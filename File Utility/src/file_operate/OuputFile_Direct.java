package file_operate;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class OuputFile_Direct {
	private Formatter f;
	
	public OuputFile_Direct() {
		outputFile();
	
	}
	private void outputFile() {
		try {
			f = new Formatter("Output_Direct.txt");
			f.format("Test");// output content
			f.close();
		} catch (FileNotFoundException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
	}
}
