package Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
	static int i = 0;
	public static void main(String[] args) {
		
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		pool.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				if(i!=5) {
					System.out.println(1);
					
				}
				else {
					Thread.currentThread().stop();
					
				}	
				
			}
			
		}, 0, 1000, TimeUnit.MILLISECONDS);
		
		pool.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				if(i!=7) {
					add();
					System.out.println(2);
				}
				else {
					Thread.currentThread().interrupt();
					System.out.println(666);
				}
				
			}
			
		}, 0, 1000, TimeUnit.MILLISECONDS);
		
		
	}
	
	public static void add() {
		i++;
	}
	
}
