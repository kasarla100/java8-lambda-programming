/**
 * 
 */
package com.comcast.functional.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.comcast.functional.model.Rectangle;
import com.comcast.functional.model.Shape;
import com.comcast.functional.model.Square;

/**
 * modified LegacyShapeFactory with supplier to be dynamic
 * @author rkasar422
 *
 */
public class ShapeFactorySupplier {
	
	final static Map<String, Supplier<Shape>> map = new HashMap<>();
	static {
		map.put("square", Square::new);
		map.put("rectangle", Rectangle::new);
	}

	public Shape getShape(String shapeType) {
		Supplier<Shape> shape = map.get(shapeType);
		if (shape != null) {
			return shape.get();
		}
		throw new IllegalArgumentException("No such shape " + shapeType.toUpperCase());
	}
}
