package fr.oem5;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Konan
 *
 */
public class FrameCompte extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Attribut
	private JPanel panel0,panel1,panel2;
	private JLabel titre1,titre2,lbl1,lbl2,lbl3,lbl4;
	private JTextField jtf1,jtf2,jtf3,jtf4;
	private JButton btn1,btn2;
	
	//default's constructor
	public FrameCompte() {
		
		super("Bank_app"); //title of frame
		
		//initialisation de nos deux paneaux
		titre1=new JLabel("COMPTE A");
		titre2=new JLabel("COMPTE B");
		
		//Ajuster et modifier la police et la taille du titre
		
		titre1.setFont(new Font("Arial",Font.BOLD,24));
		titre2.setFont(new Font("Arial",Font.BOLD,24));
		
		//Initialisation de nos label
		lbl1=new JLabel("Saisir votre montant initial");
		lbl2=new JLabel("deposer un montant");
		lbl3=new JLabel("Retirer un montant");
		lbl4=new JLabel("Transferer un montant vers le compte B");
		
		//Initialisation de nos TextField
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		jtf4=new JTextField(10);
		
		//initialisation de nos boutons
		btn1=new JButton("PUSH");
		btn2=new JButton("PUSH");
		
		//Initialisation de nos panel
		panel1=new JPanel();
		panel2=new JPanel();
		panel0=new JPanel(); // ce panel se charge de contenir nos deux panels
		
		//Alignement des element du panel1 les uns en dessous des autres..("utilisation du BoxLayout()"
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS) );
		
		//Ajouter un border à notre panel1 et un titre à celui ci
		panel1.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10,10,10,10),BorderFactory.createTitledBorder("Gestionnaire de compte")));
		
		panel1.setBackground(Color.ORANGE); //background de notre panel1
		panel1.add(titre1);                 //titre panel1
		
		//Ajouts des elements dans notre panel1
		panel1.add(lbl1);
		panel1.add(jtf1);
		panel1.add(lbl2);
		panel1.add(jtf2);
		panel1.add(lbl3);
		panel1.add(jtf3);
		panel1.add(lbl4);
		panel1.add(jtf4);
		panel1.add(btn1);
		
		
		//Alignement des element du panel2 les uns en dessous des autres..("utilisation du BoxLayout()"
				panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
				
		//Ajouter un border à notre panel2 et un titre à celui ci
		panel2.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10,10,10,10),BorderFactory.createTitledBorder("Gestionnaire de compte")));
		
		
		panel2.setBackground(Color.GRAY); //background de notre panel2
		panel2.add(titre2);               //titre panel2
		
		//Ajout d'un bouton au panel2
		panel2.add(btn2);
		
		GridLayout gl =new GridLayout(1,2);
		panel0.setLayout(gl); //Initialisation d'un gridLayout() pour notre panel0
		//ajouts de panel1 et panel2 dans notre panel0
		panel0.add(panel1);
		panel0.add(panel2);
		
		//Initialisation d'un conteneur pour contenir notre panel0
		Container cnt =getContentPane();
		cnt.add(panel0); //Ajout du panel0
		
		//Ajouts d'action à nos deux buttons
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		//customization de notre cadre
		setSize(new Dimension(500,500));
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);	
		
	}
	
	/**
	 * Methode nous permettant d'ajouter des action à nos elements
	 */
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource()==btn1) {
			
			//Initialisation d'erreur succeptible de se produire, dans le cas où le user saisi des chaine de caractere
			try {
				//recuperation dans les textfield de nos chaine de caracère saisi par le user
				String InputText1=jtf1.getText();
				String InputText2=jtf2.getText();
				String InputText3=jtf3.getText();
				String InputText4=jtf4.getText();
				
				//Conversion des chaine de caractere en réelle
				double text1=Double.parseDouble(InputText1);
				double text2=Double.parseDouble(InputText2);
				double text3=Double.parseDouble(InputText3);
				double text4=Double.parseDouble(InputText4);
				
				//Instanciation avec costructor paramétré de la classe Compte
				Compte compteA=new Compte(text1,text2,text3,text4);
				
				//Affichage dans une pop-up de nos informations
				JOptionPane.showMessageDialog(btn1, "Transaction : \nVous avez deposé : "+compteA.Depot()+" $\nVous avez retiré : "+compteA.retrait()+"$\nVous avez transferé : "+compteA.Trsf()+" $ vers le compte B\nVotre nouveau solde est : "+compteA.SoldeFinal()+" $\nVotre etat finacier : "+compteA.testFond());
			
				
				btn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						
						
						//Affichage dans une pop-up de nos informations relative au compte B
						JOptionPane.showMessageDialog(btn2, "Vous avez recu un montant de "+compteA.Trsf()+" $ du compte A");
					
					}
				});
				
			}catch(NumberFormatException event) {
				JOptionPane.showMessageDialog(btn1, "Erreur : Veuillez entrer un nombre entier svp");
			}
			
			
			
			
		}
	}
	
	
	public static void main(String[]args) throws Exception {
		//Excecution de la classe
		new FrameCompte(); 
	}
}
