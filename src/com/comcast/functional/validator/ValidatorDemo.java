/**
 * 
 */
package com.comcast.functional.validator;

import com.comcast.functional.model.Customer;

/**
 * @author rkasar422
 *
 */
public class ValidatorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Customer michael = new Customer("michael", 29);

		Customer jackson = new Customer(null, 40);
		Customer charlie = new Customer("charlie", -5);
		Customer chaplin = new Customer("chaplin", 1_750);
		Customer linda = new Customer(null, 500);

		michael = Validator.validate(c -> c.getName() != null, "The name should not be null").on(michael).validate();

		System.out.println("michael ..." + michael);

		chaplin = Validator.validate(c -> c.getName()!= null, "The name should not be null")
				.thenValidate(c -> c.getAge() > 0, "The age should be greater than 0")
				.thenValidate(c -> c.getAge() <150 , "The age should be lesser than 150")
				.on(chaplin).validate();

		System.out.println("jackson ..." + chaplin);
	}

}
