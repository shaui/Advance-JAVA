package postTool;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class OuputFile_Direct {
	private Formatter f;
	private String fileName ;
	public OuputFile_Direct(String fileName) {
		this.fileName = fileName;
		outputFile();
	
	}
	private void outputFile() {
		try {
			f = new Formatter("posts.txt");
			f.format(fileName);// output content
			f.close();
		} catch (FileNotFoundException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
}
