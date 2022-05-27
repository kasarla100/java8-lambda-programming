package com.comcast.functional.demo;

import java.util.function.Function;

import com.comcast.functional.model.Customer;
import com.comcast.functional.util.CustomerComparator;

public class ComparatorDemo {
	public static void main(String[] args) {
		Customer micheal = new Customer("Micheal", 30);
		Customer jackson = new Customer("Jackson", 35);
		Customer tommy = new Customer("Tommy", 20);
		Customer hillfiger = new Customer("Hillfiger", 25);

		CustomerComparator<Customer> custCmp = (c1, c2) -> {
			String s1 = c1.getName();
			String s2 = c2.getName();
			return s1.compareTo(s2);
		};
		System.out.println(" micheal > jackson ? " + (custCmp.compare(micheal, jackson) > 0));
		System.out.println(" tommy > hillfiger ? " + (custCmp.compare(tommy, hillfiger) > 0));
		//
		CustomerComparator<Customer> cmpReversed = custCmp.reversed();
		System.out.println(" micheal > jackson ? " + (cmpReversed.compare(micheal, jackson) > 0));
		System.out.println(" tommy > hillfiger ? " + (cmpReversed.compare(tommy, hillfiger) > 0));
		//lets go with function
		Function<Customer, Integer> getAge = o -> o.getAge();
		CustomerComparator<Customer> ageCmp = CustomerComparator.comparing(getAge);
		System.out.println(" micheal > jackson ? " + (ageCmp.compare(micheal, jackson) > 0));
		// now compose with multiple
		CustomerComparator<Customer> cmp = custCmp.thenComparing(ageCmp);
		System.out.println(" micheal > jackson ? " + (cmp.compare(micheal, jackson) > 0));

	}
}
