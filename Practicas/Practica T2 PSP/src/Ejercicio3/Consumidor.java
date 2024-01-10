package Ejercicio3;

/**
 * Esta clase Consumidor que hereda de la clase Thread va a
 * actuar como consumidor de los coches que estén en el objeto parking
 * de la clase monitor Parking, que alberga 10 aparcamientos disponibles.
 */
public class Consumidor extends Thread{

    private Parking parking;

    /**
     * Constructor por parámetros que inicializará
     * el objeto parking con el que operar.
     *
     * @param p Objeto de la clase Parking.
     */
    public Consumidor(Parking p){
        parking = p;
    }

    /**
     * El metodo run() lo ejecutará el hilo de la instancia de esta clase, este
     * llama al método consumir() y permite que salga los coches del parking.
     */
    public void run(){
        while(true){
            try {
                parking.consumir();
                System.out.println("Esta saliendo un coche del parking");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
