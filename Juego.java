import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class Juego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juego
{
    private Jugador[] jugadores;
    private Mazo mazo;
    private int pintaPalo;

   
    /**
     * Constructor se crean tantos jugadores como se especifique por parametro
     * y un mazo. Los nombres deben ser aleatorios entre un conjunto de nombres
     * no puede repetirse el mismo jugador
     */
    public Juego(int numeroJugadores, String tuNombre)
    {
        //inicializo variables mazo y en array
        mazo = new Mazo();

        jugadores = new Jugador[numeroJugadores];
        Jugador jugadorHumano = new Jugador(tuNombre);
        jugadores[0] = jugadorHumano;
        System.out.println("bienvenido " + tuNombre);

        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("Juan");
        listaJugadores.add("Pedro");
        listaJugadores.add("Luis");
        listaJugadores.add("Laura");
        listaJugadores.add("Susana");
        listaJugadores.add("Maria");
        listaJugadores.add("Jose Carlos");
        listaJugadores.add("Antonio");

        Random aleatorio = new Random();       
        for (int indice = 1; indice < numeroJugadores; indice++){
            // guardamos en una variable local un nombre aleatorio

            int posicionNombre = aleatorio.nextInt(listaJugadores.size());
            String nombreElegido = listaJugadores.get(posicionNombre);
            listaJugadores.remove(posicionNombre);

            Jugador jugador = new Jugador(nombreElegido);

            jugadores[indice] = jugador;        

        }
        System.out.println("Tus rivales son: ");
        for (int i = 1; i < jugadores.length; i++){
            System.out.println(jugadores[i].nombreJugador());

        }

    }
    /**
     * metodo repartir que coja el mazo y de 5 cartas a los jugadores creados
     * la entrega de cartas debe de ser real, primero se bajara, y luego se entrega de una en una
     * la ultima carta entregada indca el palo, que pinta, que debe de registrarse de alguna forma
     */

    public int repartir(){
        mazo.barajar();
        Carta nuevaCarta = null;
        for (int cartaARepartir = 0; cartaARepartir < 5; cartaARepartir++){
            for (int jugadorActual = 0; jugadorActual < jugadores.length; jugadorActual++){
                /**
                 * otra solucion en una linea
                 * jugadores[jugadorActual].recibirCarta(mazo.sacarCarta());
                 */
                nuevaCarta = mazo.sacarCarta();
                Jugador jugadorRecibeCarta = jugadores[jugadorActual];
                jugadorRecibeCarta.recibirCarta(nuevaCarta);
            }

        }
        /**
         * aqui queda la ultima carta
         */
        pintaPalo = nuevaCarta.getPalo();

        /**
         * imprimo el palo que pinta utilizando un switch
         * y muestro las cartas del jugador humano invocando el metodo
         * verCartasJugador()
         */
        switch (pintaPalo){
            case 0:
            System.out.println("Pintan oros");
            break;
            case 1:
            System.out.println("Pintan copas");
            break;
            case 2:
            System.out.println("Pintan espadas");
            break;
            case 3:
            System.out.println("Pintan bastos");
            break;

        }
        jugadores[0].verCartaJugador();

        return pintaPalo;

    }

    public void verCartasJugador(String nombreJugador){
        /**
         * tengo que ver las cartas una por una, tengo que comprobar primero
         * que el nombre del jugador
         */
        int jugadorActual = 0;
        boolean buscando = true;
        while (jugadorActual < jugadores.length && buscando){
            if (nombreJugador.equals(jugadores[jugadorActual].nombreJugador())){
                jugadores[jugadorActual].verCartaJugador();
                buscando = false;
            }
            jugadorActual++;
        }
    }

}
