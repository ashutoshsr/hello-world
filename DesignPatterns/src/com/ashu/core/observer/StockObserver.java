package com.ashu.core.observer;

public class StockObserver implements Observer {

	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;

	private static int obsIdTracker = 0;

	private int obsId = 0;

	private Subject stockGrabber;

	public StockObserver(Subject grabber) {
		this.stockGrabber = grabber;
		this.obsId = ++obsIdTracker;

		System.out.println("New observer" + this.obsId);

		stockGrabber.register(this);
	}

	@Override
	public void update(double ibmPrice, double aaplPrice, double googPrice) {
		this.ibmPrice = ibmPrice;
		this.aaplPrice = aaplPrice;
		this.googPrice = googPrice;

		printThePrices();
	}

	private void printThePrices() {
		System.out.println(
				obsId + "\nibmPrice: " + ibmPrice + "\naaaplPrice: " + aaplPrice + "\nggoogPrice: " + googPrice);
	}

}
