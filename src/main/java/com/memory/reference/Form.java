package com.memory.reference;

import java.util.ArrayList;
import java.util.List;

public class Form {
	private String grpId;
	private List<PersonForm> personFormList = new ArrayList<PersonForm>();
	/*
	 * G&S
	 */
	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	public List<PersonForm> getPersonFormList() {
		return personFormList;
	}
	public void setPersonFormList(List<PersonForm> personFormList) {
		this.personFormList = personFormList;
	}
}
