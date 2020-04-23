package Modelo.velocidad;

public interface Filtro {
    
    public double ejecutar(double revoluciones, Estado estadoMotor);
}