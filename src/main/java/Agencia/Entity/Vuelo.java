package Agencia.Entity;
//Hotel: id, nombre, categoría, precio, disponibilidad
//
//Vuelo: id, compañía, fecha, precio, plazas disponibles
//
//Reserva: id, usuario, DNI, vuelo asociado, hotel asociado
public class Vuelo {
    private int id;
    private String compañia;
    private String fecha;
    private double precio;
    private int plazasDisponibles;

    public Vuelo(int id, String compañia, String fecha, double precio, int plazasDisponibles) {
        this.id = id;
        this.compañia = compañia;
        this.fecha = fecha;
        this.precio = precio;
        this.plazasDisponibles = plazasDisponibles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(int plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }
}
