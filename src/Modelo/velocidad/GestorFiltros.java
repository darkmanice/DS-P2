package Modelo.velocidad;

import Modelo.monitorizacion.Salpicadero;

public class GestorFiltros {
    
    private CadenaFiltros cadenaFiltros;
    
    public GestorFiltros (){
        cadenaFiltros = new CadenaFiltros();
    }
    
    public void aniadeFiltro (Filtro filtro){
        cadenaFiltros.aniadeFiltro(filtro);
    }
    
    public double peticionFiltros(Salpicadero salpicadero){
        return cadenaFiltros.ejecutar(salpicadero);
    }
}