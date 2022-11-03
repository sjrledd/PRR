package proyecto.ruleta.rusa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class InicioJuego {

    public boolean verificarEntrada(File f) {
        try {
            if (f.exists()) {

                if (f.length() != 0) {
                    LinkedList<String> cedulas = new LinkedList<>();
                    String temp[];
                    Scanner scr = new Scanner(f);

                    while (scr.hasNextLine()) {
                        temp = scr.nextLine().split(" ");
                        if (temp.length != 3) {
                            System.out.println("Sin Formato.");

                            return false;
                        } else {
                            try {
                                if (Integer.parseInt(temp[2]) < 0) {
                                    System.out.println("La edad en años de algun jugador es un numero negativo.");
                                    return false;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("La edad de algún jugador en el archivo no es un número.");
                                return false;
                            }
                            if (temp[0].isEmpty()) {
                                System.out.println("Cedula nula, no permitida.");
                                return false;
                            } else {
                                cedulas.add(temp[0]);
                            }
                        }
                    }
                    for (String e : cedulas) {
                        if (Collections.frequency(cedulas, e) > 1) {
                            System.out.println("Uno o más jugadores tienen una cedula repetida.");
                            return false;
                        }
                    }
                } else {
                    System.out.println("El archivo de entrada está vacío.");
                    return false;
                }

            } else {
                System.out.println("El archivo de entrada no ha sido creado.");
                return false;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo de entrada.");
            return false;
        }
        return true;
    }
}
