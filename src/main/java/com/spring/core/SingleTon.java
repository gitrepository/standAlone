package com.spring.core;

public class SingleTon {
	private int count = 0;
	private SingleTon sc;
	private ProtoType pc;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public SingleTon getSc() {
		return sc;
	}
	public void setSc(SingleTon sc) {
		this.sc = sc;
	}
	public ProtoType getPc() {
		return pc;
	}
	public void setPc(ProtoType pc) {
		this.pc = pc;
	}
}
