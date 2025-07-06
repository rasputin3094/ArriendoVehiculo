
import java.time.LocalDate;

public class Devolucion {

    private Arriendo arriendo;
    private LocalDate fechaDevolucion;

    public Devolucion(Arriendo arriendo, LocalDate fechaDevolucion) {
        this.arriendo = arriendo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean ingresarDevolucion() {
        if (fechaDevolucion.isBefore(arriendo.getFechaArriendo())) {
            mostrarMensaje("Fecha devolución inválida");
            return false;
        } else {
            arriendo.getVehiculo().setCondicion('D');
            return true;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("[Devolucion] " + mensaje);
    }
}
