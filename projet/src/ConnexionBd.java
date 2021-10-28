

import java.sql.Connection;
import java.sql.DriverManager;

   public class ConnexionBd
{
	   
		/*========================================================================================================================*/
	   	/*========================================= 2) fonction  ================================================*/
	   	/*========================================================================================================================*/
		
    
   public static Connection Connexion()
   {
		
		String login="ahmed";
		String mot_de_pass="ahmed";
		String urlPilot="oracle.jdbc.OracleDriver";
		String  urlBase_de_donne="jdbc:oracle:thin:@localhost:1521:XE";
		Connection con = null;
	
		try{
		
				 Class.forName(urlPilot);
				 con =DriverManager.getConnection(urlBase_de_donne,login,mot_de_pass);
				 
		    } catch(Exception ex){System.out.println(" Pas de connection ");  return null;}
				
		   return con;
		
   }
   
	/*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/
	
   
}
