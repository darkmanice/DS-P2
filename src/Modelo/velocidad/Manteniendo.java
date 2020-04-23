package Modelo.velocidad;

public class Manteniendo extends Estado{
    protected Manteniendo(Vehiculo vehiculo){
        super(vehiculo, EstadoMotor.MANTENIENDO);
    }
    
    public boolean encender(){
        Estado encendido = new Encendido(getVehiculo());
        Vehiculo vehiculo1 = getVehiculo();
        vehiculo1.cambiarEstado(encendido);
        
        return true;
    }
    
    public boolean apagar(){
        return false;
    }
    
    public boolean acelerar(Componentes componente1){
        return false;
    }
        
    public boolean mantener(){
        return false;
    }
    
    public boolean frenar(){
        Estado frenar = new Frenando(getVehiculo());
        Vehiculo vehiculo1 = getVehiculo();
        vehiculo1.cambiarEstado(frenar); 
        
        return true;
    }
    
    public double getVelocidadAngularCrucero(){
        return getVehiculo().getVelocidadAngularCrucero();
    }
}
