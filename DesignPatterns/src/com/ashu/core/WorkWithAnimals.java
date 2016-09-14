package com.ashu.core;

public class WorkWithAnimals {

	int justNum = 10;

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

		Animal doggy = new Dog();
		Animal kitty = new Cat();

		Animal[] animals = new Animal[4];
		animals[0] = doggy;
		animals[1] = kitty;

		((Dog) animals[0]).digHole();

		speakAnimal(animals[0]);
		speakAnimal(animals[1]);

		((Dog) animals[0]).testPrivate();
		
		Giraffe giraffe = new Giraffe();
		giraffe.setName("Frank");
		System.out.println((giraffe.getName()));
		
	}

	public static void changeObjectName(Dog fido) {
		fido.setName("Marcus");

	}

	public static void speakAnimal(Animal animal) {
		System.out.println("animal says " + animal.getSound());
	}

	public void hello() {
		System.out.println("animal says ");
	}

}
