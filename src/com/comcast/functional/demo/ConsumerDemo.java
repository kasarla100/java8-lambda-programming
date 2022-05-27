package com.comcast.functional.demo;

/**
 * @author rkasar422
 *
 */
public class ConsumerDemo {
	public static void main(String[] args) {

		MyConsumer<String> c1=s->System.out.println("c1= "+s);
		MyConsumer<String> c2=s->System.out.println("c2= "+s);
		
		MyConsumer<String>c3=c1.andThen(null);
		c3.accept("hello");
		
		System.out.println("Exiting main");
	}
}
