package proyecto.ruleta.rusa;

public class Jugador {
    Personas datosPersonales;
    Revolver revolver;
    int rondasGanadas;

    public Jugador(String cedula, String nombreCompleto, int edad) {
        datosPersonales = new Personas(cedula, nombreCompleto, edad);
        revolver = new Revolver();
        rondasGanadas = 0;
    }

    public void aumentarContadorRondas() {
        rondasGanadas++;
    }

    public boolean jugar() {
        return revolver.disparar();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(datosPersonales.toString()).append("Numero de rondas jugadas: ").append(rondasGanadas).append("\n");
        return sb.toString();
    }
}
