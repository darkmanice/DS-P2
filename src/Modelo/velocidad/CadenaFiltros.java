package Modelo.velocidad;
import Modelo.monitorizacion.Salpicadero;

import java.util.ArrayList;
import Modelo.monitorizacion.Salpicadero;
public class CadenaFiltros {
    private ArrayList<Filtro> cadenaFiltros;
    public CadenaFiltros(){
        cadenaFiltros = new ArrayList<Filtro>();
    }
    
    public void aniadeFiltro(Filtro filtro){
        cadenaFiltros.add(filtro);
    }
    
    public double ejecutar(Salpicadero salpicadero){
        double rpm = salpicadero.getVelocidadAngular();
        for (int i=0; i<cadenaFiltros.size(); i++){
            rpm = cadenaFiltros.get(i).ejecutar(rpm, salpicadero.getEstadoMotor());
        }
        return salpicadero.ejecutar(rpm, salpicadero.getEstadoMotor());
    }
}