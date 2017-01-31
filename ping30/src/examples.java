import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;
import java.awt.Choice;
import javax.swing.JTextPane;

public class examples {

	private JFrame frmLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					examples window = new examples();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public examples() {
		initialize();
	}

	/**
	 * 
	 * 
	 * 		String stringss[];
	 * 
	 * 		int length=stringss.length();
	 * 
	 * 		for(int i =0;i<length;i++){
	 * 
	 * 		sprintf(nom_fichier[i],stirngss[i]);
	 * }
	 * 
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JLabel lblNewLabel = new JLabel("John Doe");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 36));
		lblNewLabel.setBounds(12, 11, 248, 33);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblCourJavaframeworkGroupe = new JLabel("Cours: JavaFramework  Groupe: ISN");
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
