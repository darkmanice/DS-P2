package VistaControlador;

import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.tools.BackgroundColor;
import java.awt.Color;
import eu.hansolo.steelseries.tools.FrameDesign;
import eu.hansolo.steelseries.tools.LcdColor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Velocimetro extends javax.swing.JPanel {
    private final Radial gauge;

    public Velocimetro() {
        initComponents();
        
        gauge = new Radial();
        
        gauge.setMaxValue(300);
        gauge.setMajorTickSpacing(50.0);
        gauge.setTitle("");
        gauge.setUnitString("Km/h");
        gauge.setTrackStart(0.0);
        gauge.setTrackSection(250.0);
        gauge.setTrackStop(300.0);
        gauge.setTrackStartColor(Color.GREEN);
        gauge.setTrackSectionColor(Color.YELLOW);
        gauge.setTrackStopColor(Color.RED);
        gauge.setThreshold(250);
        gauge.setGlowColor(Color.cyan);
        gauge.setGlowVisible(true);
        gauge.setGlowing(true);
        gauge.setBackgroundColor(BackgroundColor.CARBON);
        gauge.setLcdDecimals(1);
        gauge.setLcdUnitString("Km/h");
        gauge.setLcdUnitStringVisible(true);
        setPreferredSize(new Dimension(300,300));
        
        gauge.setTrackVisible(true);
        
        gauge.setLcdColor(LcdColor.BLUE_LCD);
        gauge.setFrameDesign(FrameDesign.BLACK_METAL);
        
        this.setLayout(new BorderLayout());
        this.add(gauge, BorderLayout.CENTER);
                
        setVisible(true);
    }
    
    public void actualizaVelocidad(double valor){
        gauge.setValueAnimated(valor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 251, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
