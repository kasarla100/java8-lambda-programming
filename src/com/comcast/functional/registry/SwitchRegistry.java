package com.comcast.functional.registry;

import com.comcast.functional.factory.Factory;
import com.comcast.functional.model.Rectangle;
import com.comcast.functional.model.Shape;
import com.comcast.functional.model.Square;
import com.comcast.functional.model.Triangle;

/**
 * Legacy style of registry pattern using Switch case
 * @author rkasar422
 *
 */
public class SwitchRegistry {

	/**
	 * @param shape
	 * @return
	 */
	public Factory<? extends Shape> buildShapeFactory(String shape) {
		switch (shape) {
		case "square":
			return () -> new Square();
		case "triangle":
			return () -> new Triangle();
		case "rectangle":
			return () -> new Rectangle();
		default:
			throw new IllegalArgumentException("Unknown shape" + shape);

		}
	}
}
