package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		executorService.execute(new Runnable() {
			public void run() {
				for(int i=0;i<100;i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Asynchronous task1-"+i);
				}
				
			}
		});
		
		executorService.execute(new Runnable() {
			public void run() {
				for(int i=0;i<100;i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Asynchronous task2-"+i);
				}
				
			
			}
		});

		executorService.shutdown();
	}

}
