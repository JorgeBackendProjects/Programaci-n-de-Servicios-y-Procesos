package Ejercicio2;

/**
 * Esta clase permite la creacion, asignacion e inicio
 * de los hilos para que produzcan y consuman mediante el
 * objeto pedido de la clase Pedido.
 */
public class Main {

    /**
     * En el hilo principal de ejecucion main() se crean e incian
     * los hilos con un objeto de la clase monitor que compartiran.
     *
     * @param args
     */
    public static void main(String[]args){
        Pedido pedido = new Pedido();
        Cocinero cocinero = new Cocinero(pedido);
        Camarero camarero = new Camarero(pedido);

        cocinero.start();
        camarero.start();

    }
}
