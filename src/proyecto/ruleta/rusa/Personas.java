package proyecto.ruleta.rusa;

public class Personas {

    private String cedula;
    private String nombreCompleto;
    private int edad;

    public Personas(String ced, String nom, int ed) {
        cedula = ced;
        nombreCompleto = nom;
        edad = ed;
    }

    public void setCedula(String ced) {
        cedula = ced;
    }

    public void setNombre(String nom) {
        nombreCompleto = nom;
    }

    public void setEdad(int ed) {
        edad = ed;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cedula: ").append(cedula).append("\n");
        sb.append("Nombre: ").append(nombreCompleto).append("\n");
        sb.append("Edad: ").append(edad).append(" años.").append("\n");
        return sb.toString();
    }
}
