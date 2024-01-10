package Ejercicio3;

import java.util.Observable;
import java.util.Observer;

/**
 * Esta clase que implementa la interfaz Observer actúa como una notificación
 * automática cuando en el objeto Observable que se observa se produce un cambio.
 */
public class Cliente implements Observer {

    /**
     * Este método se llama cada vez que se produce un cambio en el objeto observado.
     *
     * En este caso mostrará por pantalla un mensaje anunciando un cambio.
     *
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Se ha producido un cambio en el producto");
    }

}
