package VistaControlador;


public class P2Applet extends javax.swing.JApplet {

    
    @Override
    public void init() {
        Controlador controlador = new Controlador();
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    
                    initComponents();
                    vista.add(controlador.getVista());
                    setSize(1350 , 770);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vista = new javax.swing.JPanel();

        vista.setLayout(new java.awt.BorderLayout());
        getContentPane().add(vista, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel vista;
    // End of variables declaration//GEN-END:variables
}