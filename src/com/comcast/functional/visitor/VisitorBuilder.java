package com.comcast.functional.visitor;

import java.util.function.Function;

/**
 * @author rkasar422
 *
 * @param <R>
 */
public interface VisitorBuilder<R> {

	void register(Class<?> type,Function<Object,R> function);
}
