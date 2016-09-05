package com.ashu.core;

public class WorkWithAnimals {

	public static void main(String[] args) {
		Dog fido = new Dog();

		fido.setName("Silky");
		System.out.println(fido.getName());

		fido.digHole();
		fido.setWeight(-1);
		int randnum = 10;
		fido.changeVar(randnum);
		System.out.println("randnum after method call " + randnum);
		changeObjectName(fido);
		System.out.println("dogname after method call " + fido.getName());
	}
	
	public static void changeObjectName(Dog fido) {
		fido.setName("Marcus");
		
	}

}
