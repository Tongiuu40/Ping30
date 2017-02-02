package maquette;
import java.awt.*;  

import javax.swing.*; 

import ping30.Cours;
import ping30.Ecole;
import ping30.Enseignant;
import ping30.Etudiant;
import ping30.GroupeEtudiant;
import ping30.PresenceEtudiant;
import ping30.Salle;
import DAO.EnseignantDAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class Login extends JFrame implements ActionListener{
	static Enseignant prof = new Enseignant();
	
	
    JButton jb1,jb2=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4=null;  
    JTextField jtf=null;  
    JLabel jlb1,jlb2,jlb3=null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;  
          
    static String userword;  
    static String pwd;  
      
    static Connection ct=null;  
    PreparedStatement ps=null;  
    ResultSet rs=null;  
      
 
    public Login()  
    {  
      
        init();
          
    }  
    
    private void init() {
    	try{
    	  jb1=new JButton("LOGIN");  
          jb2=new JButton("RESET");  
         
          jb1.addActionListener(this);  
          jb2.addActionListener(this);  
            
          jrb1=new JRadioButton("PROFESSEUR");  
          jrb2=new JRadioButton("ADMIN");  
          bg=new ButtonGroup();  
          bg.add(jrb1);  
          bg.add(jrb2);  
          jrb2.setSelected(true);  
            
          jp1=new JPanel();  
          jp2=new JPanel();  
          jp3=new JPanel();  
          jp4=new JPanel();                 
            
          jlb1=new JLabel("User  Id");  
          jlb2=new JLabel("Password");  
          jlb3=new JLabel("Login");  
            
          jtf=new JTextField(10);  
          jpf=new JPasswordField(10);  
        
          jp1.add(jlb1);  
          jp1.add(jtf);  
            
          jp2.add(jlb2);  
          jp2.add(jpf);  
            
          jp3.add(jlb3);  
          jp3.add(jrb1);  
          jp3.add(jrb2);  
            
          jp4.add(jb1);  
          jp4.add(jb2);  
            
          this.add(jp1);  
          this.add(jp2);  
          this.add(jp3);  
          this.add(jp4);  
          this.setLayout(new GridLayout(4,1));  
          this.setTitle("LOGIN");  

          this.setSize(300,200);  
          
          this.setLocation(200, 150);  
        
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
         
          this.setVisible(true);  
          this.setResizable(true);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
	}
    
    
    @Override  
    public void actionPerformed(ActionEvent e) {  
          
        if(e.getActionCommand()=="LOGIN")  
        {  
           
            if(jrb1.isSelected())  
            {  
                try {  
                  EnseignantDAO loginEnseignant = new EnseignantDAO();
                  String email = jtf.getText();
                 // String pwd = jpf.getPassword().toString();
                  String pwd = jpf.getText();
                  prof = loginEnseignant.findpwd(pwd, email);
            
              
                   tealogin(prof);  
                } catch (Exception e1) {  
                    // TODO Auto-generated catch block  
                    e1.printStackTrace();  
                }  
                 
            }else if(jrb2.isSelected()) 
            {  
                  try {
					admlogin();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
            }  
              
        }else if(e.getActionCommand()=="RESET")  
        {  
                  clear();  
        }             
          
    }  
      
   
    @SuppressWarnings("deprecation")
	public void admlogin() throws ParseException  
    {  
        if(!jtf.getText().isEmpty()&&!jpf.getPassword().toString().isEmpty())  
        {  
//        
            JOptionPane.showMessageDialog(null,"Login success","message",JOptionPane.WARNING_MESSAGE);  
            clear();  
            dispose();
            
            Modifiers myModifiers = new Modifiers("Admin pour modifier des columns");
    		myModifiers.setVisible(true);
			myModifiers.runTest();
            
        }else if(jtf.getText().isEmpty()&&jpf.getPassword().toString().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"please entre id et password","message",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"please entre id","message",JOptionPane.WARNING_MESSAGE);  
        }else if(jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"please entre password","message",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"error de password or id \n please login again","message",JOptionPane.ERROR_MESSAGE);  
          
            clear();  
        }  
    }  
   
    @SuppressWarnings("deprecation")
	public void tealogin(Enseignant prof) throws ParseException  
    {  
        if((prof.getNomEnseignant()!=null)&&(prof.getPrenomEnseignant()!=null))  
        {  
             JOptionPane.showMessageDialog(null,"login sucess","message",JOptionPane.WARNING_MESSAGE);  
             clear(); 
             dispose();
             Choixcours choix = new Choixcours(prof);
        }else if(jtf.getText().isEmpty()&&jpf.getPassword().toString().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"please entre id et password","message",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"please entre id","message",JOptionPane.WARNING_MESSAGE);  
        }else if(jpf.getPassword().toString().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"please entre password","message",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"error de password or id \n please login again","message",JOptionPane.ERROR_MESSAGE);  
           
            clear();  
        }  
    }  
  
    public  void clear()  
    {  
        jtf.setText("");  
        jpf.setText("");  
    }  
}
