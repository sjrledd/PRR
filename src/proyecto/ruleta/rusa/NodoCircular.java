package proyecto.ruleta.rusa;

public class NodoCircular {

    private NodoJugador prin;
    private NodoJugador secun;
    public int tamaño = 0;

    public NodoCircular() {
        prin = null;
        secun = null;
        tamaño = 0;
    }

    public void vaciar() {
        prin = null;
        secun = null;
        tamaño = 0;
    }

    public boolean esVacio() {
        return prin == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public NodoJugador getprin() {
        return prin;
    }

    public void insertarInicio(Jugador jug) {
        NodoJugador nuevoNodo = new NodoJugador(jug);
        nuevoNodo.setSiguiente(prin);
        if (prin == null) {
            prin = nuevoNodo;
            nuevoNodo.setSiguiente(prin);
            secun = prin;
        } else {
            secun.setSiguiente(nuevoNodo);
            prin = nuevoNodo;
        }
        tamaño++;
    }

    public void insertarFinal(Jugador jug) {
        NodoJugador nuevoNodo = new NodoJugador(jug);
        nuevoNodo.setSiguiente(prin);
        if (prin == null) {
            prin = nuevoNodo;
            nuevoNodo.setSiguiente(prin);
            secun = prin;
        } else {
            secun.setSiguiente(nuevoNodo);
            secun = nuevoNodo;
        }
        tamaño++;
    }

    public void eliminarPosición(int posición) {
        if (tamaño == 1 && posición == 1) {
            vaciar();
            return;
        }

        if (posición == 1) {
            prin = prin.getSiguiente();
            secun.setSiguiente(prin);
            tamaño--;
            return;
        }

        if (posición == tamaño) {
            NodoJugador puntero1 = prin;
            NodoJugador puntero2 = prin;
            while (puntero1 != secun) {
                puntero2 = puntero1;
                puntero1 = puntero1.getSiguiente();
            }
            secun = puntero2;
            secun.setSiguiente(prin);
            tamaño--;
            return;
        }

        NodoJugador puntero = prin;
        int contador = posición - 1;
        for (int i = 1; i < tamaño - 1; i++) {
            if (i == contador) {
                NodoJugador temporal = puntero.getSiguiente();
                temporal = temporal.getSiguiente();
                puntero.setSiguiente(temporal);
                break;
            }
            puntero = puntero.getSiguiente();
        }
        tamaño--;
    }

    public void eliminarID(String ID) {
        if (prin == null) {
            return;
        }
        NodoJugador puntero1 = prin;
        NodoJugador puntero2 = new NodoJugador();
        while (!(puntero1.getJugador().datosPersonales.getCedula().equals(ID))) {
            if (puntero1.getSiguiente() == prin) {
                System.out.println("Nodo no encontrado.");
                break;
            }
            puntero2 = puntero1;
            puntero1 = puntero1.getSiguiente();
        }
        if (puntero1 == prin && puntero1.getSiguiente() == prin) {
            vaciar();
        }
        if (puntero1 == prin) {
            puntero2 = prin;
            while (puntero2.getSiguiente() != prin) {
                puntero2 = puntero2.getSiguiente();
            }
            prin = puntero1.getSiguiente();
            puntero2.setSiguiente(prin);
            tamaño--;
        } else if (puntero1.getSiguiente() == prin) {
            puntero2.setSiguiente(prin);
            tamaño--;
        } else {
            puntero2.setSiguiente(puntero1.getSiguiente());
            tamaño--;
        }

    }
}
