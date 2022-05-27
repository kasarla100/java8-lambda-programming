package com.comcast.functional.model;

/**
 * @author rkasar422
 *
 */
public class Rectangle extends Shape {

	@Override
	public String toString() {
		return "Rectangle []";
	}

	@Override
	public void draw() {
		System.out.println("rectangle");
	}
}
