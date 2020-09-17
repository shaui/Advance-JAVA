package connection_service;

import java.util.regex.Pattern;

public class Main {
	
	static Thread aiThread;
	
	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
//		new Service_Options().start();
		aiThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                	aiThread.sleep(5000);
                    
                } catch (InterruptedException e) {
                	if(!aiThread.isInterrupted()){
                        System.out.println("Interrupt");
                     } else {
                     	System.out.println("alive");
                     }
                }
            }
        });
		aiThread.start();
		System.out.println("outside");
		aiThread.interrupt();
	}

}
