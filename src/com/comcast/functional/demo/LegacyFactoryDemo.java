package com.comcast.functional.demo;

import com.comcast.functional.factory.LegacyShapeFactory;
import com.comcast.functional.model.Shape;

/**
 * @author rkasar422
 *
 */
public class LegacyFactoryDemo {

	public static void main(String[] args) {
		LegacyShapeFactory shapeFactory = new LegacyShapeFactory();
		// get an object of Square and call its draw method.
		Shape shape1 = shapeFactory.getShape("square");
		// call draw method of Square
		shape1.draw();
		// get an object of Rectangle and call its draw method.
		Shape shape2 = shapeFactory.getShape("rectangle");
		// call draw method of Rectangle
		shape2.draw();
	}
}
