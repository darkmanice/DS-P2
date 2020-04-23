package Modelo.velocidad;
import Modelo.velocidad.Estado;

public class FiltroRepercutirRozamiento implements Filtro {
    private static final double ROZAMIENTO = 0.01;
    
    @Override
    public double ejecutar(double revoluciones, Estado estadoMotor){
        
        return (revoluciones*(1-ROZAMIENTO));
    }
}