
public class JuegoGato {
    private static int contador;

    public static void main(String[] args) {

        char[] fichas = {'X', 'O'};
        int tabla[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Boolean terminar;
        Jugador[] jugadores = new Jugador[2];
        String nombre;
        for (int i = 0; i < 2; i++) {
            System.out.println("Nombre de jugador " + (i + 1) + ": ");
            nombre = Keyboard.readString();

            /*Se crean los objetos de tipo jugador*/
            jugadores[i] = new Jugador(nombre, fichas[i]);
            System.out.println(jugadores[i].getNombre() + " tu ficha es " + jugadores[i].getFichas() + ":");
        }
        
        System.out.println("Selecciona una posicion en el tablero: ");
        System.out.println("Las casillas marcadas con X u O ya estan ocupadas");

        //Se imprime el arreglo en forma de tablero*
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabla[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        Tablero tablero = new Tablero();
        System.out.println("Estado del juego:");
        System.out.println(tablero);

        /*Ciclo principal del juego. El juego se va a ejecutar hasta que alguien gane o se llenen todas las casillas.*/
        do{
            terminar = registrarJugada(jugadores, tablero);

        } while (!terminar);
    }
    public static boolean registrarJugada(Jugador[] jugadores, Tablero tablero) {
        boolean terminar=false;
        boolean jugadaValida=false;


        for (int i = 0; i < jugadores.length; i++) {
            int posicion;
                do {
                    System.out.println("Jugador " + jugadores[i].getNombre() + " es tu turno");
                    do {
                        System.out.println("Digite una posicion: ");
                        posicion = Keyboard.readInt();
                    }while(posicion>9||posicion<1);
                    jugadaValida= tablero.casillaNoOcupada(posicion);

                    /*Si la casilla esta disponible se asigna la nueva posición en el tablero*/
                    if (jugadaValida) {
                        System.out.println("Jugada valida");
                        contador++;
                        tablero.asignarCaracter(jugadores[i].getFichas(), posicion);
                        System.out.println(tablero);
                        terminar = tablero.quienGana(jugadores[i].getFichas());
                        if (terminar) System.out.println("Ganador: " + jugadores[i].getNombre());

                            /*Cuando el contador es mayor o igual a 9 el juego termina en empate */
                        else if (contador == 9 ) {
                                System.out.println("El juego termina en empate");
                                terminar = true;
                            }
                    }else System.out.println("Jugada no valida...");

                }while(!jugadaValida);
                if(terminar) break;
            }
        return terminar;
    }
}