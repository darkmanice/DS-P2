package Modelo.monitorizacion;
import Modelo.velocidad.EstadoMotor;

public class HebraSalpicadero extends Thread {
    
    private Salpicadero salpicadero;
    public HebraSalpicadero(Salpicadero salp){
        salpicadero = salp; 
    }
        
    @Override
    public void run(){
        salpicadero.actualizarSalpicadero();
        while(true){
            try {
                Thread.sleep(1000); //Duerme
            } catch (Exception e) {
                System.out.println(e);
            }
            if(salpicadero.getEstadoMotor().getEstado() == EstadoMotor.APAGADO){
                salpicadero.resetDistanciaRecorrida();
            }
            salpicadero.actualizarSalpicadero(); 
        }
    }
}