package com.comcast.functional.registry;

import com.comcast.functional.factory.Factory;

/**
 * @author rkasar422
 *
 * @param <T>
 */
public interface Builder<T> {
	// record factories in some kind of hashmap for all labels
	void register(String label, Factory<T> factory);

}
