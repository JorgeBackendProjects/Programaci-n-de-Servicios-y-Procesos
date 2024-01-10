package Ejercicio4;

/**
 * Esta clase Editor que hereda de la clase Thread
 * actuará como un productor de noticias.
 */
public class Editor extends Thread{

    private Monitor noticia;

    /**
     * Constructor por parámetros que inicializa el objeto noticia.
     *
     * @param noticia Objeto de la clase Monitor que comparte los datos.
     */
    public Editor(Monitor noticia) {
        this.noticia = noticia;
    }

    /**
     * Este método run() lo ejecutarán los hilos de instancias de esta clase.
     * Permite generar una nueva noticia.
     */
    public void run() {

        while (true) {

            noticia.escribirNoticia("Noticia " + noticia.getPosicion());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException error) {
                System.out.println(error);
            }

            System.out.println("Se ha escrito una noticia");
        }
    }
}
