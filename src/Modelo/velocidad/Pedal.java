package Modelo.velocidad;

public class Pedal {
    private boolean pedalPisado;
    
    Pedal(){
        pedalPisado = false;
    }
    
    void pisarPedal(){
        pedalPisado = true;
    }
    
    void dejarDePisarPedal(){
        pedalPisado = false;
    }
    
    boolean pedalPisado(){
        return pedalPisado;
    }
}
