import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class newmaquettes {
	JFrame frmLogin;
	 JTextField textField;
	 JTextField textField_1;
		 JTextField txtJohnDue;

	private void initializelogin() {
		frmLogin.setVisible(true);
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(255, 255, 255));
		frmLogin.setForeground(new Color(135, 206, 235));
		frmLogin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmLogin.setType(Type.UTILITY);
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 544, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(54, 34, 427, 52);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COMPTE");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 11, 83, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(130, 11, 285, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(54, 85, 427, 46);
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MOT DE PASSE");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(12, 11, 106, 16);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 8, 285, 22);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(54, 130, 427, 88);
		frmLogin.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("USER");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(49, 7, 137, 25);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("ADMIN");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(239, 7, 137, 25);
		panel_2.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(21, 45, 177, 32);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		btnNewButton_1.setIcon(null);
		btnNewButton_1.setBounds(238, 45, 177, 32);
		panel_2.add(btnNewButton_1);
	}
	private void initializepagepro() {
		
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(255, 255, 255));
		frmLogin.getContentPane().setLayout(null);
		
		txtJohnDue = new JTextField();
		txtJohnDue.setText("John Doe");
		txtJohnDue.setFont(new Font("Calibri", Font.BOLD, 36));
		txtJohnDue.setBounds(51, 52, 254, 38);
		frmLogin.getContentPane().add(txtJohnDue);
		txtJohnDue.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(93, 151, 525, 22);
		frmLogin.getContentPane().add(choice);
		choice.add("Cours 1 : Math   Date: 2016/11/11 9:30-12:30");
		choice.add("Cours 2 : Math   Date: 2016/11/11 15:30-17:30");
		choice.add("Cours 3: Math   Date: 2016/11/11 13:30-15:30");
		
		JButton btnNewButton = new JButton("SUIVANT");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton.setBounds(145, 287, 160, 25);
		frmLogin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DECONNEXION");
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton_1.setBounds(405, 287, 160, 25);
		frmLogin.getContentPane().add(btnNewButton_1);
		frmLogin.setBackground(new Color(255, 255, 255));
		frmLogin.setForeground(new Color(135, 206, 235));
		frmLogin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmLogin.setType(Type.UTILITY);
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 738, 485);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void initializephoto() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(255, 255, 255));
		frmLogin.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("SUIVANT");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton.setBounds(100, 530, 160, 25);
		frmLogin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DECONNEXION");
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton_1.setBounds(604, 530, 160, 25);
		frmLogin.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PRENDRE PHOTO");
		btnNewButton_2.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton_2.setBounds(351, 530, 160, 25);
		frmLogin.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("John Due");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 36));
		lblNewLabel.setBounds(12, 11, 248, 33);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblCourJavaframeworkGroupe = new JLabel("Cour: JavaFramework  Groupe: ISN");
		lblCourJavaframeworkGroupe.setBounds(109, 55, 534, 16);
		frmLogin.getContentPane().add(lblCourJavaframeworkGroupe);
		
		JLabel lblNewLabel_1 = new JLabel();
		String filename="./lib/tests.jpg";
		lblNewLabel_1.setBounds(63, 97, 740, 415);
			lblNewLabel_1.setIcon(new ImageIcon(filename));
		frmLogin.getContentPane().add(lblNewLabel_1);
		frmLogin.setBackground(new Color(255, 255, 255));
		frmLogin.setForeground(new Color(135, 206, 235));
		frmLogin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmLogin.setType(Type.UTILITY);
		frmLogin.setBounds(100, 100, 877, 651);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
