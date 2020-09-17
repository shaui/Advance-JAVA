package executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	static int i = 0;
	static ScheduledExecutorService executor;
	static long startTime;
	public static void main(String[] args) {
		
		executor = Executors.newScheduledThreadPool(1);
		Date date = new Date();
		startTime = System.currentTimeMillis();
			executor.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					AA();
				}
			}, 0, 1000, TimeUnit.MILLISECONDS);

	}
	public static void AA() {
		System.out.println((System.currentTimeMillis()-startTime)/1000);
		if( (System.currentTimeMillis()-startTime)/1000 == 3) {
			executor.shutdown();
		}
	}
}
