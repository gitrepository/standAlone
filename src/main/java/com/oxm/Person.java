package com.oxm;

public class Person {
	private String fn = "FN";
	private String ln = "LN";

	public Person(String fn, String ln) {
		super();
		this.fn = fn;
		this.ln = ln;
	}
	/*
	 * G&S
	 */
	
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
}
