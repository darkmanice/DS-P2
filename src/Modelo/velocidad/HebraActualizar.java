package Modelo.velocidad;


public class HebraActualizar extends Thread {
    GestorFiltros gestor;
    Vehiculo vehiculo;
    double velocidadTrasFiltros;
    
    public HebraActualizar(Vehiculo unVehiculo) {
    vehiculo = unVehiculo;
    gestor = new GestorFiltros();
    gestor.aniadeFiltro(new FiltroCalcularVelocidad());
    gestor.aniadeFiltro(new FiltroRepercutirRozamiento());
    velocidadTrasFiltros = 0.0;
    }
    
    @Override
    public void run(){
        while(true){
            if (vehiculo.compruebaReiniciando()){
                if(vehiculo.getVelocidadAngularCrucero() - velocidadTrasFiltros > 0 && vehiculo.getVelocidadAngularCrucero() - velocidadTrasFiltros <= 150)
                    vehiculo.reiniciandoAMantener();
                
            }
            try {
                Thread.sleep(1000); //Duerme
            } catch (Exception e) {
                System.out.println(e);
            }
            velocidadTrasFiltros = gestor.peticionFiltros(vehiculo.getSalpicadero());
        }
    }
}
