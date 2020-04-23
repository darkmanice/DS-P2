package Modelo.monitorizacion;

import VistaControlador.Velocimetro;
import VistaControlador.MonitorEstado;
import VistaControlador.Cuentarrevoluciones;
import VistaControlador.Cuentakilometros;
import Modelo.velocidad.Vehiculo;
import Modelo.velocidad.Estado;
import Modelo.velocidad.PosicionPalanca;

import javax.swing.SwingUtilities;

public class Salpicadero extends javax.swing.JFrame {

    private HebraSalpicadero hebra;
    private Velocimetro velocimetro;
    private Cuentakilometros cuentakilometros;
    private Cuentarrevoluciones cuentarrevoluciones;
    private MonitorEstado monitorEstado;
    private double velocidadAngular;
    private double velocidadLineal;
    private double distanciaRecorrida;
    private double distanciaTotal;
    private Vehiculo vehiculo;
    private static final double RADIO = 0.15; 
    
    public Salpicadero(Vehiculo unVehiculo, Velocimetro vel, Cuentakilometros cuentaKm, Cuentarrevoluciones cuentaRev, MonitorEstado monitor) {
        distanciaRecorrida = 0.0;
        velocidadAngular = 0.0;
        velocidadLineal = 0.0;
        distanciaTotal = 0.0;
        vehiculo = unVehiculo;
        
        hebra = new HebraSalpicadero(this);
        velocimetro = vel; 
        cuentakilometros = cuentaKm;
        cuentarrevoluciones = cuentaRev;
        monitorEstado = monitor;
        actualizarSalpicadero();

    }

    public void comenzarMedicionSalpicadero(){
        hebra.start();
    }
    
    
    public double getVelocidadAngular(){
        return velocidadAngular;
    }
    
    public double getVelocidadLineal(){
        return velocidadLineal;
    }
    
    public double getDistanciaRecorrida(){
        return distanciaRecorrida;
    }
    
    public void resetDistanciaRecorrida(){
        distanciaRecorrida = 0.0;
    }
    
    public Estado getEstadoMotor(){
        return vehiculo.getEstadoMotor();
    }
    public void actualizarSalpicadero(){
        
        Runnable actualizarVista = new Runnable() {
            public void run() {
                velocimetro.actualizaVelocidad(velocidadLineal);
                cuentakilometros.setReciente(distanciaRecorrida);
                cuentakilometros.setTotal(distanciaTotal);
                cuentarrevoluciones.actualizaRevoluciones(velocidadAngular);
                monitorEstado.actualizarEstado(vehiculo.getEstadoMotor().getEstado());
            }
        };
        try {
            SwingUtilities.invokeAndWait(actualizarVista);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public double ejecutar(double revoluciones, Estado estadoMotor){
        velocidadAngular = revoluciones; 
        velocidadLineal = 2*Math.PI*RADIO*velocidadAngular*(60.0/1000.0);
        
        double avance = velocidadLineal/3600.0;
        distanciaRecorrida = distanciaRecorrida + avance;
        distanciaTotal = distanciaTotal + avance;
        
        return velocidadAngular;
    }
}