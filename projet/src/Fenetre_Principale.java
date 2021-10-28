
public class Fenetre_Principale extends javax.swing.JFrame {

   
	private static final long serialVersionUID = 3471850758253658881L;
	public Fenetre_Principale() {
        
		 setSize(1000,600);
         setLocationRelativeTo(null);
        initComponents();
        
        bnt_client.addActionListener(new Ecouteur_Principale(this));
        btn_meteo.addActionListener(new Ecouteur_Principale(this));
    }

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    private void initComponents() 
    {

        desk = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        bnt_client = new javax.swing.JButton();
        btn_meteo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        desk.setBackground(new java.awt.Color(240, 240, 240));
        getContentPane().add(desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1000, 480));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bnt_client.setText("Client");
        jPanel1.add(bnt_client, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 70));

        btn_meteo.setText("Meteo");
        jPanel1.add(btn_meteo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 170, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 120));

        pack();
    }// </editor-fold>                        

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre_Principale().setVisible(true);
            }
        });
    }

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    // Variables declaration - do not modify                     
    public  javax.swing.JButton bnt_client;
    public javax.swing.JButton btn_meteo;
    public static  javax.swing.JDesktopPane desk;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}
