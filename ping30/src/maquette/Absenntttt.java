package maquette;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import DAO.CoursDAO;
import DAO.PresenceEtudiantDAO;
import ping30.Cours;
import ping30.PresenceEtudiant;

public class Absenntttt extends JFrame{
	private JPanel contentPane;
	private JTable table;
/*	public static void main(String[] args) {
		CoursDAO ss =new CoursDAO();
		Cours sCours = ss.find(1);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Absenntttt frame = new Absenntttt(sCours);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public Absenntttt(Cours courschoix){
		setTitle("Liste d'etudiants");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		PresenceEtudiantDAO ssDao = new PresenceEtudiantDAO();
		ArrayList<PresenceEtudiant> arrayList =new ArrayList<PresenceEtudiant>();
		arrayList = ssDao.findbycours(courschoix.getIdCours());
		Object[][] ssss;
		
		String[] title = {"Nom","Prenom","Presence","Date"};
	
		String[][] ssObjects={{"Nom","Prenom","Presence","Date"},{"Nom","Prenom","Presence","Date"}};
		table = new JTable(ssObjects,title);
		table.setBounds(298, 11, 535, 559);
		contentPane.add(table);
		
		JLabel lblNomPrenom = new JLabel(courschoix.getNomCours());
		lblNomPrenom.setBounds(12, 27, 161, 40);
		contentPane.add(lblNomPrenom);
	}

}
