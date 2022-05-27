package com.comcast.functional.strategy;

/**
 * @author rkasar422
 *
 */
public class PriceCalculatorFactory {

	private final DeliveryPriceCalculator basicDeliveryPriceCalculator = new BasicDeliveryPriceCalculator();
	private final DeliveryPriceCalculator premiumDeliveryPriceCalculator = new PremiumDeliveryPriceCalculator();
	private final DeliveryPriceCalculator businessDeliveryPriceCalculator = new BusinessDeliveryPriceCalculator();

	public DeliveryPriceCalculator priceCalculatorFor(DeliveryPlan deliveryPlan) {
		switch (deliveryPlan) {
		case BASIC:
			return basicDeliveryPriceCalculator;
		case PREMIUM:
			return premiumDeliveryPriceCalculator;
		case BUSINESS:
			return businessDeliveryPriceCalculator;
		default:
			return null;
		}
	}

}
