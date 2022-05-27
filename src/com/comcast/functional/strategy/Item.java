package com.comcast.functional.strategy;

import java.math.BigDecimal;

/**
 * @author rkasar422
 *
 */
public class Item {
	private int id;
	private BigDecimal price;

	public Item(int id, BigDecimal price) {
		super();
		this.id = id;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
