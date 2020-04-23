package Modelo.velocidad;

public class Frenando extends Reiniciar{
    boolean reiniciandoSCACV;
    protected Frenando(Vehiculo vehiculo){
        super(vehiculo, EstadoMotor.FRENANDO);
    }
    
    public boolean encender(){
        boolean correcto = false;
        
        if(!getReiniciandoSCACV()){
            Estado encendido = new Encendido(getVehiculo());
            Vehiculo vehiculo1 = getVehiculo();
            vehiculo1.cambiarEstado(encendido);
            correcto = true;
        }
        
        return correcto;
    }
    
    public boolean apagar(){
        return false;
    }
    
    public boolean acelerar(Componentes componente1){
        return false;
    }
    
    public boolean frenar(){
        boolean correcto = false;
        
        if (getReiniciandoSCACV()){
            PararReiniciandoSCACV();
            correcto = encender();
        }
        
        return correcto;
    }
    
    public synchronized boolean mantener(){
        boolean correcto = false;
        
        if (getVehiculo().hayVelocidadCrucero() && getReiniciandoSCACV()){
            correcto = true;
            Estado manteniendo = new Manteniendo(getVehiculo());
            Vehiculo vehiculo1 = getVehiculo();
            vehiculo1.cambiarEstado(manteniendo);
        }
        return correcto;
    }
}
