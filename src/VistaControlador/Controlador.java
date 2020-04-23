package VistaControlador;
import Modelo.monitorizacion.Salpicadero;
import Modelo.velocidad.Vehiculo;
import Modelo.velocidad.Componentes;
import Modelo.velocidad.EstadoMotor;
import Modelo.velocidad.PosicionPalanca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
    private Vehiculo vehiculo;
    private Vista vista;
    private Salpicadero salpicadero;
    
    Controlador(){
        vehiculo = new Vehiculo();
     
        vista = new Vista(vehiculo);
        salpicadero = new Salpicadero(vehiculo, vista.getVelocimetro(), vista.getCuentakilometros(), vista.getCuentarrevoluciones(), vista.getMonitorEstado());
        
        vehiculo.setSalpicadero(salpicadero);
        vehiculo.getPalanca().setPalancaInterfaz(vista.getPalanca());
        vista.getPalanca().getApagar().addActionListener(this);
        vista.getPalanca().getAcelerar().addActionListener(this);
        vista.getPalanca().getMantener().addActionListener(this);
        vista.getPalanca().getReiniciar().addActionListener(this);
        
        vista.getPedales().getFrenar().addActionListener(this);
        vista.getPedales().getAcelerar().addActionListener(this);
        
        vista.getLlaveContacto().getEncender().addActionListener(this);
        
        vehiculo.comenzar();
    }
    
    
    public void actionPerformed(ActionEvent evento) {
        boolean exito = false;
        
        if (vista.getPalanca().getApagar() == evento.getSource()){
            if (!vehiculo.getLlaveContacto().apagado()){
                exito = vehiculo.encender();
                
                if(exito){
                    if(vehiculo.hayVelocidadCrucero())
                        actualizarBotones(true, false, false, true, true, true, true);
                    else
                        actualizarBotones(true, false, false, false, true, true, true);
                }
            }
        } else if (vista.getPalanca().getAcelerar() == evento.getSource()){
            exito = vehiculo.acelerar(Componentes.PALANCA);
            
            if(exito){
                if(vehiculo.hayVelocidadCrucero())
                    actualizarBotones(false, true, true, true, false, true, false);
                else
                    actualizarBotones(false, true, true, false, false, true, false);
            }
        } else if (vista.getPalanca().getMantener() == evento.getSource()){
            exito = vehiculo.mantener();
            
            
            if(exito){
                actualizarBotones(false, false, true, false, false, true, false);              
            }
        } else if (vista.getPalanca().getReiniciar() == evento.getSource()){
            exito = vehiculo.reiniciar();
            
            if(exito){
                if (vehiculo.getPalanca().getPosicion() == PosicionPalanca.REINICIAR){
                    actualizarBotones(false, false, false, false, false, true, false);  
                }
                else{
                    actualizarBotones(false, false, true, false, false, true, false);
                }
            }
        } else if (vista.getPedales().getFrenar() == evento.getSource()){
            if (vehiculo.getPedales().frenoPisado()){
                vehiculo.getPedales().soltarFreno();
                exito = vehiculo.encender();
                
                if(exito){
                    if(vehiculo.hayVelocidadCrucero())
                        actualizarBotones(true, false, false, true, true, true, true); 
                    else
                        actualizarBotones(true, false, false, false, true, true, true); 
                }
            }
            else{
                exito = vehiculo.frenar();

                if(exito){
                    if (vehiculo.getEstadoMotor().getEstado() == EstadoMotor.ENCENDIDO){ //Se encontraba reiniciando
                        actualizarBotones(true, false, false, true, true, true, true);
                    }
                    else {
                        actualizarBotones(false, false, false, false, false, true, false);
                    } 
                }
            }
        } else if (vista.getPedales().getAcelerar() == evento.getSource()){
            if (vehiculo.getPedales().aceleradorPisado()){
                vehiculo.getPedales().soltarAcelerador();
                exito = vehiculo.encender();
                
                if(exito){
                    if(vehiculo.hayVelocidadCrucero())
                        actualizarBotones(true, false, false, true, true, true, true);
                    else
                        actualizarBotones(true, false, false, false, true, true, true);
                }
            }
            else{
                exito = vehiculo.acelerar(Componentes.PEDALES);

                if(exito){
                    actualizarBotones(true, false, false, false, true, false, false);
                }
            }
        } else if (vista.getLlaveContacto().getEncender() == evento.getSource()){
            if (vehiculo.getLlaveContacto().apagado()){
                vehiculo.getLlaveContacto().encender();
                exito = vehiculo.encender();
                
                if(exito)
                    actualizarBotones(true, false, false, false, true, true, true);
            }
            else{
                vehiculo.getLlaveContacto().apagar();
                exito = vehiculo.apagar();
                
                if(exito)
                    actualizarBotones(false, false, false, false, false, false, true);
                    vista.getCuentakilometros().setReciente(0);
                    vista.getMonitorVelocidadCrucero().setVelocidadCrucero(0);
            }
        }
        
        if (exito){
                vista.actualizarVista();
        }
    }
    
    
    private void actualizarBotones(boolean acelerarPalanca, boolean mantenerPalanca, boolean apagarPalanca,
                boolean reiniciarPalanca, boolean acelerar, boolean frenar, boolean encender){
        vista.getPalanca().getAcelerar().setEnabled(acelerarPalanca);
        vista.getPalanca().getMantener().setEnabled(mantenerPalanca);
        vista.getPalanca().getApagar().setEnabled(apagarPalanca);
        vista.getPalanca().getReiniciar().setEnabled(reiniciarPalanca);
        vista.getPedales().getAcelerar().setEnabled(acelerar);
        vista.getPedales().getFrenar().setEnabled(frenar);
        vista.getLlaveContacto().getEncender().setEnabled(encender);
    }

    Vista getVista(){
        return vista;
    }
}
