package com.thread;
public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable(), "ID")).start();
    }

}