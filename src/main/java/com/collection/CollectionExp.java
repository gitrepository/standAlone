package com.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CollectionExp {
	public static void main(String[] args) {
		Random rn1 = new Random();
		int n1 = 0;
		Map<String, String> map = new HashMap<String, String>();
		for(int i = 0; i < 20; i++){
			n1 = rn1.nextInt(5);
			System.out.println(n1);
			if(!map.containsKey(Integer.toString(n1))){
				map.put(Integer.toString(n1), Integer.toString(n1));
			} else {
				System.out.println("Key Exists");
			}
		}
	}
}
