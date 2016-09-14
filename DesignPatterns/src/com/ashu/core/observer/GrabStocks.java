package com.ashu.core.observer;

public class GrabStocks {

	public static void main(String[] args) {
		StockGrabber stockGrabber = new StockGrabber();
		
		StockObserver observer1 = new StockObserver(stockGrabber);
		stockGrabber.setIbmPrice(197.00);
		stockGrabber.setAaplPrice(677.00);
		stockGrabber.setGoogPrice(340);
		
		StockObserver observer2 = new StockObserver(stockGrabber);
		stockGrabber.setIbmPrice(197.00);
		stockGrabber.setAaplPrice(677.00);
		stockGrabber.setGoogPrice(340);
		
		stockGrabber.unreg(observer1);
		
		stockGrabber.setIbmPrice(197.00);
		stockGrabber.setAaplPrice(377.00);
		stockGrabber.setGoogPrice(340);

	}

}
