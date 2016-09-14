package com.ashu.core;

public interface Flys {
	
	String fly();

}

class ItFlys implements Flys {
	@Override
	public String fly() {
		// TODO Auto-generated method stub
		return "Flying";
	}
	
	
}


class CantFly implements Flys {
	@Override
	public String fly() {
		// TODO Auto-generated method stub
		return "Can't fly";
	}
	
	
}
