package com.comcast.functional.strategy;

import java.math.BigDecimal;

public class BasicDeliveryPriceCalculator implements DeliveryPriceCalculator {

	@Override
	public BigDecimal priceFor(Item item) {
		return item.getPrice().multiply(new BigDecimal("0.025")).add(new BigDecimal("1.0"));
	}

}
