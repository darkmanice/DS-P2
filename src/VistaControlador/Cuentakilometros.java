package VistaControlador;

import eu.hansolo.steelseries.gauges.DisplaySingle;
import java.awt.Color;

public class Cuentakilometros extends javax.swing.JPanel {

    public Cuentakilometros() {
        initComponents();
        
        contadorReciente.setLcdDecimals(2);
        contadorReciente.setLcdUnitString("Km");
        contadorTotal.setLcdDecimals(2);
        contadorTotal.setLcdUnitString("Km");
        
        setVisible(true);
    }
    public void setReciente(double kmReciente){
        contadorReciente.setLcdValue(kmReciente);
    }
    
    public void setTotal(double kmTotal){
        contadorTotal.setLcdValue(kmTotal);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contadorReciente = new eu.hansolo.steelseries.gauges.DisplaySingle();
        contadorTotal = new eu.hansolo.steelseries.gauges.DisplaySingle();
        tituloReciente = new javax.swing.JLabel();
        tituloReciente1 = new javax.swing.JLabel();

        setOpaque(false);

        tituloReciente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tituloReciente.setForeground(new java.awt.Color(255, 255, 255));
        tituloReciente.setText("Km recientes");

        tituloReciente1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tituloReciente1.setForeground(new java.awt.Color(255, 255, 255));
        tituloReciente1.setText("Km totales");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(tituloReciente, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(contadorReciente, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tituloReciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contadorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloReciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloReciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contadorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contadorReciente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private eu.hansolo.steelseries.gauges.DisplaySingle contadorReciente;
    private eu.hansolo.steelseries.gauges.DisplaySingle contadorTotal;
    private javax.swing.JLabel tituloReciente;
    private javax.swing.JLabel tituloReciente1;
    // End of variables declaration//GEN-END:variables
}
