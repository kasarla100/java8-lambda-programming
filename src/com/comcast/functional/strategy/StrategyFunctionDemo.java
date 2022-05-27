package com.comcast.functional.strategy;

import java.math.BigDecimal;

public class StrategyFunctionDemo {

	public static void main(String[] args) {
		final Item item = new Item(123, new BigDecimal("100.00"));
		System.out.println(Plan.BASIC + "...Delivery price is " + Plan.BASIC.deliveryPrice.apply(item));
		System.out.println(Plan.PREMIUM + "...Delivery price is " + Plan.PREMIUM.deliveryPrice.apply(item));
		System.out.println(Plan.BUSINESS + "...Delivery price is " + Plan.BUSINESS.deliveryPrice.apply(item));
	}

}
