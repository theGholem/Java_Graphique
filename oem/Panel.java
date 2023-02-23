package fr.oem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Panel {

	public static void main(String[]args) {
		//creation of main window
		JFrame myWindow=new JFrame("ManyPanel");
		myWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myWindow.setSize(new Dimension(400,400));
		
		//creation of panels
		JPanel panel1,panel2,panel3,panel4,panel5;
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		
		panel1.setBackground(new Color(0,255,0)); //Color.GREEN
		panel2.setBackground(new Color(255,0,0)); //Color.RED
		panel3.setBackground(new Color(0,0,255)); //Color.BLUE
		panel4.setBackground(new Color(50,150,200));
		panel1.setBackground(new Color(100,100,100));
		panel5.setBackground(new Color(0,255,100));
		
		// add component in panel
		panel1.add(new JTextArea("write here!!"));
		panel2.add(new JTextField("write here!!"));
		panel3.add(new JButton("click me!"));
		panel4.add(new JCheckBox("tick here!!"));
		panel1.add(new JRadioButton("YES"));
		panel1.add(new JRadioButton("NO"));
		
		//disposition on frame
		BorderLayout bl=new BorderLayout();
		bl.setHgap(2);
		bl.setVgap(2);
		
		//add panel in main window
		myWindow.add(panel1,bl.NORTH);
		myWindow.add(panel2,bl.SOUTH);
		myWindow.add(panel3,bl.WEST);
		myWindow.add(panel4,bl.EAST);
		
		// button with action
		JButton btn=new JButton("Click here");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input=JOptionPane.showInputDialog(panel5,"What's your name dude?","input1",JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(panel5,"Welcome "+input);
			}
		});
		panel5.add(btn);
		
		//add our button in window
		myWindow.add(panel5,bl.CENTER);
		
		
		
		//display window
		myWindow.setVisible(true);
				
		// apply look'and feel
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		}catch( Exception e) {
			System.err.println("Error while displaying : "+e.getMessage());
		}
	}
}
