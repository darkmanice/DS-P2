package VistaControlador;

import Modelo.velocidad.Pedales;
import java.awt.Color;


public class PedalesGUI extends javax.swing.JPanel {

    private Pedales pedales;
    
    public PedalesGUI(Pedales unosPedales) {
        pedales = unosPedales;
        initComponents();
        
        Freno.setEnabled(false);
        Acelerador.setEnabled(false);
    }

    public void actualizarPedales(){
        if (pedales.frenoPisado()){
            pisarFreno();
        } else{
            soltarFreno();
        }
        
        if (pedales.aceleradorPisado()){
            pisarAcelerador();
        } else{
            soltarAcelerador();
        }
        
        repaint();
        revalidate();
    }
    
    public javax.swing.JToggleButton getAcelerar(){
        return Acelerador;
    }
    
    public javax.swing.JToggleButton getFrenar(){
        return Freno;
    }
    
    public void pisarFreno(){
        Freno.setText("Soltar freno");
        //Freno.setForeground(Color.RED);
        Freno.setSelected(true);
    }
    
    public void soltarFreno(){
        Freno.setText("Frenar");
        Freno.setSelected(false);
    }
    
    public void pisarAcelerador(){
        Acelerador.setText("Soltar acelerador");
        Acelerador.setSelected(true);
    }
    
    public void soltarAcelerador(){
        Acelerador.setText("Acelerar");
        Acelerador.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Acelerador = new javax.swing.JToggleButton();
        Freno = new javax.swing.JToggleButton();

        setOpaque(false);

        Acelerador.setText("Acelerar");
        Acelerador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceleradorActionPerformed(evt);
            }
        });

        Freno.setText("Frenar");
        Freno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrenoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Freno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Acelerador, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Acelerador, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Freno, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AceleradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceleradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AceleradorActionPerformed

    private void FrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FrenoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Acelerador;
    private javax.swing.JToggleButton Freno;
    // End of variables declaration//GEN-END:variables
}
