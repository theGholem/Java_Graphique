package fr.oem2;

public class Dog extends Animal {
	

	private double weigth;
	
	public Dog(String n, int o, double weigth) {
		super(n,o);
		this.weigth=weigth;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getOld() {
		return this.old;
	}
	
	public double getWeigth() {
		return this.weigth;
	}
	
}
