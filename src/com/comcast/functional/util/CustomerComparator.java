package com.comcast.functional.util;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author rkasar422
 *
 */
public interface CustomerComparator<T> {

	/**
	 * @param t1
	 * @param t2
	 * @return
	 */
	int compare(T t1, T t2);

	default CustomerComparator<T> thenComparing(CustomerComparator<T> other) {
		Objects.requireNonNull(other);
		return (T t1, T t2) -> {
			int cmp = this.compare(t1, t2);
			return (cmp != 0) ? cmp : other.compare(t1, t2);
		};
	}

	default CustomerComparator<T> reversed() {
		return (t1, t2) -> this.compare(t2, t1);
	}

	default <U extends Comparable<U>> CustomerComparator<T> thenComparing(Function<T, U> keyExtractor) {
		Objects.requireNonNull(keyExtractor);
		CustomerComparator<T> other = comparing(keyExtractor);
		return this.thenComparing(other);
	}

	/**
	 * modified now with generic arguments to match any object type
	 * 
	 * @param <T>
	 * @param <U>
	 * @param keyExtractor
	 * @return
	 */
	public static <T, U extends Comparable<U>> CustomerComparator<T> comparing(Function<T, U> keyExtractor) {
		Objects.requireNonNull(keyExtractor);
		return (t1, t2) -> {
			U dt1 = keyExtractor.apply(t1);
			U dt2 = keyExtractor.apply(t2);
			return dt1.compareTo(dt2);
		};
	}

}
