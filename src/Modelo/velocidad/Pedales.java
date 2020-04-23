package Modelo.velocidad;


public class Pedales {
    Pedal acelerador;
    Pedal freno;
    
    Pedales(){
        acelerador = new Pedal();
        freno = new Pedal();
    }
        public boolean pisarFreno(){
        boolean correcto = false;
        if (!acelerador.pedalPisado()){
            freno.pisarPedal();
            correcto = true;
        }
        return correcto;
    }
    public boolean pisarAcelerador(){
        boolean correcto = false;
        if (!freno.pedalPisado()){
            acelerador.pisarPedal();
            correcto = true;
        }
        return correcto;
    }
    public void soltarFreno(){
        freno.dejarDePisarPedal();
    }
    public void soltarAcelerador(){
        acelerador.dejarDePisarPedal();
    }
    
    public boolean frenoPisado(){
        return freno.pedalPisado();
    }
    public boolean aceleradorPisado(){
        return acelerador.pedalPisado();
    }
    
}
