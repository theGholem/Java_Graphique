package fr.oem2;

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
import javax.swing.JTextField;

public class FramTestAnimal extends JFrame implements ActionListener  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[]args) throws Exception {
		new FramTestAnimal(); 
	}

	private JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
	private JButton btn1,btn2;
	
	public FramTestAnimal() {
		
		jtf1=new JTextField(20);
		jtf2=new JTextField(20);
		jtf3=new JTextField(20);
		jtf4=new JTextField(20);
		jtf5=new JTextField(20);
		jtf6=new JTextField(20);
		
		lbl1=new JLabel("Saisir le nom du chat : ");
		lbl2=new JLabel("Saisir l'age du chat : ");
		lbl3=new JLabel("Saisir la couleur du chat : ");
		lbl4=new JLabel("Saisir le nom du chien : ");
		lbl5=new JLabel("Saisir l'age du chien : ");
		lbl6=new JLabel("Saisir le poids du chien : ");
		
		
		btn1=new JButton("push");
		btn2=new JButton("push");
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		Container cnt=getContentPane();
		//Container cnt2=getContentPane();
		
		
		//BoxLayout bxl=new BoxLayout(this,BoxLayout.Y_AXIS);
		GridLayout gl=new GridLayout(2,1);		
		cnt.setLayout(gl);
		gl.setHgap(15);
		gl.setVgap(15);
		cnt.setBackground(Color.YELLOW);
		cnt.add(lbl1);
		cnt.add(jtf1);
		cnt.add(lbl2);
		cnt.add(jtf2);
		cnt.add(lbl3);
		cnt.add(jtf3);
		cnt.add(btn1);
		
		cnt.add(lbl4);
		cnt.add(jtf4);
		cnt.add(lbl5);
		cnt.add(jtf5);
		cnt.add(lbl6);
		cnt.add(jtf6);
		cnt.add(btn2);
		
		setSize(new Dimension(500,500));
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	
		
		if(e.getSource()==btn1) {
			
			try {
				String inputText1=jtf1.getText(); //saisi nom du chat
				String inputText2=jtf2.getText(); 
				int n1=Integer.parseInt(inputText2);//saisi age du chat
				String inputText3=jtf3.getText(); //saisi couleur du chat
				
		
				
				Cat inf=new Cat(inputText1,n1,inputText3);
				
				JOptionPane.showMessageDialog(btn1, "INFO CHAT : \nNom : "+inf.getName()+"\nAge : "+inf.getOld()+" ans\nCouleur : "+inf.getColor());
				

			}catch(NumberFormatException event) {
				JOptionPane.showMessageDialog(btn1, "ERROR : Veuillez remplir Correctement tous les champs svp");
			}
			
			}else if(e.getSource()==btn2) {
				
				try {
					String inputText4=jtf4.getText(); //saisi nom du chien
					String inputText5=jtf5.getText(); 
					int n2=Integer.parseInt(inputText5);//saisi age du chien
					String inputText6=jtf6.getText(); 
					Double n3=Double.parseDouble(inputText6);//saisi couleur du chien
					
					Dog inf=new Dog(inputText4,n2,n3);
					
					JOptionPane.showMessageDialog(btn1, "INFO CHIEN : \nNom : "+inf.getName()+"\nAge : "+inf.getOld()+" ans\nPoids : "+inf.getWeigth()+" Kg");
					
				}catch(NumberFormatException even) {
					JOptionPane.showMessageDialog(btn1, "ERROR : Veuillez remplir correctemen tous les champs svp");
				}
				
			
		}
	}
	
	
	
	
	
}
