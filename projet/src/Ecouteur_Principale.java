import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Ecouteur_Principale implements ActionListener {


	Fenetre_Principale fen;
	public Ecouteur_Principale(Fenetre_Principale fen)
	{
	   this.fen=fen;	
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==fen.btn_meteo)
		{
			Evenement_bnt_meteo();
			
		}
		if(e.getSource()==fen.bnt_client)
		{
			
			Evenement_bnt_client();
			
		}
		
	
		
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private void Evenement_bnt_client() {
		
		Fenetre_Principale.desk.removeAll();
		Fenetre_Principale.desk.repaint();
		
		Fenetre_Client fec=new Fenetre_Client();
		Fenetre_Principale.desk.add(fec);
		fec.show();
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private void Evenement_bnt_meteo() {
		
		Fenetre_Principale.desk.removeAll();
		Fenetre_Principale.desk.repaint();
		
		Fenetre_Meteo fec=new Fenetre_Meteo();
		Fenetre_Principale.desk.add(fec);
		fec.show();
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
}
