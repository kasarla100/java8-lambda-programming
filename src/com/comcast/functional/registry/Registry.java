package com.comcast.functional.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.comcast.functional.factory.Factory;
import com.comcast.functional.model.Shape;

/**
 * @author rkasar422
 *
 */
public interface Registry {

	Factory<? extends Shape> buildShapeFactory(String shape);

	public static Registry createRegistry(Consumer<Builder<Shape>> consumer) {
		Map<String, Factory<Shape>> map = new HashMap<>();
		Builder<Shape> builder = (label, factory) -> map.put(label, factory);

		consumer.accept(builder);

		System.out.println("Map..." + map);
		return shape -> map.get(shape);
	}
}
