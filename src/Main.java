
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");

        System.out.println("=== CREAR CLIENTE ===");
        Cliente cliente = new Cliente("12345678-5", "Juan Pérez");
        cliente.mostrarMensaje("Datos cliente: RUT = " + cliente.getCedula() + ", Nombre = " + cliente.getNombre());
        cliente.mostrarMensaje("Vigente: " + cliente.isVigente());

        System.out.println("\n=== CREAR VEHÍCULO ===");
        Vehiculo vehiculo = new Vehiculo("ABCD1234", "Toyota", "Corolla", 2018);
        vehiculo.mostrarMensaje("Datos vehículo: Patente = " + vehiculo.getPatente()
                + ", Marca = " + vehiculo.getMarca()
                + ", Modelo = " + vehiculo.getModelo()
                + ", Año = " + vehiculo.getAñoFabricacion()
                + ", Condición = " + vehiculo.getCondicion());

        System.out.println("\n=== DESHABILITAR CLIENTE ===");
        cliente.deshabilitar();
        cliente.mostrarMensaje("Estado vigente después de deshabilitar: " + cliente.isVigente());

        System.out.println("\n=== ASIGNAR MANTENCIÓN VEHÍCULO ===");
        vehiculo.asignarMantencion();
        vehiculo.mostrarMensaje("Condición después de asignar mantención: " + vehiculo.getCondicion());

        System.out.println("\n=== ARRIENDO VÁLIDO ===");
        Vehiculo vehiculo2 = new Vehiculo("XYZW5678", "Nissan", "Versa", 2020);
        vehiculo2.mostrarMensaje("Datos vehículo: Patente = " + vehiculo2.getPatente()
                + ", Marca = " + vehiculo2.getMarca()
                + ", Modelo = " + vehiculo2.getModelo()
                + ", Año = " + vehiculo2.getAñoFabricacion()
                + ", Condición = " + vehiculo2.getCondicion());

        Cliente cliente2 = new Cliente("18927672-9", "Ana Gómez");
        cliente2.mostrarMensaje("Datos cliente: RUT = " + cliente2.getCedula() + ", Nombre = " + cliente2.getNombre());
        cliente2.mostrarMensaje("Vigente: " + cliente2.isVigente());

        Arriendo arriendo1 = new Arriendo(1, vehiculo2, cliente2, LocalDate.now(), 3, 45000);
        arriendo1.mostrarMensaje("Datos arriendo: Número = " + arriendo1.getNumeroArriendo()
                + ", Fecha = " + arriendo1.getFechaArriendo()
                + ", Días = 3, Precio diario = 45000");

        if (arriendo1.ingresarArriendo()) {
            arriendo1.generarTicket();
            vehiculo2.mostrarMensaje("Condición vehículo después de arriendo: " + vehiculo2.getCondicion());
        }

        System.out.println("\n=== ARRIENDO INVÁLIDO ===");
        Arriendo arriendo2 = new Arriendo(2, vehiculo, cliente, LocalDate.now(), 2, 40000);
        arriendo2.mostrarMensaje("Intentando arriendo con cliente deshabilitado y vehículo en mantención...");
        arriendo2.ingresarArriendo();

        System.out.println("\n=== DEVOLUCIÓN VÁLIDA ===");
        Devolucion devolucion1 = new Devolucion(arriendo1, LocalDate.now().plusDays(3));
        if (devolucion1.ingresarDevolucion()) {
            devolucion1.mostrarMensaje("Devolución registrada correctamente.");
        }
        vehiculo2.mostrarMensaje("Condición vehículo después de devolución: " + vehiculo2.getCondicion());

        System.out.println("\n=== DEVOLUCIÓN INVÁLIDA ===");
        Devolucion devolucion2 = new Devolucion(arriendo1, LocalDate.now().minusDays(1));
        devolucion2.ingresarDevolucion();
    }
}
