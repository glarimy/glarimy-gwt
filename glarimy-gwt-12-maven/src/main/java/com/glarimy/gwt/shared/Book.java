package com.glarimy.gwt.shared;

import java.io.Serializable;

public class Book implements Serializable {
	private static final long serialVersionUID = -6538297988941516327L;
	private int isbn;
	private String title;
	private double price;

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
