package com.comcast.functional.demo;

import java.awt.Color;
import java.util.function.Supplier;

import com.comcast.functional.factory.Factory;
import com.comcast.functional.factory.ShapeFactorySupplier;
import com.comcast.functional.model.Circle;

/**
 * @author rkasar422
 *
 */
public class FactoryDemo {

	public static void main(String[] args) {

		Factory<Circle> factory1 = Factory.createFactoryWithColor(Color.red);

		Circle circle = factory1.newInstance();
		System.out.println("circle with newInstance..." + circle);

		//List<Circle> cirLst = factory1.create5();
//		System.out.println("list of 5 circle objs..." + cirLst);
		
		Factory<Circle> factory2 = Factory.createFactory(color->new Circle(color),Color.red);
		Circle circle2 = factory2.newInstance();
		System.out.println("circle with newInstance..." + circle2);
		
		Supplier<ShapeFactorySupplier> shapeFactory =  ShapeFactorySupplier::new;
		//call draw method of square
	     shapeFactory.get().getShape("square").draw();
	     //call draw method of Rectangle
	     shapeFactory.get().getShape("rectangle").draw();

	}

}
