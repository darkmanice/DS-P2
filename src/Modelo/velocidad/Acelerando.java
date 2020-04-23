package Modelo.velocidad;

public class Acelerando extends Reiniciar{
    private Componentes componente;
    protected Acelerando(Vehiculo vehiculo, Componentes componente1){
        super(vehiculo, EstadoMotor.ACELERANDO);
        componente = componente1;
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
        
        boolean correcto = false;
        if(!getReiniciandoSCACV()){//Si no se está reiniciando el SCACV
            if(componente == Componentes.PEDALES && componente1 == Componentes.PALANCA){
                componente = componente1;
                correcto = true;
            }
        } else{ //Reiniciando
            correcto = true;
            componente = componente1;
        }
        return correcto;
    }
    
    synchronized public boolean mantener(){   
        boolean correcto = false;
        
        if(getVehiculo().hayVelocidadCrucero() && (componente == Componentes.PALANCA || getReiniciandoSCACV())){
            Estado mantener = new Manteniendo(getVehiculo());
            Vehiculo vehiculo1 = getVehiculo();
            vehiculo1.cambiarEstado(mantener); 
            
            correcto = true;
        }
        
        return correcto;
    }
    
    public boolean frenar(){
        boolean correcto = false;
        
        if (getReiniciandoSCACV()){
            PararReiniciandoSCACV();
            correcto = encender();
        } 
        else if(componente == Componentes.PALANCA){
            Estado frenar = new Frenando(getVehiculo());
            Vehiculo vehiculo1 = getVehiculo();
            vehiculo1.cambiarEstado(frenar); 
            
            correcto = true;
        }
        
        return correcto;
    }
    
    public Componentes getComponente(){
        return componente;
    }
}
