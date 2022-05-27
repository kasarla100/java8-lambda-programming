package com.comcast.functional.demo;

import java.util.function.Function;

import com.comcast.functional.model.Customer;
import com.comcast.functional.util.CustomerComparator;

/**
 * Usage of fluent Comparator API designed in Comparator interface
 * 
 * @author rkasar422
 *
 */
public class ComparatorStandardizedDemo {

	public static void main(String[] args) {
		Customer michael = new Customer("Michael", 35);
		Customer jackson = new Customer("Jackson", 30);
		Customer tommy = new Customer("Tommy", 25);
		Customer hillfiger = new Customer("Hillfiger", 20);

		Customer michaelTest = new Customer("Michael", 38);

		Function<Customer, String> getName = o -> o.getName();
		Function<Customer, Integer> getAge = o -> o.getAge();

		// with below dynamic method references keyExtractor, we can remove above
		// functions
		CustomerComparator<Customer> cmp = CustomerComparator.comparing(Customer::getName)
				.thenComparing(Customer::getAge);

		System.out.println(" michael > jackson ? " + (cmp.compare(michael, jackson) > 0));
		System.out.println(" tommy > hillfiger ? " + (cmp.compare(tommy, hillfiger) > 0));

		System.out.println(" michael > michealTest ? " + (cmp.compare(michael, michaelTest) > 0));
		//Comparator<T> 

	}
}
