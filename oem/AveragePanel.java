package fr.oem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AveragePanel {
	private double a,b,c;
	private String name;
	
	//constructor
	public AveragePanel(double a, double b, double c, String name ) {
		this.a=a;
		this.b=b;
		this.c=c;
		this.name=name;
	}
	
	
	//method that calculate the average
	public double Average() {
		return (this.a+2*this.b+2*this.c)/5;
	}
	
	//admit or not
	public Boolean AdmitOrNot() {
		if(this.Average()>=10.5) {
			
			//System.out.println("ADMIT");
			
			return true;
		}else {
			// System.out.println("REFUSÉ");
			 return false;
		}
	}
	
	
	//our main method
	public static void main(String[]args) throws Exception { 
		
		//my frame
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(new Dimension(500,500));
		
		//my panels
		JPanel panel0=new JPanel();
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		
		//my buttons
		JButton btn1=new JButton("Click here !!");
		
		//add action on btn1
		try {
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Scanner sc=new Scanner(System.in);
					InputStreamReader isr=new InputStreamReader(System.in);
					BufferedReader br=new BufferedReader(isr);
					
					String Input0=JOptionPane.showInputDialog(panel1,"Saisir votre nom svp : ","Average",JOptionPane.QUESTION_MESSAGE);
					JOptionPane.showMessageDialog(panel1,"Bienvenu "+Input0+"\nCeci vous permettra de savoir \nsi vous etes admis ou pas grace à vos notes." );
					String Input1=JOptionPane.showInputDialog(panel1,"Saisir votre 1ere note svp : ","Average",JOptionPane.QUESTION_MESSAGE);
					double n1=Double.parseDouble(Input1);
					String Input2=JOptionPane.showInputDialog(panel1,"Saisir votre 2eme note svp : ","Average",JOptionPane.QUESTION_MESSAGE);
					double n2=Double.parseDouble(Input2);
					String Input3=JOptionPane.showInputDialog(panel1,"Saisir votre 3eme note svp : ","Average",JOptionPane.QUESTION_MESSAGE);
					double n3=Double.parseDouble(Input3);
					
					AveragePanel inf=new AveragePanel(n1,n2,n3,Input0);
					
					String rst=inf.AdmitOrNot()==true?"ADMIT":"REFUSÉ";
					/*
					 * String rst=null
					 * if(info.AdmitOrNot){
					 * 	rst="ADMIT";
					 * }else{
					 * 	rst="REFUSÉ";
					 * }
					 */
					
					JOptionPane.showMessageDialog(panel1,"MOYENNE : "+inf.Average());
					JOptionPane.showMessageDialog(panel1,"DECISION : "+rst);
					//inf.Display();
					
					
				}
			});
		}catch(Exception e) {
			System.err.println("Error :"+e.getMessage());
		}
		
		//add btn1 in panel1
		panel1.setBackground(new Color(200,0,0));
		panel1.add(btn1);
		
		//add component on panel2
		panel2.setBackground(new Color(0,200,0));
		panel2.add(new JButton("Push"));
		panel2.add(new JRadioButton("YES"));
		panel2.add(new JRadioButton("NO"));
		panel2.add(new JTextField("Saisir ici"));
		/*
		//save text into TextArea and display it
		ActionListener al=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg=JOptionPane.showInputDialog(panel2,"Saisir votre text ici svp : \n");
				JOptionPane.showMessageDialog(panel2,"vous avez saisi : "+msg);
			}
		};
		*/
		
		//disposition on frame
		GridLayout gl=new GridLayout(1,2);
		gl.setHgap(20);
		gl.setVgap(20);
			
		//add panel1 & panel2 in panel0
		panel0.add(panel1);
		panel0.add(panel2);
		
		//add on frame
		frame.setContentPane(panel0);
	}

}
