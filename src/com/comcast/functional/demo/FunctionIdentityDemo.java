package com.comcast.functional.demo;

/**
 * @author rkasar422
 *
 */
public class FunctionIdentityDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//MyFunction<String,String> identity=s->s;
		//instead we can use as a factory method on the function as below
		MyFunction<String,String> identity=MyFunction.identity();
		System.out.println("identity..."+identity.apply("Hello"));

	}

}
