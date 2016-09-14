package com.ashu.core.observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {
	List<Observer> observers;
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	public StockGrabber() {
		observers = new ArrayList<>();
	}

	@Override
	public void register(Observer o) {
		observers.add(o);

	}

	@Override
	public void unreg(Observer o) {
		int observerIndex = observers.indexOf(o);
		System.out.println("Observer " + observerIndex + " deleted");

		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(ibmPrice, aaplPrice, googPrice);
		}
		
	}

	protected void setIbmPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
		notifyObserver();
	}

	protected void setAaplPrice(double aaplPrice) {
		this.aaplPrice = aaplPrice;
		notifyObserver();
	}

	protected void setGoogPrice(double googPrice) {
		this.googPrice = googPrice;
		notifyObserver();
	}
	

}
