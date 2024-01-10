package Ejercicio4;

/**
 * Esta clase Lector que hereda de la clase Thread
 * actuará como un consumidor de noticias.
 */
public class Lector extends Thread{

    private Monitor noticia;

    /**
     * Constructor por parámetros que inicializa el objeto noticia.
     *
     * @param noticia Objeto de la clase Monitor que comparte los datos.
     */
    public Lector(Monitor noticia) {
        this.noticia = noticia;
    }

    /**
     * Este método run() lo ejecutarán los hilos de instancias de esta clase.
     * Permite consumir una noticia del ArrayList.
     */
    public void run() {

        while (true) {

            noticia.leerNoticia();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException error) {
                System.out.println(error);
            }
        }
    }

}
