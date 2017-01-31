package maquette;

import java.awt.GridLayout;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.CoursDAO;
import ping30.Cours;
import ping30.Enseignant;

public class Choixcours extends JFrame implements ActionListener {
	int x;
	String strings ="sss";
	public static Cours courschoix;
	 JButton jb1,jb2=null;  
     JPanel jp1,jp2,jp3=null;  
     JLabel jlb1,jlb2,jlb3,jlb4=null;  
     JComboBox xBox= new JComboBox();
     
     //
     public  Choixcours(Enseignant prof) throws ParseException 
     {  
    	 
        
         jb2=new JButton("entrer");  
          jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				dispose();
				Photo php = new Photo(courschoix);
			}
		});
         jp1=new JPanel();  
         jp2=new JPanel();  
         jp3=new JPanel();  
           
         jlb1=new JLabel("Monsieur "+prof.getNomEnseignant()+"   ");
         jlb2=new JLabel(prof.getPrenomEnseignant());  
         jlb3=new JLabel("Des cours ici pour choisir");  
         jlb4=new JLabel("");  
         ArrayList<Cours> listcours = new ArrayList<Cours>();
         CoursDAO coursDAO = new CoursDAO();
         listcours = coursDAO.findbyenseignan(prof.getIdEnseignant());
         
         jp1.add(jlb1);  
         jp1.add(jlb2);  
           
         jp2.add(xBox);  
         jp2.add(jlb3);  
           
         jp3.add(jb2);  
         jp3.add(jlb4);  
         
         for (Cours cours : listcours) {
        	 xBox.addItem(cours);
		}  
         xBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED)
					courschoix =(Cours) xBox.getSelectedItem();
					;
			}
		});
           
         this.add(jp1);  
         this.add(jp2);  
         this.add(jp3);  
           
       
         this.setLayout(new GridLayout(3,3,50,50));  
         this.setTitle("systeme balabala");  
         this.setSize(600,500);  
         this.setLocation(200, 200);       
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
         this.setVisible(true);  
      

}  
	
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  if(e.getActionCommand()=="Choix des cours")  {
			  
		  }
		  else if(e.getActionCommand()=="entrer"){
			    dispose();  
			   Photo photos = new Photo();
		  }
		
	}
	

}
