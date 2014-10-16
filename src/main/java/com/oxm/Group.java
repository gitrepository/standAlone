package com.oxm;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private String id;
	private List<Person> personList = new ArrayList<Person>();
	/*
	 * G&S
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Person> getPersonList() {
		return personList;
	}
	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
}
