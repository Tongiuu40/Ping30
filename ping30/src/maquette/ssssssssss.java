package maquette;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JCheckBox;

import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JButton;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JPasswordField;

public class ssssssssss extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ssssssssss frame = new ssssssssss();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ssssssssss() {
		setType(Type.UTILITY);
		setTitle("Ajouter Enseignant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 623);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNom.setBounds(84, 135, 134, 16);
		contentPane.add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(230, 132, 485, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom:");
		lblPrenom.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPrenom.setBounds(84, 200, 117, 16);
		contentPane.add(lblPrenom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(230, 197, 485, 28);
		contentPane.add(textField_1);
		
		JLabel lblCourriel = new JLabel("Courriel:");
		lblCourriel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblCourriel.setBounds(84, 269, 117, 16);
		contentPane.add(lblCourriel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(230, 266, 485, 28);
		contentPane.add(textField_2);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe:");
		lblMotDePasse.setFont(new Font("Calibri", Font.BOLD, 15));
		lblMotDePasse.setBounds(84, 332, 117, 16);
		contentPane.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 328, 485, 28);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Enseigner");
		btnNewButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 16));
		btnNewButton.setBounds(193, 459, 162, 34);
		contentPane.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 16));
		btnAnnuler.setBounds(469, 459, 162, 34);
		contentPane.add(btnAnnuler);
	}
}
