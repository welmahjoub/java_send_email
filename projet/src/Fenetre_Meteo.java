import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class Fenetre_Meteo extends javax.swing.JInternalFrame {

   
	private static final long serialVersionUID = 4366782625322824309L;
	
    public Fenetre_Meteo() {
        
        initComponents();
        setSize(1000,480);
        evenement();
    }

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void remove_title()
    {

       putClientProperty("fenetre_eleve.isPalette",Boolean.TRUE);
       getRootPane().setWindowDecorationStyle(JRootPane.NONE);
       ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
       this.setBorder(null);
    }
    
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void evenement()
    {
    	remove_title();
    	
    	btn_envoyer.addActionListener(new Ecouteur_Meteo(this));
    	btn_annuler.addActionListener(new Ecouteur_Meteo(this));
 
    }
    
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/                            
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_mesage = new javax.swing.JTextArea();
        btn_annuler = new javax.swing.JButton();
        btn_envoyer = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_mesage.setColumns(20);
        txt_mesage.setRows(5);
        jScrollPane1.setViewportView(txt_mesage);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 730, 240));

        btn_annuler.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_annuler.setText("Annuler");
        jPanel1.add(btn_annuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 135, 50));

        btn_envoyer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_envoyer.setText("Envoyer");
        jPanel1.add(btn_envoyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 135, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 760, 400));

        pack();
    }                       


    // Variables declaration - do not modify 
    
    public javax.swing.JButton btn_annuler;
    public javax.swing.JButton btn_envoyer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txt_mesage;
    
    // End of variables declaration                   
}
