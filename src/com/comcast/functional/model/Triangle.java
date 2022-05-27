package com.comcast.functional.model;

public class Triangle extends Shape{

	@Override
	public void draw() {
		System.out.println("triangle");
	}
	
	@Override
	public String toString() {
		return "Triangle []";
	}

}
