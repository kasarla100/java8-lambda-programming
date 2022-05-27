/**
 * 
 */
package com.comcast.functional.validator;

import java.util.function.Predicate;
import java.util.function.Supplier;

import com.comcast.functional.model.Customer;

/**
 * @author rkasar422
 *
 */
public interface Validator {

	ValidatorSupplier on(Customer c);

	interface ValidatorSupplier extends Supplier<Customer> {
		default Customer validate() {
			return get();
		}
	}

	/**
	 * @param Predicate<Customer>
	 * @param string
	 * @return
	 */
	static Validator validate(Predicate<Customer> predicate, String errorMsg) {
		return p -> {
			if (predicate.test(p)) {
				return () -> p;
			} else {
				return () -> {
					ValidationException exception = new ValidationException("The object is not valid");
					exception.addSuppressed(new IllegalArgumentException(errorMsg));
					throw exception;
				};
			}
		};
	}

	/**
	 * @param object
	 * @param string
	 * @return
	 */
	default Validator thenValidate(Predicate<Customer> predicate, String errorMsg) {
		return c -> {
			try {
				on(c).validate();
				// if no exception on above call
				if (predicate.test(c)) {
					return () -> c;
				} else {
					return () -> {
						throw new ValidationException(errorMsg);
					};
				}
			} catch (ValidationException ve) {
				// if we get validation exception, test predicate
				if (predicate.test(c)) {
					return () -> {
						throw ve;
					};
				} else {
					{
						ve.addSuppressed(new IllegalArgumentException(errorMsg));
						return () -> {
							throw ve;
						};
					}
				}

			}
		};
	}

	static class ValidationException extends RuntimeException {
		public ValidationException(String errorMsg) {
			super(errorMsg);
		}
	}

}
