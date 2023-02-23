package fr.oem2;

abstract public class Animal {

	protected String name;
	protected int old;
	
	public Animal(String name, int old) {
		this.name=name;
		this.old=old;
	}
	
	abstract public String getName();
	abstract public int getOld();
	
	
}
