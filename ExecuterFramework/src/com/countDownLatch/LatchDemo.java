package com.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class LatchDemo {

	public static void main(String[] args) {

		//we need to put the count of threads which waiting threads need to wait for.
		//like 3 we have mentioned over here
		//count.countDown() this will increase the count 
		//count.await() by calling this method we are waiting for count to become 3 
		CountDownLatch count =new CountDownLatch(3);

		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {
					System.out.println("t1-"+i);
				}

				count.countDown();
			}
		});
		

		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {
					System.out.println("t2-"+i);
				}

				count.countDown();
			}
		});
		Thread t3=new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {
					System.out.println("t3-"+i);
				}

				count.countDown();
			}
		});
		t1.start();
		t2.start();
		t3.start();
		try {
			count.await();
			System.out.println("Wait is over");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
