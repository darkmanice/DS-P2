package Modelo.velocidad;

public abstract class Estado {
    private EstadoMotor estado;
    private Vehiculo vehiculo;
    
    Estado(Vehiculo vehiculo1, EstadoMotor estado1){
        vehiculo = vehiculo1;
        estado = estado1;
    }
    
    public abstract boolean encender();
    
    public abstract boolean apagar();
    
    public abstract boolean acelerar(Componentes componente1);
    
    public abstract boolean frenar();
    
    public abstract boolean mantener();
    
    public EstadoMotor getEstado(){
        return estado;
    }
    
    protected Vehiculo getVehiculo(){
        return vehiculo;
    }
}
