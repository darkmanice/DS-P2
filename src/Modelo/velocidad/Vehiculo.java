package Modelo.velocidad;
import Modelo.monitorizacion.Salpicadero;


public class Vehiculo {
    private Estado estado;
    private double velocidadAngularCrucero;
    private double velocidadLinealCrucero;
    private Palanca palanca;
    private Pedales pedales;
    private LlaveContacto llave;
    private Salpicadero salpicadero;
    private HebraActualizar hebra;
    
    public Vehiculo(){
        velocidadLinealCrucero = 0.0;
        velocidadAngularCrucero = 0.0;
        
        palanca = new Palanca();
        pedales = new Pedales();
        llave = new LlaveContacto();
        estado = new Apagado(this);
        
        hebra = new HebraActualizar(this);
    }
    
    Salpicadero getSalpicadero(){
        return salpicadero;
    }
    public void setSalpicadero(Salpicadero salp){
        salpicadero = salp;
    }
    
    public void cambiarEstado(Estado estado1){
        estado = estado1;
    }
    
    public double getVelocidadCrucero(){ //Lineal
        return velocidadLinealCrucero;
    }
    
    synchronized double getVelocidadAngularCrucero(){
        return velocidadAngularCrucero;
    }
    
    public void memorizarVelocidad(double revolucionesActuales, double velocidadLinealActual){
        velocidadLinealCrucero = velocidadLinealActual;
        velocidadAngularCrucero = revolucionesActuales;
    }
    
    public boolean hayVelocidadCrucero(){
        boolean velocidad = true;
        
        if(velocidadAngularCrucero == 0.0)
            velocidad = false;

        return velocidad;
    }
    
    public void resetVelocidadCrucero(){
        velocidadLinealCrucero = 0.0;
        velocidadAngularCrucero = 0.0;
    }
    
    public Estado getEstadoMotor(){
        return estado;
    }
    

    public Palanca getPalanca(){
        return palanca;
    }
    
    public Pedales getPedales(){
        return pedales;
    }
    
    public LlaveContacto getLlaveContacto(){
        return llave;
    }
    
    public boolean encender(){
        boolean correcto = false;
        if (!pedales.frenoPisado() && !pedales.aceleradorPisado()){
        correcto = estado.encender();
            if (correcto){
                llave.encender();

                if (palanca.getPosicion() != PosicionPalanca.APAGAR){
                    palanca.cambiarPosicion(PosicionPalanca.APAGAR);
                }
            }
        }
        return correcto;
    }
    
    public boolean apagar(){
        boolean correcto = estado.apagar();
        if (correcto){
            llave.apagar();
            resetVelocidadCrucero();
        }
        
        return correcto;
    }
    
    public boolean acelerar(Componentes componente){
        boolean pisandoAcelerador = false;
        if (estado.getEstado() == EstadoMotor.ACELERANDO){
            pisandoAcelerador = ((Acelerando) estado).getComponente() == Componentes.PEDALES;
        }
        
        boolean correcto = false;
        correcto = estado.acelerar(componente);
        
        if (correcto){
            if (componente == Componentes.PEDALES){
                pedales.pisarAcelerador();
            }
            else if (componente == Componentes.PALANCA){
                palanca.cambiarPosicion(PosicionPalanca.ACELERAR);
                
                if (pisandoAcelerador){
                    pedales.soltarAcelerador();
                }
                
            }
        }
        return correcto;
    }
    
    public boolean frenar(){
        boolean correcto = estado.frenar();
        
        if (correcto){
            if(!compruebaReiniciando()){
                pedales.pisarFreno();
            }
            if (palanca.getPosicion() != PosicionPalanca.APAGAR){
                palanca.cambiarPosicion(PosicionPalanca.APAGAR);
            }
        }
        return correcto;
    }
    
    public boolean mantener(){
        if (palanca.getPosicion()== PosicionPalanca.ACELERAR){
            memorizarVelocidad(salpicadero.getVelocidadAngular(), salpicadero.getVelocidadLineal());
        }
        
        boolean correcto = estado.mantener();
        
        if (correcto){
            palanca.cambiarPosicion(PosicionPalanca.MANTENER);
            
        }
        return correcto;
    }
    
    public boolean reiniciar(){
        boolean reiniciar = false;
        boolean reiniciado = false;
        boolean estadoValido = false;
        boolean primerEstadoAcelerando = false;
        
        //Se comprueba que esta en un estado valido para reiniciar
        if (hayVelocidadCrucero()){
            if (estado.getEstado() == EstadoMotor.ENCENDIDO){
                estadoValido = true;
                ((Encendido) estado).puedeMantener();
            } else if (estado.getEstado() == EstadoMotor.ACELERANDO){
                estadoValido =  ((Acelerando) estado).getComponente() == Componentes.PALANCA;
                primerEstadoAcelerando = true;
            }
        }
        if (estadoValido){
            if (salpicadero.getVelocidadAngular() < velocidadAngularCrucero-100){ //Margen de 100
                if(primerEstadoAcelerando){
                     ((Acelerando) estado).ReiniciandoSCACV();
                }
                reiniciar = estado.acelerar(Componentes.PEDALES);
                if (!primerEstadoAcelerando){
                    ((Acelerando) estado).ReiniciandoSCACV();
                }
            } else if (salpicadero.getVelocidadAngular() > velocidadAngularCrucero){
                reiniciar = estado.frenar();
                ((Frenando) estado).ReiniciandoSCACV();
            } else{ //Si se ha reiniciado la velocidad
                reiniciado = estado.mantener();
            }
        }
        
        if (reiniciar){
            palanca.cambiarPosicion(PosicionPalanca.REINICIAR);
        } else if (reiniciado){ //Se modifica la marcha a MANTENIENDO
            palanca.cambiarPosicion(PosicionPalanca.MANTENER);
            reiniciar = true; //Operacion con exito
        }
        
        return reiniciar;
    }
    
    synchronized boolean compruebaReiniciando(){
        return palanca.getPosicion() == PosicionPalanca.REINICIAR;
    }
    
    synchronized void reiniciandoAMantener(){
        if (compruebaReiniciando()){
            //Si se ha reiniciado la velocidad
            if(estado.mantener()){
                palanca.cambiarPosicion(PosicionPalanca.MANTENER);
                palanca.actualizarInterfaz();
                
            }
        }
    }
    
    public void comenzar(){
        hebra.start();
        salpicadero.comenzarMedicionSalpicadero();
    }
}
