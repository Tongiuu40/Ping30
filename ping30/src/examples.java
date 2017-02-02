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
import javax.swing.JTable;

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
		frmLogin.setTitle("Listes");
		String filename="./lib/tests.jpg";
		frmLogin.setBackground(new Color(255, 255, 255));
		frmLogin.setForeground(new Color(135, 206, 235));
		frmLogin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmLogin.setType(Type.UTILITY);
		frmLogin.setBounds(100, 100, 884, 524);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(251, 102, 394, 31);
		frmLogin.getContentPane().add(comboBox);
		
		JButton btnEnseigner = new JButton("Modifier");
		btnEnseigner.setBounds(210, 384, 169, 31);
		frmLogin.getContentPane().add(btnEnseigner);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(511, 384, 169, 31);
		frmLogin.getContentPane().add(btnAnnuler);
		
		JLabel lblEtudiant = new JLabel("Listes");
		lblEtudiant.setBounds(120, 109, 63, 16);
		frmLogin.getContentPane().add(lblEtudiant);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setBounds(210, 170, 388, 31);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setFont(new Font("Calibri", Font.BOLD, 16));
		label.setBounds(210, 223, 388, 31);
		frmLogin.getContentPane().add(label);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Calibri", Font.BOLD, 16));
		lblStatus.setBounds(210, 281, 155, 31);
		frmLogin.getContentPane().add(lblStatus);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(468, 275, 177, 31);
		frmLogin.getContentPane().add(comboBox_1);
		
		
	}
}
