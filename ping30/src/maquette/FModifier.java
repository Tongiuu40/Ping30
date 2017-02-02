package maquette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
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
import DAO.GroupeEtudiantDAO;
import DAO.PresenceEtudiantDAO;
import DAO.SalleDAO;
import ping30.Cours;
import ping30.DateLabelFormatter;
import ping30.Enseignant;
import ping30.Etudiant;
import ping30.GroupeEtudiant;
import ping30.Main;
import ping30.PresenceEtudiant;
import ping30.Salle;

public class FModifier extends JFrame implements ItemListener,ActionListener {
	JPanel contentPane = new JPanel();
	private JTextField textField;
	JTextField txtSss ;

	int idg;
	Salle newSalle = new Salle();
	SalleDAO mSalleDAO = new SalleDAO();
	Cours newCour = new Cours();
	CoursDAO mCoursDAO =  new CoursDAO();
	Etudiant newEtudiant = new Etudiant();
	GroupeEtudiant groupeEtudiant=new GroupeEtudiant();
	EtudiantDAO mEtudiantDAO = new EtudiantDAO();
	Enseignant newEnseignant = new Enseignant();
	EnseignantDAO mEnseignantDAO = new EnseignantDAO();
	PresenceEtudiant nPresenceEtudiant = new PresenceEtudiant();
	PresenceEtudiantDAO mPresenceEtudiantDAO = new PresenceEtudiantDAO();
	GroupeEtudiantDAO mGroupeEtudiantDAO = new GroupeEtudiantDAO();
	
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
			dispose();
			  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
	    		myModifiers.setVisible(true);
				myModifiers.runTest();
	            
			
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
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
		            
			}
		});
		
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
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
		            
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
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
		            
			}
		});
		
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
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
			}
		});
		
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
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
			}
		});
		JLabel lblSalle = new JLabel("Salle:");
		lblSalle.setBounds(42, 69, 63, 16);
		contentPane.add(lblSalle);
		
		
		
		mSalleDAO.update(newSalle);
		return newSalle;
	}
	
	
	
	
	public Etudiant CrEtudiant(){
		 JFrame frmLogin;
		 JTextField tnom;
		 JTextField tprenom;
		 JTextField tinn;
		 JTextField tphoto;
		 
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
			
			JLabel lblNom = new JLabel("Nom:");
			lblNom.setFont(new Font("Calibri", Font.BOLD, 16));
			lblNom.setBounds(172, 147, 107, 30);
			frmLogin.getContentPane().add(lblNom);
			
			JLabel lblPrenom = new JLabel("Prenom:");
			lblPrenom.setFont(new Font("Calibri", Font.BOLD, 16));
			lblPrenom.setBounds(172, 200, 107, 30);
			frmLogin.getContentPane().add(lblPrenom);
			
			JLabel lblGroupe = new JLabel("Groupe:");
			lblGroupe.setFont(new Font("Calibri", Font.BOLD, 16));
			lblGroupe.setBounds(172, 254, 107, 30);
			frmLogin.getContentPane().add(lblGroupe);
			
			JLabel lblIneetudiant = new JLabel("INEEtudiant:");
			lblIneetudiant.setFont(new Font("Calibri", Font.BOLD, 16));
			lblIneetudiant.setBounds(172, 314, 107, 30);
			frmLogin.getContentPane().add(lblIneetudiant);
			
			JLabel lblCreerEtudiant = new JLabel("Créer Etudiant");
			lblCreerEtudiant.setFont(new Font("Calibri", Font.BOLD, 18));
			lblCreerEtudiant.setBounds(12, 22, 162, 45);
			frmLogin.getContentPane().add(lblCreerEtudiant);
			
			JLabel lblPhoto = new JLabel("Photo");
			lblPhoto.setFont(new Font("Calibri", Font.BOLD, 16));
			lblPhoto.setBounds(172, 374, 107, 30);
			frmLogin.getContentPane().add(lblPhoto);
			
			tnom = new JTextField();
			tnom.setFont(new Font("Calibri", Font.BOLD, 16));
			tnom.setBounds(405, 148, 327, 27);
			frmLogin.getContentPane().add(tnom);
			tnom.setColumns(10);
			
			tprenom = new JTextField();
			tprenom.setFont(new Font("Calibri", Font.BOLD, 16));
			tprenom.setColumns(10);
			tprenom.setBounds(405, 203, 327, 27);
			frmLogin.getContentPane().add(tprenom);
			
			tinn = new JTextField();
			tinn.setFont(new Font("Calibri", Font.BOLD, 16));
			tinn.setColumns(10);
			tinn.setBounds(405, 316, 327, 27);
			frmLogin.getContentPane().add(tinn);
			
			tphoto = new JTextField();
			tphoto.setFont(new Font("Calibri", Font.BOLD, 16));
			tphoto.setColumns(10);
			tphoto.setBounds(405, 377, 327, 27);
			frmLogin.getContentPane().add(tphoto);
			
			
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(405, 257, 327, 27);
			frmLogin.getContentPane().add(comboBox);
			ArrayList<GroupeEtudiant> listg = mGroupeEtudiantDAO.getAll();
			for (GroupeEtudiant groupeEtudiant : listg) {
				comboBox.addItem(groupeEtudiant);
			}
			
			JButton btnNewButton = new JButton("Enseigner");
			btnNewButton.setFont(new Font("Calibri", Font.BOLD, 17));
			btnNewButton.setBounds(172, 478, 203, 30);
			frmLogin.getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					groupeEtudiant=(GroupeEtudiant)comboBox.getSelectedItem();
					newEtudiant.setIdGroupeEtudiant(groupeEtudiant.getIdGroupeEtudiant());
					newEtudiant.setAdressePhoto(tphoto.getText());
					newEtudiant.setINEEtudiant(Integer.valueOf(tinn.getText()));
					newEtudiant.setNomEtudiant(tnom.getText());
					newEtudiant.setPrenomEtudiant(tprenom.getText());
					mEtudiantDAO.create(newEtudiant);
					
				}
			});
			
			JButton btnAnnuler = new JButton("Annuler");
			btnAnnuler.setFont(new Font("Calibri", Font.BOLD, 17));
			btnAnnuler.setBounds(513, 478, 203, 30);
			frmLogin.getContentPane().add(btnAnnuler);
			btnAnnuler.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
			    		myModifiers.setVisible(true);
						myModifiers.runTest();
				}
			});
			
			
			frmLogin.setVisible(true);
		return newEtudiant;
	}
	public void SupEtudiant(){
		 JFrame frmLogin;
	
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
		ArrayList<Etudiant> liste = mEtudiantDAO.getAll();
		for (Etudiant etudiants : liste) {
			etudiantchoix.addItem(etudiants);
		}
		etudiantchoix.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				newEtudiant=(Etudiant) etudiantchoix.getSelectedItem();
			}
		});
		
		JComboBox groupchoix = new JComboBox();
		groupchoix.setBounds(363, 154, 305, 26);
		frmLogin.getContentPane().add(groupchoix);
		ArrayList<GroupeEtudiant> listg = mGroupeEtudiantDAO.getAll();
		for (GroupeEtudiant groupeEtudiant : listg) {
			groupchoix.addItem(groupeEtudiant);
		}
		groupchoix.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				  if(e.getStateChange() == ItemEvent.SELECTED){
					  etudiantchoix.removeAllItems();
					  idg=((GroupeEtudiant) groupchoix.getSelectedItem()).getIdGroupeEtudiant();
					  ArrayList<Etudiant> liste = mEtudiantDAO.getbygroupe(idg);
					
					  for (Etudiant gEtudiant : liste) {
						  etudiantchoix.addItem(gEtudiant);
					}
				  }
				
			}
		});
		
		JLabel label = new JLabel("Groupe:");
		label.setFont(new Font("Calibri", Font.BOLD, 16));
		label.setBounds(191, 153, 107, 30);
		frmLogin.getContentPane().add(label);
		
		JLabel lblEtudiant = new JLabel("Etudiant:");
		lblEtudiant.setFont(new Font("Calibri", Font.BOLD, 16));
		lblEtudiant.setBounds(191, 274, 77, 30);
		frmLogin.getContentPane().add(lblEtudiant);
		
		JButton btnNewButton = new JButton("Supprimer");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 17));
		btnNewButton.setBounds(168, 450, 203, 30);
		frmLogin.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				mEtudiantDAO.delete(newEtudiant);
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Calibri", Font.BOLD, 17));
		btnAnnuler.setBounds(513, 450, 203, 30);
		frmLogin.getContentPane().add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
			}
		});
		
		frmLogin.setVisible(true);
	
	}
	public Etudiant ModEtudiant(){
		 JFrame frmLogin;
		 JTextField tnom;
		 JTextField tprenom;
		 JTextField tinn;
		 JTextField tphoto;
		 
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
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNom.setBounds(172, 194, 107, 30);
		frmLogin.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom:");
		lblPrenom.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPrenom.setBounds(172, 251, 107, 30);
		frmLogin.getContentPane().add(lblPrenom);
		
		JLabel lblGroupe = new JLabel("Groupe:");
		lblGroupe.setFont(new Font("Calibri", Font.BOLD, 16));
		lblGroupe.setBounds(172, 311, 107, 30);
		frmLogin.getContentPane().add(lblGroupe);
		
		JLabel lblIneetudiant = new JLabel("INEEtudiant:");
		lblIneetudiant.setFont(new Font("Calibri", Font.BOLD, 16));
		lblIneetudiant.setBounds(172, 368, 107, 30);
		frmLogin.getContentPane().add(lblIneetudiant);
		
		JLabel lblCreerEtudiant = new JLabel("Modifier Etudiant");
		lblCreerEtudiant.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCreerEtudiant.setBounds(12, 22, 162, 45);
		frmLogin.getContentPane().add(lblCreerEtudiant);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPhoto.setBounds(172, 424, 107, 30);
		frmLogin.getContentPane().add(lblPhoto);
		
		tnom = new JTextField();
		tnom.setFont(new Font("Calibri", Font.BOLD, 16));
		tnom.setBounds(405, 196, 327, 27);
		frmLogin.getContentPane().add(tnom);
		tnom.setColumns(10);
		
		tprenom = new JTextField();
		tprenom.setFont(new Font("Calibri", Font.BOLD, 16));
		tprenom.setColumns(10);
		tprenom.setBounds(405, 253, 327, 27);
		frmLogin.getContentPane().add(tprenom);
		
		tinn = new JTextField();
		tinn.setFont(new Font("Calibri", Font.BOLD, 16));
		tinn.setColumns(10);
		tinn.setBounds(405, 370, 327, 27);
		frmLogin.getContentPane().add(tinn);
		
		tphoto = new JTextField();
		tphoto.setFont(new Font("Calibri", Font.BOLD, 16));
		tphoto.setColumns(10);
		tphoto.setBounds(405, 426, 327, 27);
		frmLogin.getContentPane().add(tphoto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(405, 312, 327, 27);
		frmLogin.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 17));
		btnNewButton.setBounds(172, 516, 203, 30);
		frmLogin.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newEtudiant.setAdressePhoto(tphoto.getText());
				newEtudiant.setNomEtudiant(tnom.getText());
				newEtudiant.setPrenomEtudiant(tprenom.getText());
				newEtudiant.setINEEtudiant(Integer.valueOf(tinn.getText()));
				newEtudiant.setIdGroupeEtudiant(((Etudiant)comboBox.getSelectedItem()).getIdGroupeEtudiant());
				
				mEtudiantDAO.update(newEtudiant);
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Calibri", Font.BOLD, 17));
		btnAnnuler.setBounds(516, 516, 203, 30);
		frmLogin.getContentPane().add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
			}
		});
		
		JComboBox etudiantchoix = new JComboBox();
		etudiantchoix.setBounds(489, 82, 227, 26);
		frmLogin.getContentPane().add(etudiantchoix);
		ArrayList<Etudiant> liste = mEtudiantDAO.getAll();
		for (Etudiant etudiants : liste) {
			etudiantchoix.addItem(etudiants);
		}
		etudiantchoix.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				tnom.setText(((Etudiant)etudiantchoix.getSelectedItem()).getNomEtudiant());
				tinn.setText(((Etudiant)etudiantchoix.getSelectedItem()).getINEEtudiant()+"");
				tprenom.setText(((Etudiant)etudiantchoix.getSelectedItem()).getPrenomEtudiant());
				tphoto.setText(((Etudiant)etudiantchoix.getSelectedItem()).getAdressePhoto());
			}
		});
		
		JComboBox groupchoix = new JComboBox();
		groupchoix.setBounds(128, 82, 230, 26);
		frmLogin.getContentPane().add(groupchoix);
		ArrayList<GroupeEtudiant> listg = mGroupeEtudiantDAO.getAll();
		for (GroupeEtudiant groupeEtudiant : listg) {
			groupchoix.addItem(groupeEtudiant);
		}
		groupchoix.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				  if(e.getStateChange() == ItemEvent.SELECTED){
					  etudiantchoix.removeAllItems();
					  idg=((GroupeEtudiant) groupchoix.getSelectedItem()).getIdGroupeEtudiant();
					  ArrayList<Etudiant> liste = mEtudiantDAO.getbygroupe(idg);
					
					  for (Etudiant gEtudiant : liste) {
						  etudiantchoix.addItem(gEtudiant);
					}
				  }
				
			}
		});
		
		
		JLabel label = new JLabel("Groupe:");
		label.setFont(new Font("Calibri", Font.BOLD, 16));
		label.setBounds(40, 81, 107, 30);
		frmLogin.getContentPane().add(label);
		
		JLabel lblEtudiant = new JLabel("Etudiant:");
		lblEtudiant.setFont(new Font("Calibri", Font.BOLD, 16));
		lblEtudiant.setBounds(392, 81, 77, 30);
		frmLogin.getContentPane().add(lblEtudiant);
		
		frmLogin.setVisible(true);
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
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nom = textField.getText();
				String prenom = textField_1.getText();
				String courriel = textField_2.getText();
				String pwd = passwordField.getText();
				System.out.println(nom+prenom+courriel+pwd);
				newEnseignant = new Enseignant(nom,prenom, courriel, pwd);
				mEnseignantDAO.create(newEnseignant);
				
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 16));
		btnAnnuler.setBounds(469, 459, 162, 34);
		contentPane.add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
			}
		});
		return newEnseignant;
	}
	public void SupEnseignant(){
		JFrame frmLogin;

		frmLogin = new JFrame();
		frmLogin.setTitle("Enseignant");
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(197, 315, 497, 34);
		frmLogin.getContentPane().add(lblNewLabel);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		comboBox.setBounds(197, 185, 497, 34);
		frmLogin.getContentPane().add(comboBox);
		
		ArrayList<Enseignant> myEnseignants=mEnseignantDAO.getAll();
		for (Enseignant enseignant : myEnseignants) {
			comboBox.addItem(enseignant);
			comboBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					
					  Enseignant sa = (Enseignant) comboBox.getSelectedItem();
					  String stringss ="Nom: "+sa.getNomEnseignant()+" Prenom: "+sa.getPrenomEnseignant();
					  lblNewLabel.setText(stringss);
					
				}
			});
		}
		
		JButton btnNewButton = new JButton("Supprimer");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 17));
		btnNewButton.setBounds(197, 431, 177, 34);
		frmLogin.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  Enseignant sa = (Enseignant) comboBox.getSelectedItem();
				
				mEnseignantDAO.delete(sa);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_1.setBounds(513, 430, 177, 34);
		frmLogin.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
			}
		});
		
		
		String filename="./lib/tests.jpg";
		frmLogin.setBackground(new Color(255, 255, 255));
		frmLogin.setForeground(new Color(135, 206, 235));
		frmLogin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmLogin.setType(Type.UTILITY);
		frmLogin.setBounds(100, 100, 877, 651);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setVisible(true);
	}
	public Enseignant ModEnseignant(){
		JFrame frmLogin;
		 JTextField textnom;
		 JTextField textprenom;
		 JTextField textcourriel;

		frmLogin = new JFrame();
		frmLogin.setTitle("Enseignant");
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.getContentPane().setLayout(null);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		comboBox.setBounds(197, 107, 497, 34);
		frmLogin.getContentPane().add(comboBox);
		ArrayList<Enseignant> myEnseignants=mEnseignantDAO.getAll();
		for (Enseignant enseignant : myEnseignants) {
			comboBox.addItem(enseignant);
		}
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				  Enseignant sa = (Enseignant) comboBox.getSelectedItem();
				 textnom.setText(sa.getNomEnseignant());
				 textprenom.setText(sa.getPrenomEnseignant());
				 textcourriel.setText(sa.getCourriel());
				 
			}
		});
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Calibri", Font.BOLD, 17));
		btnModifier.setBounds(197, 431, 177, 34);
		frmLogin.getContentPane().add(btnModifier);
		btnModifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  Enseignant sa = (Enseignant) comboBox.getSelectedItem();
				  sa.setCourriel(textcourriel.getText());
				  sa.setNomEnseignant(textnom.getText());
				  sa.setPrenomEnseignant(textprenom.getText());
				mEnseignantDAO.update(sa);
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAnnuler.setBounds(513, 430, 177, 34);
		frmLogin.getContentPane().add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
				
			}
		});
		
		
		String filename="./lib/tests.jpg";
		frmLogin.setBackground(new Color(255, 255, 255));
		frmLogin.setForeground(new Color(135, 206, 235));
		frmLogin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmLogin.setType(Type.UTILITY);
		frmLogin.setBounds(100, 100, 877, 651);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setVisible(true);
		
		
	
		return newEnseignant;
	}
	
	public PresenceEtudiant CrListe() throws ParseException{
		JFrame frmLogin;
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
		ArrayList<Etudiant> lEtudiants = mEtudiantDAO.getAll();
		for (Etudiant etudiant : lEtudiants) {
			comboBox.addItem(etudiant);
		}
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(251, 177, 394, 31);
		frmLogin.getContentPane().add(comboBox_1);
		ArrayList<Cours> lCours=mCoursDAO.getAll();
		for (Cours cours : lCours) {
			comboBox_1.addItem(cours);
		}
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(251, 252, 394, 31);
		frmLogin.getContentPane().add(comboBox_2);
		comboBox_2.addItem("Presence");
		comboBox_2.addItem("Absence");

		
		JButton btnEnseigner = new JButton("Enseigner");
		btnEnseigner.setBounds(210, 384, 169, 31);
		frmLogin.getContentPane().add(btnEnseigner);
		btnEnseigner.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nPresenceEtudiant.setIdEtudiant(((Etudiant)comboBox.getSelectedItem()).getIdEtudiant());
				nPresenceEtudiant.setIdCours(((Cours)comboBox_1.getSelectedItem()).getIdCours());
				if(comboBox_2.getSelectedItem()=="Presence"){nPresenceEtudiant.setPresence(true);}
				else{nPresenceEtudiant.setPresence(false);}
				mPresenceEtudiantDAO.create(nPresenceEtudiant);
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(511, 384, 169, 31);
		frmLogin.getContentPane().add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
			}
		});
		
		JLabel lblEtudiant = new JLabel("Etudiant");
		lblEtudiant.setBounds(120, 109, 63, 16);
		frmLogin.getContentPane().add(lblEtudiant);
		
		JLabel lblCours = new JLabel("Cours");
		lblCours.setBounds(120, 184, 63, 16);
		frmLogin.getContentPane().add(lblCours);
		
		JLabel lblPresence = new JLabel("Presence");
		lblPresence.setBounds(120, 259, 63, 16);
		frmLogin.getContentPane().add(lblPresence);
		
		
		
		frmLogin.setVisible(true);
		return nPresenceEtudiant;
	}
	public void SupListe() throws ParseException{
		
		JFrame frmLogin;
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
		
		ArrayList<PresenceEtudiant> ll = mPresenceEtudiantDAO.getAll();
		for (PresenceEtudiant presenceEtudiant : ll) {
			comboBox.addItem(presenceEtudiant);
		}
		
		JButton btnEnseigner = new JButton("Supprimer");
		btnEnseigner.setBounds(210, 384, 169, 31);
		frmLogin.getContentPane().add(btnEnseigner);
		btnEnseigner.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nPresenceEtudiant=(PresenceEtudiant)comboBox.getSelectedItem();
				mPresenceEtudiantDAO.delete(nPresenceEtudiant);
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(511, 384, 169, 31);
		frmLogin.getContentPane().add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				  Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
		    		myModifiers.setVisible(true);
					myModifiers.runTest();
			}
		});
		
		JLabel lblEtudiant = new JLabel("Listes");
		lblEtudiant.setBounds(120, 109, 63, 16);
		frmLogin.getContentPane().add(lblEtudiant);
		
		
		frmLogin.setVisible(true);
	
	}
	public PresenceEtudiant ModListe() throws ParseException{
	
		JFrame frmLogin;
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
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setBounds(210, 170, 388, 31);
		frmLogin.getContentPane().add(lblNewLabel);
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(468, 275, 177, 31);
		frmLogin.getContentPane().add(comboBox_1);
		comboBox_1.addItem("Presence");
		comboBox_1.addItem("Absence");
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Calibri", Font.BOLD, 16));
		label.setBounds(210, 223, 388, 31);
		frmLogin.getContentPane().add(label);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(251, 102, 394, 31);
		frmLogin.getContentPane().add(comboBox);
		ArrayList<PresenceEtudiant> lPresenceEtudiants=mPresenceEtudiantDAO.getAll();
		for (PresenceEtudiant presenceEtudiant : lPresenceEtudiants) {
			comboBox.addItem(presenceEtudiant);
		}
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String nom=mEtudiantDAO.find(((PresenceEtudiant)comboBox.getSelectedItem()).getIdEtudiant()).getNomEtudiant()+" "+mEtudiantDAO.find(((PresenceEtudiant)comboBox.getSelectedItem()).getIdEtudiant()).getPrenomEtudiant();
				lblNewLabel.setText(nom);
				String cours=mCoursDAO.find(((PresenceEtudiant)comboBox.getSelectedItem()).getIdCours()).getNomCours();
				label.setText(cours);
			}
		});
		
		JButton btnEnseigner = new JButton("Modifier");
		btnEnseigner.setBounds(210, 384, 169, 31);
		frmLogin.getContentPane().add(btnEnseigner);
		btnEnseigner.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ssss=(String)comboBox_1.getSelectedItem();
				nPresenceEtudiant = (PresenceEtudiant) comboBox.getSelectedItem();
				if(ssss=="Presence"){nPresenceEtudiant.setPresence(true);}
				else{nPresenceEtudiant.setPresence(false);}
				mPresenceEtudiantDAO.update(nPresenceEtudiant);
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(511, 384, 169, 31);
		frmLogin.getContentPane().add(btnAnnuler);
		
		JLabel lblEtudiant = new JLabel("Listes");
		lblEtudiant.setBounds(120, 109, 63, 16);
		frmLogin.getContentPane().add(lblEtudiant);
		
	
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Calibri", Font.BOLD, 16));
		lblStatus.setBounds(210, 281, 155, 31);
		frmLogin.getContentPane().add(lblStatus);
		
	
		
		frmLogin.setVisible(true);
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
