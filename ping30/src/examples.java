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
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setTitle("Etudiant");
		String filename="./lib/tests.jpg";
		frmLogin.setBackground(new Color(255, 255, 255));
		frmLogin.setForeground(new Color(135, 206, 235));
		frmLogin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmLogin.setType(Type.UTILITY);
		frmLogin.setBounds(100, 100, 877, 651);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblCreerEtudiant = new JLabel("Supprimer Etudiant");
		lblCreerEtudiant.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCreerEtudiant.setBounds(12, 22, 162, 45);
		frmLogin.getContentPane().add(lblCreerEtudiant);
		
		JComboBox etudiantchoix = new JComboBox();
		etudiantchoix.setBounds(363, 275, 305, 26);
		frmLogin.getContentPane().add(etudiantchoix);
		
		JComboBox groupchoix = new JComboBox();
		groupchoix.setBounds(363, 154, 305, 26);
		frmLogin.getContentPane().add(groupchoix);
		
		JLabel label = new JLabel("Groupe:");
		label.setFont(new Font("Calibri", Font.BOLD, 16));
		label.setBounds(191, 153, 107, 30);
		frmLogin.getContentPane().add(label);
		
		JLabel lblEtudiant = new JLabel("Etudiant:");
		lblEtudiant.setFont(new Font("Calibri", Font.BOLD, 16));
		lblEtudiant.setBounds(191, 274, 77, 30);
		frmLogin.getContentPane().add(lblEtudiant);
		
		JButton btnNewButton = new JButton("Enseigner");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 17));
		btnNewButton.setBounds(168, 450, 203, 30);
		frmLogin.getContentPane().add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Calibri", Font.BOLD, 17));
		btnAnnuler.setBounds(513, 450, 203, 30);
		frmLogin.getContentPane().add(btnAnnuler);
		
		
	}
}
