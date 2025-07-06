import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        Scanner sc = new Scanner(System.in);

        System.out.println("=== INGRESAR CLIENTE ===");
        System.out.print("Ingrese RUT (Ej: 12345678-5): ");
        String rutCliente = sc.nextLine();
        System.out.print("Ingrese nombre del cliente: ");
        String nombreCliente = sc.nextLine();

        Cliente cliente = new Cliente(rutCliente, nombreCliente);
        cliente.mostrarMensaje("Cliente creado: RUT = " + cliente.getCedula() + ", Nombre = " + cliente.getNombre());
        cliente.mostrarMensaje("Vigente: " + cliente.isVigente());

        System.out.println("\n=== INGRESAR VEHÍCULO ===");
        System.out.print("Ingrese patente (8 caracteres): ");
        String patente = sc.nextLine();
        System.out.print("Ingrese marca: ");
        String marca = sc.nextLine();
        System.out.print("Ingrese modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Ingrese año fabricación: ");
        int año = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, año);
        vehiculo.mostrarMensaje("Vehículo creado: Patente = " + vehiculo.getPatente() +
                ", Marca = " + vehiculo.getMarca() +
                ", Modelo = " + vehiculo.getModelo() +
                ", Año = " + vehiculo.getAñoFabricacion() +
                ", Condición = " + vehiculo.getCondicion());

        System.out.println("\n=== DESHABILITAR CLIENTE ===");
        System.out.print("¿Desea deshabilitar al cliente? (s/n): ");
        String respDeshabilitar = sc.nextLine();
        if (respDeshabilitar.equalsIgnoreCase("s")) {
            cliente.deshabilitar();
            cliente.mostrarMensaje("Vigente después de deshabilitar: " + cliente.isVigente());
        }

        System.out.println("\n=== ASIGNAR MANTENCIÓN VEHÍCULO ===");
        System.out.print("¿Desea asignar mantención al vehículo? (s/n): ");
        String respMantencion = sc.nextLine();
        if (respMantencion.equalsIgnoreCase("s")) {
            boolean ok = vehiculo.asignarMantencion();
            vehiculo.mostrarMensaje("Condición después de mantención: " + vehiculo.getCondicion());
        }

        System.out.println("\n=== INGRESAR ARRIENDO VÁLIDO ===");
        System.out.print("Ingrese patente del segundo vehículo: ");
        String patente2 = sc.nextLine();
        System.out.print("Ingrese marca: ");
        String marca2 = sc.nextLine();
        System.out.print("Ingrese modelo: ");
        String modelo2 = sc.nextLine();
        System.out.print("Ingrese año fabricación: ");
        int año2 = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Vehiculo vehiculo2 = new Vehiculo(patente2, marca2, modelo2, año2);
        vehiculo2.mostrarMensaje("Vehículo creado: Patente = " + vehiculo2.getPatente() +
                ", Marca = " + vehiculo2.getMarca() +
                ", Modelo = " + vehiculo2.getModelo());

        System.out.print("Ingrese RUT del segundo cliente: ");
        String rut2 = sc.nextLine();
        System.out.print("Ingrese nombre del segundo cliente: ");
        String nombre2 = sc.nextLine();
        Cliente cliente2 = new Cliente(rut2, nombre2);

        System.out.print("Ingrese número de arriendo: ");
        int nroArriendo = sc.nextInt();
        System.out.print("Ingrese número de días (2-9): ");
        int dias = sc.nextInt();
        System.out.print("Ingrese precio diario: ");
        double precio = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        Arriendo arriendo1 = new Arriendo(nroArriendo, vehiculo2, cliente2, LocalDate.now(), dias, precio);
        if (arriendo1.ingresarArriendo()) {
            arriendo1.generarTicket();
            vehiculo2.mostrarMensaje("Condición después de arriendo: " + vehiculo2.getCondicion());
        } else {
            arriendo1.mostrarMensaje("No fue posible registrar arriendo.");
        }

        System.out.println("\n=== INGRESAR ARRIENDO INVÁLIDO ===");
        Arriendo arriendo2 = new Arriendo(nroArriendo + 1, vehiculo, cliente, LocalDate.now(), 2, 35000);
        arriendo2.mostrarMensaje("Intentando arriendo con cliente o vehículo inválido...");
        arriendo2.ingresarArriendo();

        System.out.println("\n=== INGRESAR DEVOLUCIÓN VÁLIDA ===");
        System.out.print("Ingrese cuántos días después devolverá el vehículo: ");
        int diasDespues = sc.nextInt();
        sc.nextLine();

        Devolucion devolucion1 = new Devolucion(arriendo1, LocalDate.now().plusDays(diasDespues));
        if (devolucion1.ingresarDevolucion()) {
            devolucion1.mostrarMensaje("Devolución correcta.");
        }
        vehiculo2.mostrarMensaje("Condición después devolución: " + vehiculo2.getCondicion());

        System.out.println("\n=== INGRESAR DEVOLUCIÓN INVÁLIDA ===");
        Devolucion devolucion2 = new Devolucion(arriendo1, LocalDate.now().minusDays(1));
        devolucion2.ingresarDevolucion();

        sc.close();
    }
}
