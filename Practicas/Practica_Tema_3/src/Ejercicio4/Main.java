package Ejercicio4;

import java.util.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Esta clase hace uso de un objeto observable y un objeto observer, con la finalidad de
 * crear una conexión entre ambos mediante la concurrencia de la clase ThreadPoolExecutor.
 */
public class Main extends Observable {

    private Ejercicio4.Cliente cli;
    private Ejercicio4.Producto pr;
    private final int nNucleos;
    private final ThreadPoolExecutor executor;

    /**
     * Constructor por defecto que inicializa los objetos observable y observer, además del executor
     * con un número de núcleos. Luego se añade un observer y se realizan los cambios necesarios con el setter.
     */
    public Main() {

        cli = new Cliente();
        pr = new Producto();

        nNucleos = Runtime.getRuntime().availableProcessors();
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(nNucleos);

        pr.addObserver(cli);

        pr.setMensaje("Peras");
        pr.setMensaje("Manzanas");
        pr.setMensaje("Fresas");
        pr.setMensaje("Mangos");
        pr.setMensaje("Kakis");
        pr.setMensaje("Uvas");
        pr.setMensaje("Sandías");
    }

    /**
     * Método de la clase que se ejecutará en el hilo de ejecución principal
     * y comprueba en cada vuelta si el observable ha producido cambios o no.
     *
     * Luego duerme el hilo hasta la siguiente vuelta y por último cierra el executor.
     */
    private void execute() {

        for (int i = 0; i < 5; ++i) {
            this.setChanged();
            this.notifyObservers(i);

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }

    /**
     * Hilo de ejecución principal main();
     *
     * En él se instancia un objeto de la clase Main para ejecutar el método execute();
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.execute();
    }



}
