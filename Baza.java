
/**
 * Write a description of class Baza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baza
{
    // 
    private Carta[] baza;
    private int numeroJugadores;
    private int paloQuePinta;
    private int cartaEnMesa;

    /**
     * 
     */
    public Baza(int numeroJugadores, int paloQuePinta)
    {

        this.paloQuePinta = paloQuePinta;
        cartaEnMesa = 0;
        baza = new Carta[numeroJugadores];

    }

    /**
     * 
     */
    public void addCarta(Carta cartaTiradaEnMesa, String nombreJugador)
    {

        baza[0] = cartaTiradaEnMesa;

    }
    public int getPaloPrimeraCartaDeLaBaza(){
        int valorDevolver = -1;
        if(baza[0] != null){
            valorDevolver = baza[0].getPalo();
     
        }

        return valorDevolver;

    }
}
