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
import javax.swing.JComboBox;

public class examples {

	private JFrame frmLogin;
	private JTextField textnom;
	private JTextField textprenom;
	private JTextField textcourriel;

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
		frmLogin.setTitle("Enseignant");
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		comboBox.setBounds(197, 107, 497, 34);
		frmLogin.getContentPane().add(comboBox);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Calibri", Font.BOLD, 17));
		btnModifier.setBounds(197, 431, 177, 34);
		frmLogin.getContentPane().add(btnModifier);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAnnuler.setBounds(513, 430, 177, 34);
		frmLogin.getContentPane().add(btnAnnuler);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Arial", Font.BOLD, 17));
		lblNom.setBounds(197, 204, 84, 34);
		frmLogin.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom: ");
		lblPrenom.setFont(new Font("Arial", Font.BOLD, 17));
		lblPrenom.setBounds(197, 269, 84, 34);
		frmLogin.getContentPane().add(lblPrenom);
		
		JLabel lblCourriel = new JLabel("Courriel:");
		lblCourriel.setFont(new Font("Arial", Font.BOLD, 17));
		lblCourriel.setBounds(197, 332, 84, 34);
		frmLogin.getContentPane().add(lblCourriel);
		
		textnom = new JTextField();
		textnom.setBounds(417, 208, 277, 29);
		frmLogin.getContentPane().add(textnom);
		textnom.setColumns(10);
		
		textprenom = new JTextField();
		textprenom.setColumns(10);
		textprenom.setBounds(417, 276, 277, 29);
		frmLogin.getContentPane().add(textprenom);
		
		textcourriel = new JTextField();
		textcourriel.setColumns(10);
		textcourriel.setBounds(417, 339, 277, 29);
		frmLogin.getContentPane().add(textcourriel);
		String filename="./lib/tests.jpg";
		frmLogin.setBackground(new Color(255, 255, 255));
		frmLogin.setForeground(new Color(135, 206, 235));
		frmLogin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmLogin.setType(Type.UTILITY);
		frmLogin.setBounds(100, 100, 877, 651);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
