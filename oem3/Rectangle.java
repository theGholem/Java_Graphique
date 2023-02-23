package fr.oem3;

public class Rectangle {

	private double length,width;
	
	//Constructor
	public Rectangle(double length, double width) {
		this.length=length;
		this.width=width;
	}
	
	/**
	 * 
	 * @return perimetre rectangle
	 */
	public double Perimetre() {
		double rst=(this.length+this.width)*2;
		return rst;
	}
	
	/**
	 * 
	 * @return aire du rectangle
	 */
	public double Surface() {
		double rst=this.length*this.width;
		return rst;
	}
	
}
