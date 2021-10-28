import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao_Client extends DAO<Client>{

	 private String SQL;
	 private  Client inst=null;
	 
	 /*
		  *  CIN
	NOM
	PRENOM
	EMAIL
	PROFESSION
*/
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Ajouter(Client e) {
		
		SQL=" INSERT INTO client VALUES (?,?,?,?,?)";

		 try {
			   
	          DAO.ps=DAO.conn.prepareStatement(SQL);
	          DAO.ps.setString(1, e.getCIN());
	          DAO.ps.setString(2,e.getNOM());
	          DAO.ps.setString(3,e.getPRENOM());
	          DAO.ps.setString(4,e.getEMAIL());
	          DAO.ps.setString(5,e.getPROFESSION());
	          DAO.ps.execute();
  
	         } catch (SQLException ex) {   System.out.print(" erreur ajouter client ");    }	
		
	}

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	@Override
	public void Modifier(Client e) 
	{
		
		SQL="Update client set  NOM =? , PRENOM =?  ,   EMAIL =? ,  PROFESSION =?  where  CIN =?";
		 		 
		 		 
		  try {
		              DAO.ps=DAO.conn.prepareStatement(SQL);             
			          DAO.ps.setString(1,e.getNOM());
			          DAO.ps.setString(2,e.getPRENOM());
			          DAO.ps.setString(3,e.getEMAIL());
			          DAO.ps.setString(4,e.getPROFESSION());
			          DAO.ps.setString(5,e.getCIN());
		              DAO.ps.execute();  
		             
		    } catch (SQLException ex) {   System.out.print(" erreur Modifier client  ");    }
		
	}

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	@Override
	public void Supprimer(int cin)
	{

          SQL="DELETE FROM client WHERE cin=?";
 	    
        try {
		   
              DAO.ps=DAO.conn.prepareStatement(SQL);
              DAO.ps.setInt(1 ,cin);
              DAO.ps.execute();
   
           } catch (SQLException ex) {   System.out.print(" erreur supprimer client  ");    }
		
		
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	@Override
	public ResultSet getAll() {
		
		 SQL="SELECT  CIN,NOM||' '||PRENOM Nom,email FROM client order by cin";
	 	   
	 	  try {
	 		  
	 		   DAO.ps=DAO.conn.prepareStatement(SQL);
	           rs=DAO.ps.executeQuery();
	           return rs;    
	            
	         } catch (SQLException ex)  {   System.out.print(" erreur get all cleitn  ");   return null;   }
	
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	@Override
	public Client getById(int id) {
         SQL="select * from client where cin=?";
     	 
   	     try {
   	    	 
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
   	          DAO.ps.setInt(1, id);
              rs=DAO.ps.executeQuery();
              
              if(rs.next())
              {
            	  inst=new Client();
            	  inst.setCIN(rs.getString("cin"));
            	  inst.setNOM(rs.getString("NOM"));
            	  inst.setPRENOM(rs.getString("PRENOM"));
            	  inst.setEMAIL(rs.getString("EMAIL"));
            	  inst.setPROFESSION(rs.getString("PROFESSION"));
  
             	  return inst;
              }
              else
                   return null;
   	
             } catch (SQLException ex)  {   System.out.print(" erreur get by id client   ");   return null;   }
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public Client getByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	@Override
	public ResultSet Find_ById(int cin) 
	{
		String n=String.valueOf(cin);
	 	n=n+"%";
	 	
		SQL="SELECT  cin,NOM||' '||PRENOM Nom,email FROM client where to_char(cin) like ?";

	   try {
		   
	 		   DAO.ps=DAO.conn.prepareStatement(SQL);
	 		   DAO.ps.setString(1, n);
	           rs=DAO.ps.executeQuery();
	            
	           return rs;    
	            
	           } catch (SQLException ex) {   System.out.print(" erreur Find By id (int cin) ");   return null;   }
	}
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public ResultSet Find_ByNom(String nom)
	{
		nom=nom+"%";
		
	     SQL="SELECT  cin,NOM||' '||PRENOM  Nom FROM client where NOM like ? or PRENOM like ?";
	 	   
	      try {
	 		 
		 		  DAO.ps=DAO.conn.prepareStatement(SQL);
		 		  DAO.ps.setString(1, nom);
		 		  DAO.ps.setString(2, nom);
		          rs=DAO.ps.executeQuery();
	            
	              return rs;    
	            
	          } catch (SQLException ex)  {   System.out.print(" erreur find by nom client  ");   return null;   }
	}

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	public ArrayList<String> ListeDesEmailes()
	{
		String p1,p2;
		p1="pecheur";
		p2="medecin";
		
		ArrayList<String> tab=new ArrayList<String>();
          SQL="select email from client where PROFESSION like ?  or PROFESSION=?";
     	 
   	     try {
   	    	 
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
   		      DAO.ps.setString(1, p1);
   		      DAO.ps.setString(2, p2);
   		      
              rs=DAO.ps.executeQuery();
              
              while(rs.next())
              {
            	  tab.add(rs.getString("email"));
            	 
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur liset email   ");   return null;   }
		
		
		return tab;
	}
	
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
}
