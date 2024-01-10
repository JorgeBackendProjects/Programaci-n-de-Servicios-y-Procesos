package Ejercicio2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase contiene un ArrayList de Refrescos, se usa para recoger
 * objetos de dicha clase en peticiones de un cliente a un servidor.
 */
public class MaquinaExpendedora implements Serializable {

    private ArrayList<Refrescos> refrescos;
    private int nRefrescos;

    /**
     * Constructor por defecto que inicializa y rellena el ArrayList.
     */
    public MaquinaExpendedora(){
        refrescos = new ArrayList<Refrescos>();

        for(int i = 0; i<1000; i++){
            refrescos.add(new Refrescos((int) (Math.random()*9)));
        }

        nRefrescos = refrescos.size();
    }

    /**
     * Método getter sincronizado para su acceso desde el servidor.
     *
     * @return Devuelve el ArrayList de Refrescos.
     */
    public synchronized ArrayList<Refrescos> getRefrescos() {
        return refrescos;
    }

    /**
     * Método getter sincronizado para su acceso desde el servidor.
     *
     * @return Devuelve el tamaño del ArrayList de Refrescos.
     */
    public synchronized int getNRefrescos() {
        return nRefrescos;
    }

}
