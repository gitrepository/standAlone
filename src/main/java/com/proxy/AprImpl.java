package com.proxy;

public class AprImpl implements IApr{

	public Float getApr(Integer score) {
		Float apr;
		switch (score.intValue()) {
	        case 800: apr = new Float(3.99); break;
	        case 600: apr = new Float(6.99); break;
	        default : apr = new Float(9.99); break;
		}
        return apr;
	}
}
