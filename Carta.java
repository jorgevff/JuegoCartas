
/**
 * Write a description of class Carta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carta
{

    private int valor;
    private int palo;

    /**
     * Constructor for objects of class Carta
     */
    public Carta(int valorCarta, int paloCarta)
    {
        valor = valorCarta;
        palo = paloCarta;

    }

    public int getValor(){
        return valor;
    }

    public int getPalo(){
        return palo;
    }

    public String toString()
    {
        String textoADevolver = "";
        //pasar int a String
        String textoValor = Integer.toString(valor);
        String textoPalo = "";

        switch (palo){
            case 0:
            textoPalo = "oros";
            break;
            case 1:
            textoPalo = "copas";
            break;
            case 2:
            textoPalo = "espadas";
            break;
            case 3:
            textoPalo = "bastos";
            break; 

            //con la etiqueta defaut: se añade el u.timo
        }

        /**
        if (palo == 0){
        textoPalo = "oros";
        }
        else if (palo == 1){
        textoPalo = "copas";
        }
        else if (palo == 2){
        textoPalo = "espadas";
        }
        else if (palo == 3){
        textoPalo = "bastos";
        }
         * 
         */

        if (valor == 1){
            textoPalo = "As";
        }
        else if (palo == 10){
            textoPalo = "sota";
        }
        else if (palo == 11){
            textoPalo = "caballo";
        }
        else if (palo == 12){
            textoPalo = "Rey";
        } 
        return textoADevolver = textoValor + " de " + textoPalo;
    }

    public boolean ganaA(Carta cartaAComparar, int paloQuePinta)
    {
        boolean gana = false;

        if (palo == cartaAComparar.getPalo()) {
            // En caso de que tengan el mismo pelo...
            if (getPosicionEscalaTute() > cartaAComparar.getPosicionEscalaTute()) {
                gana = true;
            }
        }
        else {
            // En caso de que tengan distinto pelo...
            if (cartaAComparar.getPalo() != paloQuePinta) {
                gana = true;
            }
        } 

        return gana;
    }

    public int getPosicionEscalaTute() 
    {
        int posicion = valor;

        if (valor == 3) {
            posicion = 13;
        }
        else if (valor == 1) {
            posicion = 14;
        }

        return posicion;    
    }

}
