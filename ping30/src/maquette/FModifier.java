package maquette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DAO.CoursDAO;
import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import DAO.PresenceEtudiantDAO;
import DAO.SalleDAO;
import ping30.Cours;
import ping30.DateLabelFormatter;
import ping30.Enseignant;
import ping30.Etudiant;
import ping30.Main;
import ping30.PresenceEtudiant;
import ping30.Salle;

public class FModifier extends JFrame implements ItemListener,ActionListener {
	JPanel contentPane = new JPanel();
	private JTextField textField;
	JTextField txtSss ;

	
	Salle newSalle = new Salle();
	SalleDAO mSalleDAO = new SalleDAO();
	Cours newCour = new Cours();
	CoursDAO mCoursDAO =  new CoursDAO();
	Etudiant newEtudiant = new Etudiant();
	EtudiantDAO mEtudiantDAO = new EtudiantDAO();
	Enseignant newEnseignant = new Enseignant();
	EnseignantDAO mEnseignantDAO = new EnseignantDAO();
	PresenceEtudiant nPresenceEtudiant = new PresenceEtudiant();
	PresenceEtudiantDAO mPresenceEtudiantDAO = new PresenceEtudiantDAO();

	
	public FModifier(){
		
	}

	public void CrFCours(){
		
	setTitle("Creer Cours");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 560, 416);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	
	
	
	
	JLabel lblCours = new JLabel("Cours:");
	lblCours.setBounds(5, 91, 81, 16);
	contentPane.add(lblCours);
	
	textField = new JTextField();
	textField.setBounds(128, 88, 404, 22);
	contentPane.add(textField);
	textField.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("Enseignant");
	lblNewLabel_1.setBounds(5, 144, 94, 16);
	contentPane.add(lblNewLabel_1);
	
	JComboBox comboBox_1 = new JComboBox();
	comboBox_1.setBounds(128, 141, 404, 22);
	contentPane.add(comboBox_1);
	
	JLabel lblSalle = new JLabel("Salle");
	lblSalle.setBounds(5, 198, 63, 16);
	contentPane.add(lblSalle);
	
	JComboBox comboBox_2 = new JComboBox();
	comboBox_2.setBounds(128, 195, 404, 22);
	contentPane.add(comboBox_2);
	
	JLabel lblDate = new JLabel("Date");
	lblDate.setBounds(5, 251, 63, 16);
	contentPane.add(lblDate);
	
	/*JComboBox comboBox_3 = new JComboBox();
	comboBox_3.setBounds(128, 248, 404, 22);
	contentPane.add(comboBox_3);*/
	
	
			
	UtilDateModel model = new UtilDateModel();
	Properties p = new Properties();
	
	JDatePanelImpl hDatePanelImpl = new JDatePanelImpl(model, p);
	JDatePickerImpl datePicker = new JDatePickerImpl(hDatePanelImpl, new DateLabelFormatter());
	datePicker.setBounds(128, 248, 404, 22);
	contentPane.add(datePicker);
	
	
	JButton btnEnseigner = new JButton("Enseigner");
	btnEnseigner.setBounds(265, 317, 103, 25);
	contentPane.add(btnEnseigner);
	btnEnseigner.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			newCour = new Cours();
			String newname = textField.getText();
			
			String newprof = (String) comboBox_1.getSelectedItem();
			String[] ssString =newprof.split(" ");
			newEnseignant=mEnseignantDAO.findname(ssString[0], ssString[1]);
			String thissalle =(String) comboBox_2.getSelectedItem();
			newSalle=mSalleDAO.findnom(thissalle);			
			String newday=datePicker.getJFormattedTextField().getText();			
			String idonttrust[] = newday.split("-");
			Date myDate = new Date(Integer.valueOf(idonttrust[0])-1900,Integer.valueOf(idonttrust[1])-1, Integer.valueOf(idonttrust[2]));
			
