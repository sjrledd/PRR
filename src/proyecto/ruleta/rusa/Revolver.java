package proyecto.ruleta.rusa;

public final class Revolver {

    private final int[] balas = {1,0,0,0,0,0};
    public Revolver() {
        mezclarBalas();
    }
    public void mezclarBalas(){
        int temporal;
        int posicionAleatoria;
        for (int i = 0; i < balas.length; i++) {
            posicionAleatoria = (int)(Math.random()*6);
            temporal = balas[posicionAleatoria];
            balas[posicionAleatoria] = balas[i];
            balas[i] = temporal;
        }
    }
    
    public boolean disparar() {
        int posicion = (int)(Math.random()*6);
        boolean resultado = balas[posicion] == 1;
        mezclarBalas();
        return resultado;
    }
    
    public static void main(String[] args) {
        Revolver gun = new Revolver();
        Revolver anotherGun = new Revolver();
    }
}
