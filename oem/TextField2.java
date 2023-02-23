package fr.oem;

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
import javax.swing.JTextField;

public class TextField2 extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//main class
	public static void main(String[]args)throws Exception {
			new TextField2();
	}

	private JTextField jtf;
	private JButton btn;
	private JLabel lbl1,lbl2;
	private int rst=100;
	
	//constructor
	public TextField2() {
		jtf=new JTextField(9);
		btn=new JButton("test here");
		lbl1=new JLabel("Ecrire le nombre à tester ici svp");
		lbl2=new JLabel(" <= "+rst);
		
		btn.addActionListener(this);
		
		Container cnt=getContentPane();
		
		FlowLayout fl=new FlowLayout(FlowLayout.LEFT);
		fl.setHgap(10);
		
		cnt.setLayout(fl);
		cnt.add(lbl1);
		cnt.add(jtf);
		cnt.add(lbl2);
		cnt.add(btn);
		cnt.setBackground(Color.ORANGE); //add background
		
		
		
		setSize(new Dimension(300,300));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==btn) {
					
					String InputNumber=jtf.getText();
					int number=Integer.parseInt(InputNumber);
					
							if(number<=100) {
								JOptionPane.showMessageDialog(btn," C'est nice , vous avez respecté bien la consignes" );
							}else{
								JOptionPane.showMessageDialog(btn,number+" > "+rst+"\nVeuillez respecter la consigne svp");
							}
					}
					
	}
	
	
}
