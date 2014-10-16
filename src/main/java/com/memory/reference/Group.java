package com.memory.reference;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private String id;
	private List<Person> personList = new ArrayList<Person>();
	private List<Person> personListCopy = new ArrayList<Person>();
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
	public List<Person> getPersonListCopy() {
		return personListCopy;
	}
	public void setPersonListCopy(List<Person> personListCopy) {
		this.personListCopy = personListCopy;
	}
}
