package com.spring.core;

public class ProtoType {
	private int count = 0;
	private static int createCount = 0;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static int getCreateCount() {
		return createCount;
	}
	public static void setCreateCount(int createCount) {
		ProtoType.createCount = createCount;
	}
}
