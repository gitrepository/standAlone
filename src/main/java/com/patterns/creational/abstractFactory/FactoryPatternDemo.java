package com.patterns.creational.abstractFactory;

public class FactoryPatternDemo {
/*
 * Define an interface for creating an object, but let subclasses decide which class to instantiate.
 * Factory Method lets a class defer instantiation to subclasses.
 *
 * class defer instantiation to subclasses.
 *
 */
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		Shape shape = shapeFactory.getShape("CIRCLE");
		shape.draw();
		//get an object of Rectangle and call its draw method.
		shape = shapeFactory.getShape("RECTANGLE");
		shape.draw();
		//get an object of Square and call its draw method.
		shape = shapeFactory.getShape("SQUARE");
		shape.draw();
	}
}