package view;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author lflea
 */
public class FrameTelas extends javax.swing.JFrame {

    CardLayout cardLayout;
    private String telaAnterior = "loginPanel";
    private MenuClientePanel menuClientePanel;
    
    public FrameTelas() {
        initComponents();        
        inicializacaoVariaveis();
        minhasConfiguracoes();
        
        this.configurarNavegacao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    private void minhasConfiguracoes() {       
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void inicializacaoVariaveis(){
        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameTelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTelas().setVisible(true);
            }
        });
    }

    private void configurarNavegacao() {
        JPanel loginPanel = new LoginPanel(this);
        this.menuClientePanel = new MenuClientePanel(this);
        JPanel menuGerentePanel = new MenuGerentePanel(this);
        JPanel menuAdmPanel = new MenuAdmPanel(this);
        JPanel menuMembroPanel = new MenuMembroPanel(this);

        this.add(loginPanel, "loginPanel");
        this.add(this.menuClientePanel, "menuClientePanel");
        this.add(menuGerentePanel, "menuGerentePanel");
        this.add(menuAdmPanel, "menuAdmPanel");
        this.add(menuMembroPanel, "menuMembroPanel");
        
        this.trocarTela("loginPanel");
    }

    public void trocarTela(String nomeTela) {
        this.cardLayout.show(this.getContentPane(), nomeTela);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void abrirCliente(String origem) {
        this.telaAnterior = origem;
        this.menuClientePanel.atualizarTextoBotao();
        trocarTela("menuClientePanel");
    }

    public void voltarTelaAnterior() {
        trocarTela(telaAnterior);
    }

    public String getTelaAnterior() {
        return telaAnterior;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}