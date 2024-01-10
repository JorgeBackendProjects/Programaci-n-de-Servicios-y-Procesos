package Ejercicio3;

/**
 * Esta clase actua como monitor, que protege el acceso a sus
 * metodos que modifican su atributo String con el que operaran
 * los hilos productores y consumidores.
 */
public class Parking {

    private Coche [] coches;
    private int posicion;
    private boolean estaLleno, estaVacio;

    /**
     * Constructor por defecto que inicializa todos
     * sus atributos con valores predeterminados.
     */
    public Parking(){
        coches = new Coche [10];
        posicion = 0;
        estaLleno = false;
        estaVacio = true;
    }

    /**
     * Este método sincronizado / protegido al que solo podrá acceder
     * un hilo de la clase Consumidor indica al Productor que están
     * saliendo coches del parking para que entren más.
     *
     * @return Devuelve el objeto de la clase Coche de la posición concreta del array.
     *
     * @throws InterruptedException
     */
    public synchronized Coche consumir() throws InterruptedException {

        if(estaVacio){
            wait();
        }

        posicion--;
        estaLleno = false;

        if(posicion == 0){
            estaVacio = true;
        }

        notifyAll();

        return coches[posicion];
    }

    /**
     * Este método sincronizado / protegido al que solo podrá acceder
     * un hilo de la clase Productor. Este indica que cuando el parking
     * esté lleno no podrán entrar coches, por tanto, el Consumidor debe
     * esperar y lo notifica cuando haya alguna posición disponible.
     *
     * @throws InterruptedException
     */
    public synchronized void producir() throws InterruptedException {

        if(estaLleno){
            wait();
        }

        coches[posicion] = new Coche();
        posicion++;

        if(posicion == coches.length){
            estaLleno = true;
        }

        notifyAll();
    }


}
