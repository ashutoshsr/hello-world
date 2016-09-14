package com.ashu.core;

public class Animal {
	private String name;
	private int weight;
	private String sound;
	
	public Flys flyingType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			System.out.println("Weight must be bigger than zero");
		}
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
	
	public String tryToFly() {
		return flyingType.fly();
	}

	public void setFlyingAbility(Flys newFlyType) {
		flyingType = newFlyType;
	}
}
