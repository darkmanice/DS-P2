package Modelo.velocidad;


public class LlaveContacto {
    boolean apagado;
    
    LlaveContacto(){
        apagado = true;
    }
    
    public void apagar(){
        apagado = true;
    }
    
    public void encender(){
        apagado = false;
    }
    
    public boolean apagado(){
        return apagado;
    }
}
