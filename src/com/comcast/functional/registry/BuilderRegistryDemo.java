package com.comcast.functional.registry;

import java.util.function.Consumer;

import com.comcast.functional.factory.Factory;
import com.comcast.functional.model.Rectangle;
import com.comcast.functional.model.Shape;
import com.comcast.functional.model.Triangle;

/**
 * @author rkasar422
 *
 */
public class BuilderRegistryDemo {

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {

		Consumer<Builder<Shape>> consumer1 = builder -> builder.register("rectangle", Rectangle::new);

		Consumer<Builder<Shape>> consumer2 = builder -> builder.register("triangle", Triangle::new);

		Consumer<Builder<Shape>> consumer = consumer1.andThen(consumer2);
		Registry registry = Registry.createRegistry(consumer);

		Factory<Rectangle> rectShapeFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
		Rectangle rect = rectShapeFactory.newInstance();
		System.out.println("rect...." + rect);

		Factory<Triangle> triangleShapeFactory = (Factory<Triangle>) registry.buildShapeFactory("triangle");
		Triangle triangle = triangleShapeFactory.newInstance();
		System.out.println("triangle...." + triangle);

	}

}
