package Ejercicio2;

/**
 * Esta clase que hereda de Thread actua como consumirdor.
 *
 * Este consume un String de la clase monitor Pedido mediante
 * un objeto de la clase, que sera producido por la clase Cocinero.
 */
public class Camarero extends Thread{

    private Pedido plato;

    /**
     * Constructor por parametros que recibe un objeto de la clase
     * Pedido que provee el metodo que permite producir y consumir,
     * para inicializar el objeto de Pedido de la clase: plato.
     *
     * @param x Objeto de la clase monitor Pedido.
     */
    public Camarero(Pedido x){
        plato = x;

    }

    /**
     * El metodo run() sera ejecutado por un hilo de la clase,
     * este indica que mientras el cerrojo del objeto plato de la
     * clase Pedido sea true intente hacer uso del metodo consumir().
     *
     * Ademas el hilo se duerme durante 4 segundos
     * para que no sea una consumicion inmediata.
     */
    public void run() {
        while(true){

            try {
                plato.consumir();
                System.out.println("Se ha recogido el plato.");

                sleep((int) Math.random() * 4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
