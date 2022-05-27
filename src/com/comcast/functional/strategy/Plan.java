package com.comcast.functional.strategy;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * @author rkasar422
 *
 */
public enum Plan {
	BASIC(deliveryPricePercentage("0.025")),
	PREMIUM(deliveryPricePercentage("0.035")),
	BUSINESS(deliveryPricePercentage("0.050"));
	
	private static Function<Item,BigDecimal>deliveryPricePercentage(String percentageSurplus){
		return item->item.getPrice().multiply(new BigDecimal(percentageSurplus)).add(new BigDecimal("1.0"));
	}
	
	public final Function<Item,BigDecimal>deliveryPrice;
	
	Plan(Function<Item,BigDecimal>deliveryPrice){
		this.deliveryPrice=deliveryPrice;
	}

}
