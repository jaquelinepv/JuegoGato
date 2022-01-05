import java.util.Arrays;

public class Tablero {
    private char[] estadoDelJuego = new char[9];

    public Tablero() {
        Arrays.fill(estadoDelJuego, '-');
    }
    public void asignarCaracter(char ficha, int posicion){
        estadoDelJuego[posicion-1]=ficha;
    }

    @Override
    public String toString() {
        String temp=new String("");
        for (int i=0; i<estadoDelJuego.length; i++){
            temp+=(estadoDelJuego[i]);
            temp+=(" ");
            if ((i+1)%3==0){
                temp+=("\n");
            }
        }return temp;
    }
    public boolean casillaNoOcupada(int posicion){
        return estadoDelJuego[posicion-1]=='-';
    }

    public boolean quienGana(char caracter){
        boolean terminar=false;
        for(int i=0; i<3; i++){
            if((estadoDelJuego[i * 3]==caracter&&estadoDelJuego[i * 3 + 1]==caracter&&estadoDelJuego[i * 3 + 2]==caracter) ||
                    (estadoDelJuego[i]==caracter&&estadoDelJuego[i+3]==caracter&&estadoDelJuego[i+6]==caracter) ) {
                terminar=true;
            }
        }

        if((estadoDelJuego[0]==caracter&&estadoDelJuego[4]==caracter&&estadoDelJuego[8]==caracter) ||
                (estadoDelJuego[2]==caracter&&estadoDelJuego[4]==caracter&&estadoDelJuego[6]==caracter)) {
               terminar=true;
        }
        return terminar;
    }



}
