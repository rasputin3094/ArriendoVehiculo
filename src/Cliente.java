
public class Cliente {

    private String cedula;
    private String nombre;
    private boolean vigente;

    public Cliente(String cedula, String nombre) {
        if (validarRut(cedula)) {
            this.cedula = cedula;
        } else {
            mostrarMensaje("RUT inválido");
        }
        this.nombre = nombre;
        this.vigente = true;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void deshabilitar() {
        this.vigente = false;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("[Cliente] " + mensaje);
    }

    private boolean validarRut(String rut) {
        rut = rut.toUpperCase().replace(".", "").replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
        char dv = rut.charAt(rut.length() - 1);

        int m = 0, s = 1;
        while (rutAux != 0) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            rutAux /= 10;
        }
        char dvEsperado = (char) (s != 0 ? s + 47 : 75);
        return dv == dvEsperado;
    }
}
