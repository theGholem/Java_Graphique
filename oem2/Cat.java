package fr.oem2;

public class Cat extends Animal {

	private String color;
	
	public Cat(String n, int o, String color) {
		super(n,o);
		this.color=color;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getOld() {
		return this.old;
	}
	
	public String getColor() {
		return this.color;
	}
	
	
	
	
}
