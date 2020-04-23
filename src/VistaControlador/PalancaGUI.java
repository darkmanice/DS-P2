package VistaControlador;

import Modelo.velocidad.Palanca;
import Modelo.velocidad.PosicionPalanca;

public class PalancaGUI extends javax.swing.JPanel {
    private Palanca palanca;
    
    public PalancaGUI(Palanca unaPalanca) {
        palanca = unaPalanca;
        
        initComponents();
        
        actualizarPosicion();
        
        setVisible(true);
        
        botonApagar.setEnabled(false);
        botonAcelerar.setEnabled(false);
        botonMantener.setEnabled(false);
        botonReiniciar.setEnabled(false);
        
        repaint();
        revalidate();
    }
    
    public synchronized void actualizarPosicion(){

        if (palanca.getPosicion() == PosicionPalanca.ACELERAR){
            Acelerar();
        } else if(palanca.getPosicion() == PosicionPalanca.APAGAR){
             Apagar();
        } else if(palanca.getPosicion() == PosicionPalanca.MANTENER){
             Mantener();
        }else if(palanca.getPosicion() == PosicionPalanca.REINICIAR){
             Reiniciar();
        }
        
        repaint();
        revalidate();
    }

    public javax.swing.JButton getApagar(){
        return botonApagar;
    }
    
    public javax.swing.JButton getAcelerar(){
        return botonAcelerar;
    }
        
    public javax.swing.JButton getMantener(){
        return botonMantener;
    }
    
    public javax.swing.JButton getReiniciar(){
        return botonReiniciar;
    }
    
    private void Apagar(){
        Apagar.setVisible(true);
        Acelerar.setVisible(false);
        Mantener.setVisible(false);
        Reiniciar.setVisible(false);
    }
    
    private void Acelerar(){
        Apagar.setVisible(false);
        Acelerar.setVisible(true);
        Mantener.setVisible(false);
        Reiniciar.setVisible(false);
    }
    
    private void Mantener(){
        Apagar.setVisible(false);
        Acelerar.setVisible(false);
        Mantener.setVisible(true);
        Reiniciar.setVisible(false);
    }
    
    private void Reiniciar(){
        Apagar.setVisible(false);
        Acelerar.setVisible(false);
        Mantener.setVisible(false);
        Reiniciar.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Apagar = new javax.swing.JLabel();
        Acelerar = new javax.swing.JLabel();
        Mantener = new javax.swing.JLabel();
        Reiniciar = new javax.swing.JLabel();
        Caja = new javax.swing.JLabel();
        botonApagar = new javax.swing.JButton();
        botonAcelerar = new javax.swing.JButton();
        botonMantener = new javax.swing.JButton();
        botonReiniciar = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Apagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marchas.png"))); // NOI18N
        add(Apagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 70, 70));

        Acelerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marchas.png"))); // NOI18N
        add(Acelerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 70, 70));

        Mantener.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marchas.png"))); // NOI18N
        add(Mantener, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        Reiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marchas.png"))); // NOI18N
        add(Reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        Caja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caja.png"))); // NOI18N
        add(Caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        botonApagar.setText("Apagar");
        add(botonApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        botonAcelerar.setText("Acelerar");
        add(botonAcelerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        botonMantener.setText("Mantener");
        add(botonMantener, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        botonReiniciar.setText("Reiniciar");
        add(botonReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Acelerar;
    private javax.swing.JLabel Apagar;
    private javax.swing.JLabel Caja;
    private javax.swing.JLabel Mantener;
    private javax.swing.JLabel Reiniciar;
    private javax.swing.JButton botonAcelerar;
    private javax.swing.JButton botonApagar;
    private javax.swing.JButton botonMantener;
    private javax.swing.JButton botonReiniciar;
    // End of variables declaration//GEN-END:variables
}
