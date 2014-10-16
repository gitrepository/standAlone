package com.thread;

public class ThreadExample {
	 
    /**
     * @author Crunchify.com
     */
 
    public static void main(String args[]) {
        new ThreadTest("100").start();
        new ThreadTest("200").start();
        new ThreadTest("300").start();
    }
}
 
class ThreadTest extends Thread {
    public ThreadTest(String str) {
        super(str);
    }
 
    public void run() {
    	int st = Integer.parseInt(getName());
        for (int i = st; i < st+99; i++) {
            System.out.println("Loop " + i + ": " + getName());
            try {
                sleep(2000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Test Finished for: " + getName());
    }
}