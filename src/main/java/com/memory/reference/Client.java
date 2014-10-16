package com.memory.reference;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		Group g = new Group();
		int c = 0;
		Integer cInteger = 0;
		String s = "";
		List<String> l = new ArrayList<String>();
		
		List<Person> pl = g.getPersonList();
		pl.add(new Person("Sam", "Sam"));
		pl.add(new Person("Bam", "Bam"));
		
		//ONLY List gets PASSED BY REFERENCE and hence any changes made in the method are reflected here
		//All primitive types and Simple types are PASSED BY VALUE and hence the changes made in the method are NOT reflected here
		updateCount(c, cInteger, s, l);

		//ALL custom data types are PASSED BY REFERENCE.
		//Changes Made in the method are reflected here
		updateGroup(g);
		
		//Copy has the reference to the Original One 
		g.setPersonListCopy(g.getPersonList());
		
		//Changes Made to Copy effect the Original One
		updateCopyList(g.getPersonListCopy());

		//Update Form
		Form f = new Form();
		f.setGrpId(g.getId());
		f.setGrpId(f.getGrpId()+"*");
		
		List<PersonForm> pfl = f.getPersonFormList();
		pfl.add(new PersonForm("SamPF"));
		pfl.add(new PersonForm("BamPF"));

		f.getPersonFormList().get(0).setFn(g.getPersonList().get(0).getFn());
		f.getPersonFormList().get(0).setFn("QAZ");
		
		//NEW Copy into Copy ONLY. doesn't effect the original copy.
		g.setPersonListCopy(new ArrayList<Person>());
		
		System.out.println();
	}
	
	private static void updateCount(int c, Integer cInteger, String s, List<String> l){
		c++;
		cInteger = c;
		s = "Alex";
		l.add("Quazi");
		System.out.println();
	}

	private static void updateGroup(Group g){
		g.setId("1");
		for(Person p : g.getPersonList()){
			p.setFn(p.getFn()+" U ");
		}
		g.getPersonList().add(new Person("Larry", "Larry"));
	}

	private static void updateCopyList(List<Person> list){
		for(Person p : list){
			p.setFn(p.getFn()+" U1 ");
		}
		list.add(new Person("Jack", "Jack"));
	}
}
