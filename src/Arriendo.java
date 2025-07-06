
import java.time.LocalDate;

public class Arriendo {

    private int numeroArriendo;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private LocalDate fechaArriendo;
    private int dias;
    private double precioDiario;

    public Arriendo(int numeroArriendo, Vehiculo vehiculo, Cliente cliente, LocalDate fechaArriendo, int dias, double precioDiario) {
        this.numeroArriendo = numeroArriendo;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.fechaArriendo = fechaArriendo;

        if (dias > 1 && dias < 10) {
            this.dias = dias;
        } else {
            mostrarMensaje("Número de días inválido");
        }

        this.precioDiario = precioDiario;
    }

    public int getNumeroArriendo() {
        return numeroArriendo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaArriendo() {
        return fechaArriendo;
    }

    public boolean evaluarArriendo() {
        return cliente.isVigente() && vehiculo.getCondicion() == 'D';
    }

    public boolean ingresarArriendo() {
        if (evaluarArriendo()) {
            vehiculo.setCondicion('A');
            return true;
        } else {
            mostrarMensaje("No es posible realizar arriendo");
            return false;
        }
    }

    public double obtenerMontoPagar() {
        return dias * precioDiario;
    }

    public void generarTicket() {
        System.out.println("TICKET ARRIENDO VEHÍCULO");
        System.out.println("NÚMERO: " + numeroArriendo);
        System.out.println("VEHÍCULO: " + vehiculo.getPatente() + " " + vehiculo.getMarca() + " " + vehiculo.getModelo());
        System.out.println("PRECIO DIARIO: $" + precioDiario);
        System.out.println("-----------------------------------");
        System.out.println("FECHA CLIENTE DÍAS A PAGAR");
        System.out.println(fechaArriendo + " " + cliente.getCedula() + "/" + cliente.getNombre()
                + " " + dias + " días $" + obtenerMontoPagar());
        System.out.println("-----------------------------------");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("[Arriendo] " + mensaje);
    }
}
