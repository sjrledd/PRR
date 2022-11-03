package proyecto.ruleta.rusa;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RuletaRusa {

    public static void main(String[] args) {
        File archGanador = new File("./Ganador.out");
        File archPerdedores = new File("./Perdedores.out");
        File archivoEntrada = new File("./jugadores.in");

        String selección = "";
        Scanner scr = new Scanner(System.in);
        while (true) {
            selección = menu(scr);
            if (selección.equals("A") || selección.equals("B")) {
                break;
            }
        }

        if (selección.equals("A")) {
            InicioJuego pj = new InicioJuego();
            if (pj.verificarEntrada(archivoEntrada)) {

                Juego juego = new Juego(archivoEntrada);
                juego.jugar();
                Salida s = new Salida(juego);
                try {
                    s.imprimirGanador(archGanador);
                } catch (IOException ex) {
                    System.out.println("No se pudo escribir al archivo de ganadores.");
                }
                try {
                    s.imprimirPerdedores(archPerdedores);
                } catch (IOException ex) {
                    System.out.println("No se pudo imprimir al arhivo de perdedores.");
                }
                System.out.println("Se han escrito los archivos");
            } else {
                System.out.println("Imposible iniciar el juego. Saliendo.");
            }
        }

    }

    public static String menu(Scanner scan) {
        System.out.println("Que Comience El Juego");
        System.out.println("");
        System.out.println("A. Jugar.");
        System.out.println("B. Huir.");
        System.out.println("");
        System.out.print("Opción: ");
        return scan.nextLine();
    }
}
