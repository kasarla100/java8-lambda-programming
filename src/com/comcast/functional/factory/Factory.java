package com.comcast.functional.factory;

import java.awt.Color;
import java.util.function.Function;
import java.util.function.Supplier;

import com.comcast.functional.model.Circle;

/**
 * @author rkasar422
 *
 * @param <T>
 */
public interface Factory<T> extends Supplier<T> {

	default T newInstance() {
		return get();
	}

	static Factory<Circle> createFactoryWithColor(Color color) {
		Function<Color, Circle> cons = c -> new Circle(c);
		return () -> cons.apply(color);
	}

	static <T, P> Factory<T> createFactory(Function<P, T> constructor, P color) {
		return () -> constructor.apply(color);
	}

	static <T> Factory<T> createFactory(Supplier<T> supplier) {
		T singleton = supplier.get();
		return () -> singleton;
	}

}
