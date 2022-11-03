package proyecto.ruleta.rusa;

public class NodoJugador {

    private Jugador jugador;
    private NodoJugador siguiente;

    public NodoJugador() {
        jugador = null;
        siguiente = null;
    }

    public NodoJugador(String cedula, String nombre, int edad) {
        jugador = new Jugador(cedula, nombre, edad);
        siguiente = null;
    }

    public NodoJugador(Jugador jug) {
        jugador = jug;
        siguiente = null;
    }

    public NodoJugador(Jugador jug, NodoJugador sig) {
        jugador = jug;
        siguiente = sig;
    }

    public void setSiguiente(NodoJugador sig) {
        siguiente = sig;
    }

    public void setJugador(Jugador jug) {
        jugador = jug;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public NodoJugador getSiguiente() {
        return siguiente;
    }
}
