package Ejercicio2;

import java.io.Serializable;

/**
 * Esta clase sirve como contenido de la MaquinaExpendedora.
 */
public class Refrescos implements Serializable {

    private String nombre;

    /**
     * Constructor por parámetros que selecciona mediante un entero un refresco en concreto.
     *
     * @param eleccion Número entero con el que se selecciona el refresco.
     */
    public Refrescos(int eleccion){

        switch(eleccion){

            case 1:
                nombre = "Coca-Cola";
                break;

            case 2:
                nombre = "Fanta";
                break;

            case 3:
                nombre = "Sprite";
                break;

            case 4:
                nombre = "Tónica";
                break;

            case 5:
                nombre = "Nestea";
                break;

            case 6:
                nombre = "Cerveza";
                break;

            case 7:
                nombre = "Zumo";
                break;

            case 8:
                nombre = "Agua";
                break;
        }
    }

    /**
     * Método getter sincronizado para su acceso desde la MaquinaExpendedora.
     *
     * @return Devuelve el nombre del refresco.
     */
    public synchronized String getNombre() {
        return nombre;
    }

}
