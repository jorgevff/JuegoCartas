
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Carta[] nuevaCarta;
    private int numeroCartaEnLaMano;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre)
    {
        // initialise instance variables
        this.nombre = nombre;
        nuevaCarta = new Carta[5];
        numeroCartaEnLaMano = 0;
    }

    /**
     *  
     */
    public void recibirCarta(Carta cartaRecibida)
    
    {
        if (numeroCartaEnLaMano < 5){
            nuevaCarta[numeroCartaEnLaMano] = cartaRecibida;
            numeroCartaEnLaMano++;
        }
        

    }
    public void verCartaJugador(){
        int indice = 0;
        while (indice < nuevaCarta.length){
            if (nuevaCarta[indice] != null){
                System.out.println(nuevaCarta[indice]);
                indice++;
            }
        }

    }
    
    public String nombreJugador(){
        
        return nombre;
        
    }
    
    /**
     * metodo que devuelve la carta especificada oomo parametro
     * si el jugador dispone de ella y simula que se lanza a la mesa.
     * el metodo muestra el nombre del jugador por pantalla y la carta tirada
     * y devuelve la carta tirada, si no ahi carta devuelve null
     */
    
    public Carta tirarCarta(String nombreCarta){
    
        Carta cartaTirada = null;
        
        if (numeroCartaEnLaMano > 0){
            
            int cartaActual = 0;
            boolean buscando = true;
            while (cartaActual < nuevaCarta.length && buscando){
                
                if (nombreCarta.equals(nuevaCarta[cartaActual].toString())){
                    buscando = false;
                    cartaTirada = nuevaCarta[cartaActual];
                    nuevaCarta[cartaActual] = null;
                    numeroCartaEnLaMano--;
                    System.out.println(nombre + " ha tirado " + cartaTirada);
                }
                cartaActual++;
            }
        }
        
        
        return cartaTirada;
    
    
    
    
    }


}
