package Modelo.velocidad;

import VistaControlador.PalancaGUI;
import javax.swing.SwingUtilities;

public class Palanca extends javax.swing.JPanel {
    private PosicionPalanca posicion;
    private PalancaGUI palancaInterfaz;
    
    Palanca() {
        posicion = PosicionPalanca.APAGAR;
    }
    
    public void cambiarPosicion(PosicionPalanca pos){
        posicion = pos;
    }
    
    public PosicionPalanca getPosicion(){
        return posicion;
    }
    
    public synchronized void setPalancaInterfaz(PalancaGUI palanca){
        palancaInterfaz = palanca;
    }
    
    synchronized void actualizarInterfaz(){
        Runnable actualizarVista = new Runnable() {
            public void run() {
                palancaInterfaz.actualizarPosicion();
                palancaInterfaz.getAcelerar().setEnabled(false);
                palancaInterfaz.setEnabled(false);
                palancaInterfaz.getApagar().setEnabled(true);
                palancaInterfaz.getReiniciar().setEnabled(false);
            }
        };
        try {
            SwingUtilities.invokeAndWait(actualizarVista);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
