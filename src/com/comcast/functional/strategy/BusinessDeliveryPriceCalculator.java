package com.comcast.functional.strategy;

import java.math.BigDecimal;

public class BusinessDeliveryPriceCalculator implements DeliveryPriceCalculator {

	@Override
	public BigDecimal priceFor(Item item) {
		return item.getPrice().multiply(new BigDecimal("0.050")).add(new BigDecimal("1.0"));
	}

}
