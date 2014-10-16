package com.oxm;

import java.util.List;

public class Settings {
	private int i;
	private long l;
	private float f;
	private double d;
	private boolean b;

	private String string;
	
	private Integer integer;
	private Long long1;
	private Float float1;
	private Double double1;
	private Boolean boolean1;
	
	private List<String> stringList;
	
	/*
	 * G&S
	 */
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public long getL() {
		return l;
	}
	public void setL(long l) {
		this.l = l;
	}
	public float getF() {
		return f;
	}
	public void setF(float f) {
		this.f = f;
	}
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public Integer getInteger() {
		return integer;
	}
	public void setInteger(Integer integer) {
		this.integer = integer;
	}
	public Long getLong1() {
		return long1;
	}
	public void setLong1(Long long1) {
		this.long1 = long1;
	}
	public Float getFloat1() {
		return float1;
	}
	public void setFloat1(Float float1) {
		this.float1 = float1;
	}
	public Double getDouble1() {
		return double1;
	}
	public void setDouble1(Double double1) {
		this.double1 = double1;
	}
	public List<String> getStringList() {
		return stringList;
	}
	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	public Boolean getBoolean1() {
		return boolean1;
	}
	public void setBoolean1(Boolean boolean1) {
		this.boolean1 = boolean1;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
}