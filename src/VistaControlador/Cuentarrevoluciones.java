package VistaControlador;

import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.tools.BackgroundColor;
import eu.hansolo.steelseries.tools.FrameDesign;
import eu.hansolo.steelseries.tools.LcdColor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Cuentarrevoluciones extends javax.swing.JPanel {
    private final Radial gauge;

    public Cuentarrevoluciones() {
        initComponents();
        
        gauge = new Radial();
        
        gauge.setMaxValue(5);
        gauge.setMajorTickSpacing(0.5);
        gauge.setTitle("RPM");
        gauge.setUnitString("x1000");
        gauge.setTrackStart(0.0);
        gauge.setTrackSection(2.5);
        gauge.setTrackStop(5.0);
        gauge.setTrackStartColor(Color.GREEN);
        gauge.setTrackSectionColor(Color.YELLOW);
        gauge.setTrackStopColor(Color.RED);
        gauge.setThreshold(4);
        gauge.setGlowColor(Color.cyan);
        gauge.setGlowVisible(true);
        gauge.setGlowing(true);
        gauge.setLcdVisible(false);
        gauge.setBackgroundColor(BackgroundColor.CARBON);
        
        gauge.setTrackVisible(true);
        
        gauge.setLcdColor(LcdColor.BLUE_LCD);
        gauge.setFrameDesign(FrameDesign.BLACK_METAL);
        
        setPreferredSize(new Dimension(300,300));
        
        this.setLayout(new BorderLayout());
        this.add(gauge, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public void actualizaRevoluciones(double valor){
        gauge.setValueAnimated(valor/1000);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
