
public class Vehiculo {

    private String patente;
    private String marca;
    private String modelo;
    private int añoFabricacion;
    private char condicion; // D, A, M

    public Vehiculo(String patente, String marca, String modelo, int añoFabricacion) {
        if (patente != null && patente.length() == 8) {
            this.patente = patente.toUpperCase();
        } else {
            mostrarMensaje("Patente inválida");
        }

        this.marca = marca.toUpperCase();
        this.modelo = modelo.toUpperCase();

        if (añoFabricacion >= 2000 && añoFabricacion <= java.time.Year.now().getValue()) {
            this.añoFabricacion = añoFabricacion;
        } else {
            mostrarMensaje("Año de fabricación inválido");
        }

        this.condicion = 'D';
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public char getCondicion() {
        return condicion;
    }

    public void setCondicion(char condicion) {
        if (condicion == 'D' || condicion == 'A' || condicion == 'M') {
            this.condicion = condicion;
        } else {
            mostrarMensaje("Condición inválida");
        }
    }

    public boolean asignarMantencion() {
        if (this.condicion == 'D') {
            this.condicion = 'M';
            return true;
        } else {
            mostrarMensaje("No se puede asignar mantención. Vehículo no disponible.");
            return false;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("[Vehiculo] " + mensaje);
    }
}
