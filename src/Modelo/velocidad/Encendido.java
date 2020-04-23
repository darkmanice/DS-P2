package Modelo.velocidad;

public class Encendido extends Estado{
    private boolean puedeMantener;
    protected Encendido(Vehiculo vehiculo){
        super(vehiculo, EstadoMotor.ENCENDIDO);
        puedeMantener = false;
    }
    
    public boolean encender(){
        return false;
    }
        
    public boolean apagar(){
        Estado apagado = new Apagado(getVehiculo());
        Vehiculo vehiculo1 = getVehiculo();
        vehiculo1.cambiarEstado(apagado);
        
        return true;
    }
    
    public boolean acelerar(Componentes componente1){
        Estado acelerar = new Acelerando(getVehiculo(), componente1);
        Vehiculo vehiculo1 = getVehiculo();
        vehiculo1.cambiarEstado(acelerar);
        
        return true;
    }
    
    public boolean mantener(){
        if (puedeMantener){
            Estado manteniendo = new Manteniendo(getVehiculo());
            Vehiculo vehiculo1 = getVehiculo();
            vehiculo1.cambiarEstado(manteniendo);
        }
        return puedeMantener;
    }
    
    public void puedeMantener(){
        puedeMantener = true;
    }
    
    public boolean frenar(){
        Estado frenar = new Frenando(getVehiculo());
        Vehiculo vehiculo1 = getVehiculo();
        vehiculo1.cambiarEstado(frenar); 
        
        return true;
    }
}
