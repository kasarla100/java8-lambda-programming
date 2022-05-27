package com.comcast.functional.model;

/**
 * @author rkasar422
 *
 */
public class Square extends Shape{

	@Override
	public void draw() {
		System.out.println("square");
	}
	
	@Override
	public String toString() {
		return "Square []";
	}
}
