package fr.oem4;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @apiNote: cette classe crée une interface graphique dans laquelle il existe deux champs et un bouton.
 *           Nos deux champs vont permettre à notres utilisateur de saisir un numerateur et un denominateur.
 *           Quant au bouton, celui ci va permettre d'afficher le resultat de la division du numerateur sur le denominateur
 *           
 *           Evidemment le programme devra etre capable de generer le type d'erreur que l'utilisateur aurait commis :
 *           Par exemple s'il saisi un denominateur=0, ---> out : veuillez reesayer, le denominateur doit etre diffrent de 0
 *           Par exemple s'il saisi un denominateur="String",--> out : saisr un nombre entier
 * 
 * @author Konan
 * 
 *
 */
public class DivisByZero extends JFrame implements ActionListener {

	//Nos Attribut private, on definit de champs de text, deux labael et un boutton
	private JTextField jtf1,jtf2;
	private JLabel jlb1,jlb2;
	private JButton btn;
	private JPanel jpl;
	
	public DivisByZero() {
		
		//Instanciation de nos champs de text
		jtf1=new JTextField(9);
		jtf2=new JTextField(9);
		
		//Instanciation de nos label
		jlb1=new JLabel("Saisir le numerateur svp");
		jlb2=new JLabel("Saisir le denominateur svp");
		
		//Instanciation de notre panel
		jpl=new JPanel();
		
		//instanciation du boutton
		btn=new JButton("PUSH");
		
		//Ajout d'un ActionListener sur notre bouton
		btn.addActionListener(this);
		
		//Configuration de notre layout
		FlowLayout fl=new FlowLayout(FlowLayout.CENTER); // une grille de 2 ligne et 1 colonne
		
		//Ajout des elements dans notre panel(panneau)
		jpl.add(jlb1);
		jpl.add(jtf1);
		jpl.add(jlb2);
		jpl.add(jtf2);
		jpl.add(btn);
		jpl.setLayout(fl);
		jpl.setBackground(Color.ORANGE);
		
		
		//Creation d'un container(conteneur)
		Container cnt=getContentPane();
		
		//Ajout de notre panel à l'interieur de notre container
		cnt.add(jpl);
		
		//Configuration de notre frame
		setSize(new Dimension(300,300));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn) {
			
			
			
			String InputText1=jtf1.getText(); //chaine de caractere representant le denominateur
			String InputText2=jtf2.getText(); //chaine de caractere representant le 
			
			double InputNumber1=Double.parseDouble(InputText1); //conversion chaine caractere en reel
			double InputNumber2=Double.parseDouble(InputText2); //conversion chaine caractere en reel
			
			double InputNumber=InputNumber1/InputNumber2;
			
			JOptionPane.showMessageDialog(btn,InputNumber1+" / "+InputNumber2+" = "+InputNumber);
			
			
		}
	}
	
	public static void main(String[]args) {
		new DivisByZero();
	}
}
