package com.numbers;

import java.util.Random;

public class RandonNumberExp {
	public static void main(String[] args) {
		Random rn1 = new Random();
		Random rn2 = new Random();
		int n1 = 0;
		int n2 = 0;
		for(int i = 0; i < 20; i++){
			if(n1 != n2){
				System.out.println(n1+""+n2);
			}
			n1 = rn1.nextInt(5);
			n2 = rn2.nextInt(5);
		}
	}
}
