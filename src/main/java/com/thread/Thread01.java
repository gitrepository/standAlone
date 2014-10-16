package com.thread;

class Thread01 extends Thread {
    public Thread01(String str) {
        super(str);
    }
 
    public void run() {
		char startUpper = 'A';
		try {
			for (int i = 0; i < 26; i++) {
				startUpper++;
				sleep(10);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
