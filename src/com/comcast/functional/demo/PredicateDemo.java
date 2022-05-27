package com.comcast.functional.demo;

/**
 * @author rkasar422
 *
 */
public class PredicateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyPredicate<String> p1 = s -> s != null;
		MyPredicate<String> p2 = s -> !s.isEmpty();

		MyPredicate<String> p3 = p1.and(p2);
		System.out.println("Test for null: " + p3.test(null));
		System.out.println("Test for empty: " + p3.test(""));
		System.out.println("Test for non empty: " + p3.test("Hello"));
		
		MyPredicate<String> p4 = s -> s.isEmpty();
		MyPredicate<String> notP4 = p4.negate();
		//shouldnt change result from above, as negated
		System.out.println("Test for non empty: " + notP4.test("Hello"));


	}

}
