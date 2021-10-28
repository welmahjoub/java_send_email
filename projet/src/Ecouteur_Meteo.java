import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.mail.PasswordAuthentication;
import java.net.InetAddress;

public class Ecouteur_Meteo implements  ActionListener{

	Fenetre_Meteo fen;
	

	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	public Ecouteur_Meteo(Fenetre_Meteo fen)
	{
		this.fen=fen;
		
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void actionPerformed(ActionEvent arg)
	{
		

		if(arg.getSource()==fen.btn_envoyer)
		EnovyerEmaile();
		
		if(arg.getSource()==fen.btn_annuler)
			clear();
	}
	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	 private void clear() {
		fen.txt_mesage.setText("");
		
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	void EnovyerEmaile()
	{

		ArrayList<String> tab=new Dao_Client().ListeDesEmailes();
		
       String email1,email2;
       
       email1="";
       email2="";
       
       if(tab!=null)
       email1=tab.get(0);
       if(tab!=null)
       email2=tab.get(1);
		
		
		final String username = "";
		final String password = "";
		
		String text1=fen.txt_mesage.getText();
		
		Properties pros = new Properties();

		pros.put("mail.smtp.auth","true");

		pros.put("mail.smtp.starttls.enable","true");

		pros.put("mail.smtp.host","smtp.gmail.com");

		pros.put("mail.smtp.port","587");
		
		Session session = Session.getDefaultInstance(pros,
				new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);

			}});
			try{


			Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress(username));
             message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email1));

			message.setSubject("My First Email");

			message.setText(text1);

			Transport.send(message);

			JOptionPane.showMessageDialog(null, "was the email sent");

			} catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
		
	}
	

	 /*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*==========+==============================================================================================================*/
	
}


