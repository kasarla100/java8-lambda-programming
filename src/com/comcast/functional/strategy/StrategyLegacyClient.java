package com.comcast.functional.strategy;

import java.math.BigDecimal;

/**
 * @author rkasar422
 *
 */
public class StrategyLegacyClient {
	public static void main(String[] args) {

		PriceCalculatorFactory factory = new PriceCalculatorFactory();

		Item newItem = new Item(123, new BigDecimal("100.00"));
		DeliveryPriceCalculator priceCalculator = factory.priceCalculatorFor(DeliveryPlan.BASIC);
		System.out.println("Delivery price is " + priceCalculator.priceFor(newItem));

	}

}
