package com.comcast.functional.model;

import java.awt.Color;

/**
 * @author rkasar422
 *
 */
public class Circle {

	private Color color;

	public Circle(Color color) {
		this.color = color;
	}

	public Circle() {
		this(Color.BLUE);
	}

	@Override
	public String toString() {
		return "Circle [color=" + color + "]";
	}
}
