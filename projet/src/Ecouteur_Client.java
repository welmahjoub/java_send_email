import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;

public class Ecouteur_Client extends Ecouteur implements  ActionListener,KeyListener,MouseListener {

	Fenetre_Client fen;
	Dao_Client d;
	Client Inst;
	ResultSet rs;
	public Ecouteur_Client(Fenetre_Client fen)
	{
		this.fen=fen;
		d=new Dao_Client();
		Inst=new Client();
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	public void  Create()
	{
		
		Inst=new Client();
        Inst.setCIN(fen.txt_cin.getText());
  	    Inst.setNOM(fen.txt_nom.getText());
  	    Inst.setPRENOM(fen.txt_prenom.getText());
  	    Inst.setEMAIL(fen.txt_email.getText());
  	    Inst.setPROFESSION(fen.txt_prof.getText());
   
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void Ajouter() 
	{
		
		if(All_champs_is_empty()==true)
	   	 {
	   		 JOptionPane.showInternalMessageDialog(fen, " Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
	   	 }
		else  if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showInternalMessageDialog(fen, " Veuillez Saisir Des Informations Correct  "
	   				 , " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
		else
			{
			    int cin=Integer.parseInt(fen.txt_cin.getText());

				if(d.getById(cin)!=null)
				{
					 JOptionPane.showInternalMessageDialog(fen, " Client Existe Deja  ", " Error", JOptionPane.WARNING_MESSAGE); 
				}
				else if(JOptionPane.showConfirmDialog(null, " Voulez vous Ajouter  cette Client   ? ")==0)
					{						
                       Create();
						d.Ajouter(Inst);
						UpdateTable();
					    clear();
					}
				} 	 
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void Modifier() {
		if(All_champs_is_empty()==true)
        {
	        JOptionPane.showInternalMessageDialog(fen, "Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
         }	
		 else if(Tester_formlaire()==false)
		 {
			 JOptionPane.showInternalMessageDialog(fen, " Veuillez saisi des informations Correct slvp "
					 , " Erreur ", JOptionPane.WARNING_MESSAGE); 
		 }
		 else 
		     {
		    	 int cin=Integer.parseInt(fen.txt_cin.getText());
		    	 Client test=d.getById(cin);
		    	 if(test==null)
		    	 {
		    		 JOptionPane.showInternalMessageDialog(fen, " Client N'Existe pas ", " Erreur ", JOptionPane.WARNING_MESSAGE); 
				 }

		    	 else  if(JOptionPane.showConfirmDialog(null, " Voulez vous Modifier   cette Client  ? ")==0)
						{
						   Create();		        
						   d.Modifier(Inst);
						   UpdateTable();
						   clear();
						} 
		     }
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void Supprimer() {
		
		int  cin;
		if(All_champs_is_empty()==true)
        {
  	        JOptionPane.showInternalMessageDialog(fen, "Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
        }		
	     else  if(Tester_formlaire()==false)
	     {
	    	 JOptionPane.showInternalMessageDialog(fen, "Veuillez saisi des informations Correct slvp"
					 , "Champs Vide ", JOptionPane.WARNING_MESSAGE);  
	     }
         else
	        {
			    cin=Integer.parseInt(fen.txt_cin.getText());      
			    Client test=d.getById(cin);	 
			    if(test==null)
			    {
			     JOptionPane.showMessageDialog(null, " Client n existe pas ");
			    }
			    else if(JOptionPane.showConfirmDialog(null, " Voulez vous supprimer   cette Client  ? ")==0)
				     {
					   d.Supprimer(cin);
					   UpdateTable();
					   clear();
				     }  
	         }
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void Consulter() 
	{
		
		 fen.txt_cin.setText(String.valueOf(Inst.getCIN()));
		 fen.txt_nom.setText(Inst.getNOM());
		 fen.txt_prenom.setText(Inst.getPRENOM());
		 fen.txt_email.setText(Inst.getEMAIL());
		 fen.txt_prof.setText(Inst.getPROFESSION());
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void UpdateTable() {
		rs=d.getAll();
        fen.liste_client.setModel(DbUtils.resultSetToTableModel(rs));	
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@SuppressWarnings("deprecation")
	@Override
	public void clear() {

		fen.txt_cin.setText("");
    	fen.txt_nom.setText("");
    	fen.txt_prenom.setText("");
    	fen.txt_email.setText("");
    	fen.txt_prof.setText("");
    	fen.txt_cin.enable(true);
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public boolean Tester_formlaire() {
		
		if(fen.lbl_test_cin.getText().equals("")  ==false)
			return false;
		if(fen.lbl_test_email.getText().equals("")   ==false)
			return false;
		if(fen.lbl_test_nom.getText().equals("")   ==false)
			return false;
		if(fen.lbl_test_prenom.getText().equals("")   ==false)
			return false;
		
	
		if(fen.txt_nom.getText().equals(""))
			return false;
		if(fen.txt_cin.getText().equals(""))
			return false;
		if(fen.txt_prenom.getText().equals(""))
			return false;
		
			return true;
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/

	@Override
	public boolean All_champs_is_empty() {
		
		if(fen.txt_nom.getText().equals("") && fen.txt_cin.getText().equals("") && fen.txt_prenom.getText().equals(""))
			return true;
			else
				return false;
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void Recherche() {
		String nom;

		if(fen.txt_recherche.getText().equals("")==false)
		{
			nom=fen.txt_recherche.getText();
			
			if(nom.matches("[A-Za-z ]*")==true)
			{
				rs =d.Find_ByNom(nom);
			    fen.liste_client.setModel(DbUtils.resultSetToTableModel(rs));
			}
			else
				if(nom.matches("[0-9 ]*")==true)
			{
				int num;
			    num=Integer.parseInt(fen.txt_recherche.getText());
			    rs =d.Find_ById(num);
				fen.liste_client.setModel(DbUtils.resultSetToTableModel(rs));
			}
			   else
			  {
				JOptionPane.showMessageDialog(null, "Veuillez saisir numero ou nom  correct ");
			   }
		}
		else
		{
			  UpdateTable();
		}	
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/

	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int row =fen.liste_client.getSelectedRow();
		if(row!=-1)
		{
			String  num=  fen.liste_client.getModel().getValueAt(row, 0).toString();
			int n=Integer.parseInt(num);
			
			fen.txt_cin.enable(false);
		    Inst=d.getById(n);
		    Consulter();
		}
		
	}

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void keyPressed(KeyEvent arg) {
		if(arg.getSource()!=fen.txt_recherche)
		{
			tester_nom();
			tester_cin();
			tester_prenom();
			tester_email();
			
		}
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	private void tester_email() {
		
		if(fen.txt_email.getText().equals(""))
		{
			fen.lbl_test_email.setText("");
		}	
		else	
		       if( isValidEmailAddress(fen.txt_email.getText()))
		       {
		    	      fen.  lbl_test_email.setText("");
				       fen.lbl_test_email.setIcon(null);
		    	   
		       }				          
		         else
		         {
		        	 fen.  lbl_test_email.setText("");
		             fen.lbl_test_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
		        	 
		         }
			           
	
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	private void tester_prenom() {
		if(fen.txt_prenom.getText().equals(""))
		{
			fen.lbl_test_prenom.setIcon(null);
			fen.  lbl_test_prenom.setText(" * ");
		}	
		else 
		     if(fen.txt_prenom.getText().matches("[A-Za-z ]*")==true)
		     {
		         fen.  lbl_test_prenom.setText("");
		         fen.lbl_test_prenom.setIcon(null);
		     }
            else 
             {
                 fen.  lbl_test_prenom.setText("");
                 fen.lbl_test_prenom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
              }
		
	}

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	private void tester_cin() {
		if(fen.txt_cin.getText().equals(""))
		{
			fen.lbl_test_cin.setIcon(null);
		
		}	
		else 
		     if((fen.txt_cin.getText().matches("[0-9 ]*")==true) && (fen.txt_cin.getText().length()==8))
		     {
		         fen.  lbl_test_cin.setText("");
		         fen.lbl_test_cin.setIcon(null);
		     }
	        else 
	         {
	             fen.  lbl_test_cin.setText("");
	             fen.lbl_test_cin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
	          }
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	private void tester_nom() {
		if(fen.txt_nom.getText().equals(""))
		{
			fen.lbl_test_nom.setIcon(null);
			fen.  lbl_test_nom.setText(" * ");
		}	
		else 
		     if(fen.txt_nom.getText().matches("[A-Za-z]*")==true)
		     {
		         fen.  lbl_test_nom.setText("");
		         fen.lbl_test_nom.setIcon(null);
		     }
            else 
             {
                 fen.  lbl_test_nom.setText("");
                 fen.lbl_test_nom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
              }
		
	}

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void keyReleased(KeyEvent arg) {
		if(arg.getSource()!=fen.txt_recherche)
		{
			tester_nom();
			tester_cin();
			tester_prenom();
			tester_email();
		}
		
		
		if(arg.getSource()==fen.txt_recherche)
		{
			Recherche();
		}
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public void actionPerformed(ActionEvent arg) {
		if(arg.getSource()==fen.btn_ajout)
		{
		  Ajouter();
		}

		if(arg.getSource()==fen.btn_clear)
		{
			clear();	
		}

		if(arg.getSource()==fen.btn_mod)
	     {
			
			Modifier();
	     }
		if(arg.getSource()==fen.btn_sup)
		{
			
			Supprimer();
		}
		
	}
	
    /*========================================================================================================================*/
	/*============================================   Fin =====================================================================*/
	/*========================================================================================================================*/
		
    public boolean isValidEmailAddress(String email)
    {
			  
	          String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\"
	          		+ ".[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	          java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	          java.util.regex.Matcher m = p.matcher(email);
	          return m.matches();
	          
	  }
		  

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
}
