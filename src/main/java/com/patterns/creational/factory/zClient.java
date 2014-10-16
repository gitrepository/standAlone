package com.patterns.creational.factory;

public class zClient {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		IShape shape = null;

		shape = shapeFactory.getShape("RECTANGLE");
		shape.draw();
		shape = shapeFactory.getShape("CIRCLE");
		shape.draw();
		shape = shapeFactory.getShape("SQUARE");
		shape.draw();
	}
}