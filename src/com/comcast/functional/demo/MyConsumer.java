package com.comcast.functional.demo;

import java.util.Objects;

@FunctionalInterface
public interface MyConsumer<T> {

	void accept(T t);

	/**
	 * @param c2
	 * @return
	 */
	default MyConsumer<T> andThen(MyConsumer<T> other){
		Objects.requireNonNull(other);
		return (T t)->{
			this.accept(t);
			other.accept(t);
		};
	}

	


}
