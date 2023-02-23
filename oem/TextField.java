package fr.oem;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TextField extends JFrame implements ActionListener {
	
	//our main class
	public static void main(String[]args) {
		new TextField();
	}
	
	//Attribut
	private JTextField inputField;
	private JButton btn;
	private JLabel lbl;
	
	//Constructor
	public TextField() {
		inputField=new JTextField(20);     //créer un champ de text qui peut prendre 20 caracteres
		btn=new JButton("Click here");//créer un bouton
		lbl=new JLabel("Ecrire votre nom ici");
		
		//ajoute des ecouteur d'evenement à notre button
		btn.addActionListener(this);
		
		//configuration d'un conteneur
		Container container=getContentPane();
		
		//config de notre Layout
		FlowLayout fl=new FlowLayout(FlowLayout.CENTER);
		fl.setHgap(10);
		fl.setVgap(50);
		
		//ajout de notre Layout dans notre container ainsi que notre champ de saisi et bouton
		container.setLayout(fl);
		container.add(lbl);
		container.add(inputField);
		container.add(btn);
		
		
		//config frame
		setSize(new Dimension(400,400));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	//actionPerformed
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
			
			//recuperation du text saisi dans le JTextField (inputField)
			String inputText=inputField.getText(); 
			JOptionPane.showMessageDialog(btn, "Bienvenu : "+inputText);
		}
	}
	
	
	
}
