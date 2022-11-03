package proyecto.ruleta.rusa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Juego {

    NodoCircular jugadores;
    LinkedList<Jugador> eliminados;
    LinkedList<String> cedulaEliminados;
    Jugador ganador;
    boolean posibleganador = false;

    public Juego(File f) {
        jugadores = new NodoCircular();
        eliminados = new LinkedList<>();
        cedulaEliminados = new LinkedList<>();
        ganador = null;
        String[] placeholder = new String[3];
        try {
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine()) {
                placeholder = scan.nextLine().split(" ");
                placeholder[1] = placeholder[1].replace('_', ' ');
                jugadores.insertarFinal(new Jugador(placeholder[0], placeholder[1], Integer.parseInt(placeholder[2])));
            }
        } catch (FileNotFoundException ex) {

        }
    }

    public Juego jugar() {
        NodoJugador puntero;
        while (!jugadores.esVacio() && jugadores.tamaño != 1) {
            puntero = jugadores.getprin();
            puntero.getJugador().aumentarContadorRondas();
            if (puntero.getJugador().jugar()) {
                if (puntero.getSiguiente().equals(jugadores.getprin())) {
                    cedulaEliminados.add(jugadores.getprin().getJugador().datosPersonales.getCedula());
                    eliminados.add(jugadores.getprin().getJugador());

                } else {
                    cedulaEliminados.add(puntero.getSiguiente().getJugador().datosPersonales.getCedula());
                    eliminados.add(puntero.getSiguiente().getJugador());
                }
            }
            puntero = puntero.getSiguiente();
            while (!(puntero.equals(jugadores.getprin()))) {
                puntero.getJugador().aumentarContadorRondas();
                if (puntero.getJugador().jugar()) {
                    if (puntero.getSiguiente().equals(jugadores.getprin())) {
                        cedulaEliminados.add(jugadores.getprin().getJugador().datosPersonales.getCedula());
                        eliminados.add(jugadores.getprin().getJugador());

                    } else {
                        cedulaEliminados.add(puntero.getSiguiente().getJugador().datosPersonales.getCedula());
                        eliminados.add(puntero.getSiguiente().getJugador());
                    }
                }
                puntero = puntero.getSiguiente();
            }

            if (!cedulaEliminados.isEmpty()) {
                cedulaEliminados.forEach((e) -> {
                    jugadores.eliminarID(e);
                });
            }
            cedulaEliminados.clear();
        }

        if (jugadores.esVacio()) {
            posibleganador = false;
        } else {
            ganador = jugadores.getprin().getJugador();
            posibleganador = true;
        }

        return this;
    }

    public boolean posibleganador() {
        return posibleganador;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public LinkedList<Jugador> getPerdedores() {
        return eliminados;
    }
}
