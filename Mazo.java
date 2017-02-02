import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Mazo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mazo
{
    // instance variables - replace the example below with your own
    private ArrayList<Carta> barajaCartas;

    /**
     * Constructor for objects of class Mazo
     */
    public Mazo()
    {
        barajaCartas = new ArrayList<Carta>();

        for (int paloCarta = 0;paloCarta < 4; paloCarta++){
            for (int valorCarta = 1; valorCarta <= 12; valorCarta++){
                if (valorCarta != 8 && valorCarta != 9){
                    barajaCartas.add(new Carta(valorCarta, paloCarta));
                }
            }
        }
    }

    
    public void verCartasDelMazo(){
        /**
         * para ver las cartas hay que utilizar un bucle
         * para ir mostrando todas las cartas, ahi que itilizar
         * el metodo size() del arraylist por si no hay las 40 cartas
         * 
         */

        for (int carta = 0; carta < barajaCartas.size(); carta++){
            System.out.println(barajaCartas.get(carta));
        }

    }

    public void barajar(){

        for (int posicionActual = 0; posicionActual < barajaCartas.size(); posicionActual++){
            Carta carta1 = barajaCartas.get(posicionActual);
            Random aleatorio = new Random();
            int posicionAleatoria = aleatorio.nextInt(barajaCartas.size());
            /**
             * el metodo set fija un objeto en el arraylist
             * el metodo get lo extrae
             * set(posicion se va a cambiar, el objeto que se va a cambiar a esa posicion
             */
            barajaCartas.set(posicionActual, barajaCartas.get(posicionAleatoria));
            barajaCartas.set(posicionAleatoria, carta1);

        }  

    
    }

    public Carta sacarCarta(){
        
        Carta cartaADevolver = null;
        if (barajaCartas.size() > 0){
            /**
             * el metodo remove borra y DEVUELVE EL ELEMTO BORRADO
             * por eso no hace falta añadir el metodo get
             */
            cartaADevolver = barajaCartas.remove(0);
        }
        return cartaADevolver;

    }
}
