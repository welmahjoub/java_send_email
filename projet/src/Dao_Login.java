

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Dao_Login {
	
	public static  Connection conn=ConnexionBd.Connexion(); 
	public static   PreparedStatement ps=null;
	public ResultSet rs=null;
 
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	   public  boolean  seconnectez(String user_name,String password ) 
	   {                                           
		    String requete="select * from LOGIN where LOGIN =? and PASSWORD =? ";

	        try {
	        	
	            ps=conn.prepareStatement(requete);
	            ps.setString(1,user_name);
	            ps.setString(2,password);
	            rs=ps.executeQuery();
	            
	            if(rs.next())
	                return true;
	            else
	               return false ;

	                 } catch (SQLException ex) {System.out.println(" ererue seconecter ");return false;   }
      }
	   
	  /*========================================================================================================================*/
   	 /*========================================= 2) fonction  ================================================*/
	 /*========================================================================================================================*/
}

