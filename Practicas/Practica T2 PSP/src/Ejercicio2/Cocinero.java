package Ejercicio2;

/**
 * Esta clase que hereda de Thread actua como productor.
 *
 * Este genera un String mediante una clase monitor Pedido,
 * que sera consumido por la clase Camarero que acuta como consumidor.
 */
public class Cocinero extends Thread {

    private Pedido plato;

    /**
     * Constructor por parametros que recibe un objeto de la clase
     * Pedido que provee el metodo que permite producir y consumir,
     * para inicializar el objeto de Pedido de la clase: plato.
     *
     * @param x Objeto de la clase monitor Pedido.
     */
    public Cocinero(Pedido x){
        plato = x;
    }

    /**
     * El metodo run() sera ejecutado por un hilo de la clase,
     * este indica que mientras el cerrojo en el objeto plato de la
     * clase Pedido sea true intente hacer uso del metodo producir().
     *
     * Ademas el hilo se duerme durante 4 segundos
     * para que no sea una consumicion inmediata.
     */
    public void run(){
        while(true){

            String nombrePlato = "lentejas";

            try {
                plato.producir();
                System.out.println("El plato se ha producido.");

                sleep((int) Math.random() * 4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
