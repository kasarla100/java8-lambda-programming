package com.comcast.functional.demo;

/**
 * @author rkasar422
 *
 * @param <T> input
 * @param <R> return
 */
@FunctionalInterface
public interface MyFunction<T, R> {
	/**
	 * @param t
	 * @return
	 */
	R apply(T t);

	default <V> MyFunction<T, V> andThen(MyFunction<R, V> other) {
		return (T t) -> {
			R r = this.apply(t); // get celcius here
			return other.apply(r); // using celcius , get fahrenheit here
		};
	}

	default <V> MyFunction<V, R> compose(MyFunction<V, T> other) {
		return (V v) -> {
			T t = other.apply(v);
			return this.apply(t);
		};
	}

	static <T> MyFunction<T, T> identity() {
		return t -> t;
	}

}