			newCour.setNomCours(newname);
			newCour.setIdEnseignant(newEnseignant.getIdEnseignant());
			newCour.setIdSalle(newSalle.getIdSalle());
			newCour.setDateCours(myDate);
			System.out.println(newCour);
			newCour.setDateCours(myDate);
			mCoursDAO.create(newCour);
		}
	});
	
	JButton btnAnnuler = new JButton("Annuler");
	btnAnnuler.setBounds(388, 317, 103, 25);
	contentPane.add(btnAnnuler);
	btnAnnuler.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	});


	ArrayList<Enseignant> listEN = new ArrayList<Enseignant>();
	 EnseignantDAO enDao = new EnseignantDAO();
	 listEN = enDao.getAll();
	 for (Enseignant enseignant : listEN){
		 comboBox_1.addItem(enseignant.getNomEnseignant()+" "+enseignant.getPrenomEnseignant());
		 
	 }
	 
	 ArrayList<Salle> listSalle = new ArrayList<Salle>();
	 SalleDAO salleDAO = new SalleDAO();
	 listSalle = salleDAO.getAll();
	 for (Salle salle:listSalle){
		 comboBox_2.addItem(salle.getNomSalle());
	 }
	 
	 
	}
	public void SupFCours(){
	
		setTitle("Supperimer Cours");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Cours Info");
		lblNewLabel.setBounds(42, 166, 462, 83);
		contentPane.add(lblNewLabel);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(42, 112, 462, 33);
		contentPane.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				  if(e.getStateChange() == ItemEvent.SELECTED)
		             {
					  	Cours thicours = (Cours) comboBox.getSelectedItem();
					  	lblNewLabel.setText(
					  			thicours.getNomCours()+" \n"+mEnseignantDAO.find(thicours.getIdEnseignant()).getNomEnseignant()
					  			+" "+mEnseignantDAO.find(thicours.getIdEnseignant()).getNomEnseignant()
					  			+" \n"+mSalleDAO.find(thicours.getIdSalle()).getNomSalle()+" \n"+thicours.getDateCours()
					  			
					  			);
		             }	
				  
			}
		});
		
		ArrayList<Cours> myCours = new ArrayList<Cours>();
		try {
			myCours =mCoursDAO.getAll();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (Cours cours : myCours) {
			comboBox.addItem(cours);
			
		}
		
		JButton btnSupperimer = new JButton("Supperimer");
		btnSupperimer.setBounds(265, 317, 103, 25);
		contentPane.add(btnSupperimer);
		btnSupperimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Cours scours =(Cours) comboBox.getSelectedItem();
				mCoursDAO.delete(scours);
				
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(388, 317, 103, 25);
		contentPane.add(btnAnnuler);
		
		JLabel lblSalle = new JLabel("Cours");
		lblSalle.setBounds(42, 69, 63, 16);
		contentPane.add(lblSalle);
		
	
	}

	public void CFModCours() throws ParseException{
		setTitle("Modifier Cours");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cours");
		lblNewLabel.setBounds(5, 23, 35, 16);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(5, 40, 527, 22);
		contentPane.add(comboBox);
		
		JLabel lblCours = new JLabel("Cours:");
		lblCours.setBounds(5, 91, 81, 16);
		contentPane.add(lblCours);
		
		textField = new JTextField();
		textField.setBounds(128, 88, 404, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enseignant");
		lblNewLabel_1.setBounds(5, 144, 94, 16);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(128, 141, 404, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblSalle = new JLabel("Salle");
		lblSalle.setBounds(5, 198, 63, 16);
		contentPane.add(lblSalle);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(128, 195, 404, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(5, 251, 63, 16);
		contentPane.add(lblDate);
		
		/*JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(128, 248, 404, 22);
		contentPane.add(comboBox_3);*/
		
		
				
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		
		JDatePanelImpl hDatePanelImpl = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(hDatePanelImpl, new DateLabelFormatter());
		datePicker.setBounds(128, 248, 404, 22);
		contentPane.add(datePicker);
		
		
		JButton btnEnseigner = new JButton("Enseigner");
		btnEnseigner.setBounds(265, 317, 103, 25);
		contentPane.add(btnEnseigner);
		btnEnseigner.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String newname = textField.getText();
				newCour =(Cours) comboBox.getSelectedItem();
				String newprof = (String) comboBox_1.getSelectedItem();
				String[] ssString =newprof.split(" ");
				newEnseignant=mEnseignantDAO.findname(ssString[0], ssString[1]);
				String thissalle =(String) comboBox_2.getSelectedItem();
				newSalle=mSalleDAO.findnom(thissalle);			
				String newday=datePicker.getJFormattedTextField().getText();			
				String idonttrust[] = newday.split("-");
						
				newCour.setNomCours(newname);
				newCour.setIdEnseignant(newEnseignant.getIdEnseignant());
				newCour.setIdSalle(newSalle.getIdSalle());
				//newCour.setDateCours(newdate);
				mCoursDAO.update(newCour);
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(388, 317, 103, 25);
		contentPane.add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		JLabel lblNewLabel_2 = new JLabel("Time");
		lblNewLabel_2.setBounds(125, 228, 407, 16);
		contentPane.add(lblNewLabel_2);
		
		 ArrayList<Cours> listcours = new ArrayList<Cours>();
		 CoursDAO coursDAO = new CoursDAO();
		 listcours = coursDAO.getAll();
		   for (Cours cours : listcours) {
	        comboBox.addItem(cours);  
	       
	    	 comboBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					  if(e.getStateChange() == ItemEvent.SELECTED)
			             {
						  Cours co = (Cours) comboBox.getSelectedItem();
						  textField.setText(co.getNomCours());
			               // comboBox_3.setSelectedItem(co.getDateCours());
						 
						  Enseignant ssEnseignant = mEnseignantDAO.find(co.getIdEnseignant());
						  comboBox_1.setSelectedItem(ssEnseignant.getNomEnseignant()+" "+ssEnseignant.getPrenomEnseignant());
						  Salle salle = mSalleDAO.find(co.getIdSalle());
						  comboBox_2.setSelectedItem(salle.getNomSalle());
						
						  String newdate = co.getDateCours().toString();
						  String[] parts=newdate.split("-");
						
						  datePicker.getModel().setDate(Integer.valueOf(parts[0]),Integer.valueOf(parts[1])-1,Integer.valueOf(parts[2]));
						  datePicker.getModel().setSelected(true);
			             }
				}
			});
			}
		 
		ArrayList<Enseignant> listEN = new ArrayList<Enseignant>();
		 EnseignantDAO enDao = new EnseignantDAO();
		 listEN = enDao.getAll();
		 for (Enseignant enseignant : listEN){
			 comboBox_1.addItem(enseignant.getNomEnseignant()+" "+enseignant.getPrenomEnseignant());
			 
		 }
		 
		 ArrayList<Salle> listSalle = new ArrayList<Salle>();
		 SalleDAO salleDAO = new SalleDAO();
		 listSalle = salleDAO.getAll();
		 for (Salle salle:listSalle){
			 comboBox_2.addItem(salle.getNomSalle());
		 }
		 
		 
		
	}
	
	public static void main(String[] args) throws ParseException {
		FModifier fModifier = new FModifier();
		fModifier.CFModCours();
		fModifier.setVisible(true);
	}
	
   

	
	public Salle CrSalle(){
	
		setTitle("Creer une Salle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(42, 112, 462, 33);
		contentPane.add(comboBox);
		ArrayList<Salle> listsalle = new ArrayList<Salle>();
		listsalle=mSalleDAO.getAll();
		 txtSss = new JTextField();
		txtSss.setFont(new Font("����", Font.PLAIN, 17));
		txtSss.setText("");
		txtSss.setBounds(40, 175, 462, 39);
		contentPane.add(txtSss);
		txtSss.setColumns(10);
		for (Salle salle : listsalle) {
			comboBox.addItem(salle);
			comboBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					 if(e.getStateChange() == ItemEvent.SELECTED)
		             {
			
		             }
				}
			});
		}
		
		JButton btnEnseigner = new JButton("Creer");
		btnEnseigner.setBounds(265, 317, 103, 25);
		contentPane.add(btnEnseigner);
		btnEnseigner.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nsalle = txtSss.getText();
				Salle salle =new Salle();
				salle.setNomSalle(nsalle);
				mSalleDAO.create(salle);
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(388, 317, 103, 25);
		contentPane.add(btnAnnuler);
		
		JLabel lblSalle = new JLabel("Salle:");
		lblSalle.setBounds(42, 69, 63, 16);
		contentPane.add(lblSalle);
		
		
		
		mSalleDAO.update(newSalle);
		return newSalle;
	}
	public void SupSalle(){
	
		
		setTitle("Supprimer Salle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(42, 112, 462, 33);
		contentPane.add(comboBox);
		ArrayList<Salle> listsalle = new ArrayList<Salle>();
		listsalle=mSalleDAO.getAll();
		
		for (Salle salle : listsalle) {
			comboBox.addItem(salle);
			comboBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					 if(e.getStateChange() == ItemEvent.SELECTED)
		             {
					  Salle sa = (Salle) comboBox.getSelectedItem();
					
		               // comboBox_3.setSelectedItem(co.getDateCours());
					
		             }
				}
			});
		}
		
		JButton btnEnseigner = new JButton("Supprimer");
		btnEnseigner.setBounds(265, 317, 103, 25);
		contentPane.add(btnEnseigner);
		btnEnseigner.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				Salle salle =(Salle) comboBox.getSelectedItem();
			
				mSalleDAO.delete(salle);
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(388, 317, 103, 25);
		contentPane.add(btnAnnuler);
		
		JLabel lblSalle = new JLabel("Salle:");
		lblSalle.setBounds(42, 69, 63, 16);
		contentPane.add(lblSalle);
		
	}
	public Salle CFModSalle(){
		
		setTitle("Modifier Salle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(42, 112, 462, 33);
		contentPane.add(comboBox);
		ArrayList<Salle> listsalle = new ArrayList<Salle>();
		listsalle=mSalleDAO.getAll();
		 txtSss = new JTextField();
		txtSss.setFont(new Font("����", Font.PLAIN, 17));
		txtSss.setText("");
		txtSss.setBounds(40, 175, 462, 39);
		contentPane.add(txtSss);
		txtSss.setColumns(10);
		for (Salle salle : listsalle) {
			comboBox.addItem(salle);
			comboBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					 if(e.getStateChange() == ItemEvent.SELECTED)
		             {
					  Salle sa = (Salle) comboBox.getSelectedItem();
					  txtSss.setText(sa.getNomSalle());
		               // comboBox_3.setSelectedItem(co.getDateCours());
					
		             }
				}
			});
		}
		
		JButton btnEnseigner = new JButton("Enseigner");
		btnEnseigner.setBounds(265, 317, 103, 25);
		contentPane.add(btnEnseigner);
		btnEnseigner.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nsalle = txtSss.getText();
				Salle salle =(Salle) comboBox.getSelectedItem();
				salle.setNomSalle(nsalle);
				mSalleDAO.update(salle);
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(388, 317, 103, 25);
		contentPane.add(btnAnnuler);
		
		JLabel lblSalle = new JLabel("Salle:");
		lblSalle.setBounds(42, 69, 63, 16);
		contentPane.add(lblSalle);
		
		
		
		mSalleDAO.update(newSalle);
		return newSalle;
	}
	
	
	
	
	public Etudiant CrEtudiant(){
	
		mEtudiantDAO.create(newEtudiant);
		return newEtudiant;
	}
	public void SupEtudiant(){
	
		mEtudiantDAO.delete(newEtudiant);
	}
	public Etudiant ModEtudiant(){
		
		mEtudiantDAO.update(newEtudiant);
		return newEtudiant;
	}
	
	public Enseignant CrEnseignant(){
		 JTextField textField;
		 JTextField textField_1;
		 JTextField textField_2;
		 JPasswordField passwordField;
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
		mEnseignantDAO.create(newEnseignant);
		return newEnseignant;
	}
	public void SupEnseignant(){
		
		mEnseignantDAO.delete(newEnseignant);
	}
	public Enseignant ModEnseignant(){
		
		mEnseignantDAO.update(newEnseignant);
		return newEnseignant;
	}
	
	public PresenceEtudiant CrListe(){
	
		mPresenceEtudiantDAO.create(nPresenceEtudiant);
		return nPresenceEtudiant;
	}
	public void SupListe(){
		
		mPresenceEtudiantDAO.delete(nPresenceEtudiant);
	}
	public PresenceEtudiant ModListe(){
	
		mPresenceEtudiantDAO.update(nPresenceEtudiant);
		return nPresenceEtudiant;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
