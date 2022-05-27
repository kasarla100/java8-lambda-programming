package com.comcast.functional.strategy;

import java.math.BigDecimal;

public class PremiumDeliveryPriceCalculator implements DeliveryPriceCalculator {

	@Override
	public BigDecimal priceFor(Item item) {
		return item.getPrice().multiply(new BigDecimal("0.035")).add(new BigDecimal("1.0"));
	}

}