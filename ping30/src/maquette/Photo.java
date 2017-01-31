package maquette;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ping30.Cours;

public class Photo extends JFrame implements ActionListener {

   
 
 	private JTextField textField;

 		

 	/**
 	 * Create the application.
 	 */
 	public Photo() {
 		
 	}
 	public Photo(Cours cours) {
 		JPanel panel = new JPanel();
 		panel.setBounds(0, 0, 800, 900);
 		this.add(panel);
 		panel.setLayout(null);
 		
 		JButton btnNewButton = new JButton("prendre photo");
 		btnNewButton.setBounds(22, 59, 103, 25);
 		panel.add(btnNewButton);
 		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
 		
 		JButton btnNewButton_1 = new JButton("reprendre photo");
 		btnNewButton_1.setBounds(22, 112, 103, 25);
 		panel.add(btnNewButton_1);
 		
 		JButton btnNewButton_2 = new JButton("comparation");
 		btnNewButton_2.setBounds(22, 163, 103, 25);
 		panel.add(btnNewButton_2);
 		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(cours);
				dispose();
				Absenntttt absenntttt = new Absenntttt(cours);
				absenntttt.setVisible(true);
			}
		});
 		
 		textField = new JTextField();
 		textField.setBounds(137, 16, 284, 231);
 		panel.add(textField);
 		textField.setColumns(10);
 		this.setForeground(new Color(0, 0, 0));
 		this.setBackground(Color.WHITE);
 		this.setBounds(100, 100, 450, 300);
 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		this.getContentPane().setLayout(null);
 		this.setTitle("sadasdsas");
 	    this.setVisible(true);  
 	    this.setResizable(true);  
 	}

 	private void connection(){
 		String hostname = "10.3.0.74";
 		String username = "pi";
 		String pwd = "raspberry";
 		try {
 		//	Connection myConnection = new Connection(hostname);
 		}
 		catch(Exception e){}
 	}
 	
 /*
 	public static void main(String[] args) {
 		Cours cours = new Cours();
 		Photo p = new Photo(cours);
		
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		
	}

}
