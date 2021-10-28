import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Fenetre_Client extends javax.swing.JInternalFrame {

    
	private static final long serialVersionUID = -8433301491441605064L;
	
    public Fenetre_Client() {
      
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
    	
    	 lbl_Image_recherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/r.png"))); // NOI18N
         btn_ajout.addActionListener(new Ecouteur_Client(this));
         btn_mod.addActionListener(new Ecouteur_Client(this));
         btn_sup.addActionListener(new Ecouteur_Client(this));
         btn_clear.addActionListener(new Ecouteur_Client(this));
         
         txt_cin.addKeyListener(new Ecouteur_Client(this));
         txt_nom.addKeyListener(new Ecouteur_Client(this));
         txt_prenom.addKeyListener(new Ecouteur_Client(this));
         txt_email.addKeyListener(new Ecouteur_Client(this));
       
         txt_recherche.addKeyListener(new Ecouteur_Client(this));
     
         liste_client.addMouseListener(new Ecouteur_Client(this));
         
         new Ecouteur_Client(this).UpdateTable();
    }
    
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/                         
    private void initComponents() {

        panel_list_cleint = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        liste_client = new javax.swing.JTable();
        txt_recherche = new javax.swing.JTextField();
        lbl_Image_recherche = new javax.swing.JLabel();
        panel_client = new javax.swing.JPanel();
        lbl_email = new javax.swing.JLabel();
        lbl_cin = new javax.swing.JLabel();
        lbl_nom = new javax.swing.JLabel();
        lbl_prenom = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        txt_prenom = new javax.swing.JTextField();
        txt_prof = new javax.swing.JTextField();
        lbl_test_nom = new javax.swing.JLabel();
        lbl_test_prenom = new javax.swing.JLabel();
        lbl_test_email = new javax.swing.JLabel();
        lbl_test_cin = new javax.swing.JLabel();
        txt_cin = new javax.swing.JTextField();
        lbl_email1 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        panel_operation = new javax.swing.JPanel();
        btn_mod = new javax.swing.JButton();
        btn_sup = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_ajout = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_list_cleint.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Clients ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_list_cleint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        liste_client.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIN", "Nom", "Prenom", "Email"
            }
        ));
        liste_client.setRowHeight(20);
        liste_client.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        jScrollPane1.setViewportView(liste_client);

        panel_list_cleint.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, 340));

        txt_recherche.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_list_cleint.add(txt_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, 30));
        panel_list_cleint.add(lbl_Image_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 50, 30));

        getContentPane().add(panel_list_cleint, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 430));

        panel_client.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_client.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_email.setText("Profession :");
        panel_client.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 80, 30));

        lbl_cin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_cin.setText("CIN :");
        panel_client.add(lbl_cin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 40, 30));

        lbl_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom.setText("Nom :");
        panel_client.add(lbl_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 40, 30));

        lbl_prenom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_prenom.setText("Prenom :");
        panel_client.add(lbl_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 60, 30));

        txt_nom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_client.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 150, 30));

        txt_prenom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_client.add(txt_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 150, 30));

        txt_prof.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_client.add(txt_prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 150, 30));

        lbl_test_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_client.add(lbl_test_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 30, 30));

        lbl_test_prenom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_client.add(lbl_test_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 30, 30));

        lbl_test_email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_client.add(lbl_test_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 30, 30));

        lbl_test_cin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_client.add(lbl_test_cin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 30, 30));

        txt_cin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_client.add(txt_cin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 150, 30));

        lbl_email1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_email1.setText("Email :");
        panel_client.add(lbl_email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 50, 30));

        txt_email.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_client.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 150, 30));

        getContentPane().add(panel_client, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 600, 310));

        panel_operation.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation"));
        panel_operation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_mod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_mod.setText("Modifier");
        panel_operation.add(btn_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 135, 50));

        btn_sup.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_sup.setText("Supprimer");
        panel_operation.add(btn_sup, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 135, 50));

        btn_clear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_clear.setText("Clear");
     
        panel_operation.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 135, 50));

        btn_ajout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_ajout.setText("Ajouter");
        panel_operation.add(btn_ajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 135, 50));

        getContentPane().add(panel_operation, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 600, 110));

        pack();
    }// </editor-fold>                        

                                        
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

    // Variables declaration - do not modify                     
    public javax.swing.JButton btn_ajout;
    public javax.swing.JButton btn_clear;
    public javax.swing.JButton btn_mod;
    public javax.swing.JButton btn_sup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Image_recherche;
    private javax.swing.JLabel lbl_cin;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_email1;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_prenom;
    public javax.swing.JLabel lbl_test_cin;
    public javax.swing.JLabel lbl_test_email;
    public javax.swing.JLabel lbl_test_nom;
    public javax.swing.JLabel lbl_test_prenom;
    public javax.swing.JTable liste_client;
    private javax.swing.JPanel panel_client;
    private javax.swing.JPanel panel_list_cleint;
    private javax.swing.JPanel panel_operation;
    public javax.swing.JTextField txt_cin;
    public javax.swing.JTextField txt_email;
    public javax.swing.JTextField txt_nom;
    public javax.swing.JTextField txt_prenom;
    public javax.swing.JTextField txt_prof;
    public javax.swing.JTextField txt_recherche;
    // End of variables declaration                   
}
