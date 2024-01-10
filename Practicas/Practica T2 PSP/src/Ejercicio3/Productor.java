package Ejercicio3;

/**
 * Esta clase Productor que hereda de la clase Thread va a
 * actuar como productor de los coches que estén en el objeto parking
 * de la clase monitor Parking, que alberga 10 aparcamientos disponibles.
 */
public class Productor extends Thread{

    private Parking parking;

    /**
     * Constructor por parámetros que inicializará
     * el objeto parking con el que operar.
     *
     * @param p Objeto de la clase Parking.
     */
    public Productor(Parking p){
        parking = p;
    }

    /**
     * El metodo run() lo ejecutará el hilo de la instancia de esta clase, este
     * llama al método consumir() y permite que salga los coches del parking.
     */
    public void run(){
        while(true){
            try {
                parking.producir();
                System.out.println("Esta entrando un coche al parking");

                sleep((int) Math.random() * 5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
