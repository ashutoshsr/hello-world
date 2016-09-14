package com.ashu.core;

abstract public class Creature {
	protected String name;
	protected String weight;
	protected String sound;

	abstract String getWeight();
	abstract void setWeight(String weight);
	abstract String getSound();
	abstract void setSound(String sound);
	
	public abstract void setName(String newName);
	public abstract String getName();
	

}
