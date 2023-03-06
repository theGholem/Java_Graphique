package fr.APP1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunnableBound extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//On aura besoin de la position de notre boule(add x,y) et le diametre
	private int x,y,d;
	
	/**
	 * Constructor of boule
	 * On initialise juste les valeur clés de notre bool
	 */
	public RunnableBound() {
		//Valeur initial de nos caracteristique
		this.x=30;
		this.y=30;
		this.d=30;
		
		setBackground(Color.GRAY); //Ajoute une coleur de fond à notre panel
	}
	
	/**
	 * @apiNote : cette methode nous permet de dessiner un cercle dans notre panel
	 *            Pour dessiner, on utilise la methode paintComponent()
	 *  
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.orange); //On choisi la couleur rouge pour notre boule
		g.fillOval(x, y, d, d); // on crée notre boule(ovale), on ajoute les coordonnées x et y, et ensuite la largeur et la hauteur enfin ( d )
		
	}
	
	/**
	 * 
	 * @apiNote : Cette methode contient la boucle de jeux qui met à jour la position de la boule 
	 *            et la redessine à chaque image.
	 */
	public void run() {
		
		/**
		 * @apiNote : La boucle while(true), permet de repeter le code à l'infini jusqu'à ce que le programme soit fermé 
		 */
		while(true) {
			x+=5; // evolue de 5px à chaque fois vers la droite
			y+=5; // evolue de 5px à chaque fois vers le haut
			
			/**
			 * cette condition verifie si la boule atteint le bord droit de la frame.
			 * Si c'est le cas, la boule est automatiquement ramené au bord gauche de la 
			 * frame en lui affectant x=0
			 * 
			 */
			if(this.x+this.d>getWidth()) {
				this.x=0;
			}
			/**
			 * cette condition verifie si la boule atteint le bord superieur de la frame.
			 * Si c'est le cas, la boule est automatiquement ramené au bord inferieur de la 
			 * frame en lui affectant y=0
			 * 
			 */
			if(this.y+this.d>getHeight()) {
				this.y=0;
			}
			
			repaint(); //Cette methode est appelé pour redessiner la boule à sa nouvelle position.
			
			/**
			 * Une exception peut etre relevé lorsque le thread est en pause..ici pendant 20millisecond
			 * En effet pendant cette pause, le thread peut etre interrompu par une autre partie du programme, ou meme par le User
			 * ce qui entrainera une erreur de type "InterruptionException".
			 * Cette exception est gére dans le catch en affichant simplement les traces de la pile d'erreur
			 */
			try {
				Thread.sleep(20); //met le thread en pause pendant 20milliseconde à chaque iteration de la boucle
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		//Instanciation de notre fenetre
		JFrame frame=new JFrame();
		
		//Instanciation de notre boule
		RunnableBound boule =new RunnableBound();
		
		//ajout de la boule dans notre frame
		frame.add(boule);
		
		//Configuration de la frame
		frame.setSize(new Dimension(500,500));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		//Instatiation de notre Thread et ajout de la boule en parametre
		Thread t=new Thread(boule);
		t.start(); // cette methode lance le programme simplement
		
	}
}
