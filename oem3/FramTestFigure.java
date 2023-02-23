package fr.oem3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FramTestFigure extends JFrame implements ActionListener {
	
	public static void main(String[]args) {
		new FramTestFigure();
	}

	private JTextField jtf3,jtf4,jtf5;
	private JLabel jlb3,jlb4,jlb5;
	private JRadioButton jrb1,jrb2;
	private JButton btn1,btn2;
	
	public FramTestFigure() {
		
		jtf3=new JTextField(10);
		jtf4=new JTextField(10);
		jtf5=new JTextField(10);
		
		
		jlb3=new JLabel("Saisir la longueur");
		jlb4=new JLabel("Saisir la largeur");
		jlb5=new JLabel("Saisir le rayon");
		
		jrb1=new JRadioButton("RECTANGLE");
		jrb2=new JRadioButton("CERCLE");
		
		btn1=new JButton("PUSH");
		btn2=new JButton("PUSH");
		
		jrb1.addActionListener(this);
		jrb2.addActionListener(this);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		Container cnt=getContentPane();
		
		FlowLayout fl=new FlowLayout();
		fl.setHgap(20);
		
		cnt.setLayout(fl);
		
		cnt.add(jrb1);
		cnt.add(jrb2);
		cnt.setBackground(Color.orange);
		setSize(new Dimension(300,300));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jrb1) {
			
			Container cnt2=getContentPane();
	
			cnt2.add(jlb3);
			cnt2.add(jtf3);
			cnt2.add(jlb4);
			cnt2.add(jtf4);
			cnt2.add(btn1);
			
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					String inputText1=jtf3.getText();
					double n1=Double.parseDouble(inputText1);
					String inputText2=jtf4.getText();
					double n2=Double.parseDouble(inputText1);
					
					Rectangle inf1=new Rectangle(n1,n2);
					JOptionPane.showMessageDialog(btn1, "INFO RECTANGLE\nPerimetre : "+inf1.Perimetre()+" m"+"\nAire : "+inf1.Surface()+" m²");
				
				}
			});
			
			
			
		}else if(e.getSource()==jrb2) {
			Container cnt3=getContentPane();
			
			cnt3.add(jlb5);
			cnt3.add(jtf5);
			cnt3.add(btn2);
			
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					String inputText1=jtf3.getText();
					double n=Double.parseDouble(inputText1);
					
					Cercle inf2=new Cercle(n);
					JOptionPane.showMessageDialog(btn1, "INFO Cercle\nPerimetre : "+inf2.Perimetre()+" m"+"\nAire : "+inf2.Surface()+" m²");
				
				}
			});
		}
	}
	
	
}
