package com.comcast.functional.factory;

import com.comcast.functional.model.Rectangle;
import com.comcast.functional.model.Shape;
import com.comcast.functional.model.Square;

/**
 * legacy java5/6 style factory pattern
 * 
 * @author rkasar422
 *
 */
public class LegacyShapeFactory {

	/**
	 * @param shapeType
	 * @return
	 */
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("square")) {
			return new Square();
		} else if (shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		} else {
			throw new IllegalArgumentException("Unknown Shape" + shapeType);
		}

	}
}
