package Modelo.velocidad;


public class FiltroCalcularVelocidad implements Filtro {
    private static final double MAXVELOCIDAD = 5000.0; //RPM
    private static final double incrementoVelocidad = 100.0;
    private static final double mantenerVelocidad = 50.0;
    
    @Override
    public double ejecutar(double revoluciones, Estado estadoMotor){
        
        double velocidad = revoluciones;
        
        if (estadoMotor.getEstado() == EstadoMotor.ACELERANDO){
            velocidad = velocidad + incrementoVelocidad;
            if (velocidad > MAXVELOCIDAD)
                velocidad = MAXVELOCIDAD;
        } else if (estadoMotor.getEstado() == EstadoMotor.FRENANDO){
            velocidad = velocidad - incrementoVelocidad;
            if (velocidad < 0)
                velocidad = 0;
        } else if (estadoMotor.getEstado() == EstadoMotor.MANTENIENDO){
            if (((Manteniendo) estadoMotor).getVelocidadAngularCrucero() - revoluciones > mantenerVelocidad){
                velocidad = velocidad + mantenerVelocidad;
            }
        }
        
        return velocidad;
    }
}