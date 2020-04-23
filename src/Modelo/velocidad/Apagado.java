package Modelo.velocidad;

public class Apagado extends Estado{
    protected Apagado(Vehiculo vehiculo){
        super(vehiculo, EstadoMotor.APAGADO);
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
    
    public boolean frenar(){
        return false;
    }
    
    public boolean mantener(){
        return false;
    }
}
