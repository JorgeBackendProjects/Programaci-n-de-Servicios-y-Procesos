package Ejercicio2;

/**
 * Esta clase actua como monitor, que protege el acceso a sus
 * metodos que modifican su atributo String con el que operaran
 * los hilos productores y consumidores.
 */
public class Pedido {

    private String plato;
    private int cuentaPedido;
    private boolean cerrojo; //false = no hay dato para consumir, se tiene que producir; true = hay dato producido, se tiene que consumir

    /**
     * Constructor por defecto que inicializa todos
     * sus atributos con valores predeterminados.
     */
    public Pedido(){
        String plato = "";
        cuentaPedido = 0;
        cerrojo=false;
    }

    /**
     * Este metodo sincronizado / protegido al que solo podra acceder
     * un hilo de la clase Cocinero indica al Camarero que el plato
     * aun no se ha preparado y que espere, y tambien cuando se ha
     * preparado el plato y lo notifica para que lo consuma.
     *
     * @throws InterruptedException
     */
    public synchronized void producir() throws InterruptedException {

        if(cerrojo){
            wait();
        }

        plato = "El plato esta preparado";

        cerrojo = true;
        notifyAll();
    }

    /**
     * Este metodo sincronizado / protegido al que solo podra acceder
     * un hilo de la clase Camarero indica al Cocinero que espere
     * cuando el plato se esta consumiendo y lo notifica
     * para que vuelva a consumir.
     *
     * @return Devuelve el contenido del String plato
     * para que pueda producirse de nuevo.
     *
     * @throws InterruptedException
     */
    public synchronized String consumir() throws InterruptedException {

        if(!cerrojo){
            wait();
        }

        plato = "";
        cerrojo = false;

        notifyAll();
        return getPlato().toString();
    }

    /**
     * Getter del String plato.
     *
     * @return Devuelve el contenido del String plato.
     */
    public String getPlato (){
        return plato;
    }
}
