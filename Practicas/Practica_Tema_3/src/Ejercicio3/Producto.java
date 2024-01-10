package Ejercicio3;

import java.util.Observable;

/**
 * Esta clase que hereda de Observable es observada por la clase Cliente que implementa la interfaz Observer.
 */
public class Producto extends Observable {

    private String mensaje;

    /**
     * Constructor por defecto que inicializa el mensaje;
     */
    public Producto(){
        mensaje = "Producto observado";
    }

    /**
     * Este setter se usa para anunciar que el contenido del producto
     * ha variado, aplicando los cambios y avisando al observador.
     *
     * @param m
     */
    public void setMensaje(String m) {
        mensaje = m;

        setChanged();

        notifyObservers();
    }

}
