package Ejercicio3;

import Ejercicio2.Camarero;
import Ejercicio2.Cocinero;
import Ejercicio2.Pedido;

/**
 * Esta clase permite la creación, asignación e inicio
 * de los hilos para que produzcan y consuman mediante el
 * objeto que comparten de la clase Parking.
 */
public class Main {

    /**
     * En el hilo principal de ejecución main() se crean e inician
     * los hilos con un objeto de la clase monitor que compartirán.
     *
     * @param args
     */
    public static void main(String[]args){
        Parking parking = new Parking();
        Productor productor = new Productor(parking);
        Consumidor consumidor = new Consumidor(parking);

        productor.start();
        consumidor.start();

    }
}
