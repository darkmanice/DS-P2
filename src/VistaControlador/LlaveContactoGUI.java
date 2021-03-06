
package VistaControlador;

import Modelo.velocidad.LlaveContacto;


public class LlaveContactoGUI extends javax.swing.JPanel {

    private LlaveContacto llave;
    
    public LlaveContactoGUI(LlaveContacto unaLlave) {
        llave = unaLlave;
        initComponents();
    }
    
    public void actualizarLLaveContacto(){
        if (llave.apagado()){
            botonLlave.setText("Encender");
        } else{
            botonLlave.setText("Apagar");
        }
        
        repaint();
        revalidate();
    }
    
    public javax.swing.JToggleButton getEncender(){
        return botonLlave;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonLlave = new javax.swing.JToggleButton();

        setOpaque(false);

        botonLlave.setText("Encender");
        botonLlave.setPreferredSize(new java.awt.Dimension(89, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(botonLlave, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonLlave, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonLlave;
    // End of variables declaration//GEN-END:variables
}
