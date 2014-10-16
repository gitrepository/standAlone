package com.proxy;

public class AutoImpl implements IAuto{

	public String getAutoDetail(String autoId) {
		int id = new Integer(autoId);
		String make;
		switch (id) {
	        case 1: make = "FORD"; break;
	        case 2: make = "TOYOTA"; break;
	        default : make = "HONDA"; break;
		}
        return make;
	}
}
