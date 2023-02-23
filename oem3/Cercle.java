package fr.oem3;

public class Cercle {
	

	private double rayon;
	
	//Constructor
	public Cercle(double rayon) {
		this.rayon=rayon;
	}
	
	/**
	 * 
	 * @return perimetre cercle
	 */
	public double Perimetre() {
		double rst=2*Math.PI*this.rayon;
		return rst;
	}
	
	/**
	 * 
	 * @return aire du cercle
	 */
	public double Surface() {
		double rst=Math.PI*this.rayon*this.rayon;
		return rst;
	}
}
