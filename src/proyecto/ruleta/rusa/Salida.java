package proyecto.ruleta.rusa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Salida {

    Jugador ganador;
    boolean posibleganador;
    LinkedList<Jugador> perdedores;

    public Salida(Juego juego) {
        if (juego.posibleganador()) {
            posibleganador = true;
            ganador = juego.getGanador();
        }
        perdedores = juego.getPerdedores();
    }

    public void imprimirGanador(File archivoGanador) throws IOException {

        //crear archivo de salida
        if (archivoGanador.createNewFile()) {
            System.out.println("Archivo de ganador creado. Llenando...");
        } else {
            System.out.println("Archivo de ganador ya existente. Sobrescribiendo...");
            archivoGanador.delete();
            archivoGanador.createNewFile();
        }
        FileWriter fw = new FileWriter(archivoGanador);
        if (posibleganador) {
            fw.write(ganador.toString());
        } else {
            fw.write("No hubo un ganador. Los jugadores restantes perdieron al mismo tiempo.");
        }
        fw.close();
    }

    public void imprimirPerdedores(File archivoPerdedores) throws IOException {

        if (archivoPerdedores.createNewFile()) {
            System.out.println("Archivo de perdedores creado. Llenando...");
        } else {
            System.out.println("Archivo de perdedores ya existente. Sobrescribiendo...");
            archivoPerdedores.delete();
            archivoPerdedores.createNewFile();
        }
        FileWriter fw = new FileWriter(archivoPerdedores);
        for (Jugador e : perdedores) {
            fw.write(e.toString());
            fw.write(System.getProperty("line.separator"));
        }
        fw.close();
    }
}

