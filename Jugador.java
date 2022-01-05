public class Jugador {
    private String nombre;
    private char ficha;

    public Jugador(String nombre, char fichas ){
        this.nombre= nombre;
        this.ficha=fichas;
    }

    public char getFichas(){
        return ficha;
    }

    public String getNombre(){
        return nombre;
    }

}

