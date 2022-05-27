package com.comcast.functional.demo;

import java.util.Objects;

/**
 * @author rkasar422
 *
 * @param <T>
 */
@FunctionalInterface
public interface MyPredicate<T> {
	boolean test(T t);

	/**
	 * @param other
	 * @return
	 */
	default MyPredicate<T> and(MyPredicate<T> other) {
		Objects.requireNonNull(other);
		return (T t) -> this.test(t) && other.test(t);
	}

	/**
	 * @param other
	 * @return
	 */
	default MyPredicate<T> negate() {
		return (T t) -> !this.test(t);
	}

}
