package Modelo.velocidad;

public abstract class Reiniciar extends Estado{
    boolean ReiniciandoSCACV;
    protected Reiniciar(Vehiculo vehiculo, EstadoMotor estadoMotor){
        super(vehiculo, estadoMotor);
        ReiniciandoSCACV = false;
    }
    
    void ReiniciandoSCACV(){
        ReiniciandoSCACV = true;
    }
    void PararReiniciandoSCACV(){
        ReiniciandoSCACV = false;
    }
    boolean getReiniciandoSCACV(){
        return ReiniciandoSCACV;
    }
}
