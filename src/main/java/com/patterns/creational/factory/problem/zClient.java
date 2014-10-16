package com.patterns.creational.factory.problem;

public class zClient {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.draw();
		Rectangle r = new Rectangle();
		r.draw();
		Square s = new Square();
		s.draw();
	}

}
