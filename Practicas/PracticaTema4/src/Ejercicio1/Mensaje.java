package Ejercicio1;

import java.io.Serializable;

/**
 * Esta clase es el medio de comunicación entre un cliente y un servidor público.
 *
 * Implementa la interfaz Serializable para poder convertir objetos de la clase
 * a flujos de bytes y que puedan enviarse por medio de las clases que se encargan de
 * enviar y recibir información.
 */
public class Mensaje implements Serializable {

    private String emisor, receptor, mensaje;

    public Mensaje(){
        emisor = "";
        receptor = "";
        mensaje = "";
    }

    /**
     * Este constructor por parámetros inicializa un mensaje con
     * el nombre de un emisor, el nombre de un destinatario y el
     * cuerpo del mensaje.
     *
     * @param em String emisor.
     * @param re String receptor.
     * @param me String mensaje.
     */
    public Mensaje(String em, String re, String me){
        emisor = em;
        receptor = re;
        mensaje = me;
    }

    /**
     * Getter del emisor del mensaje.
     *
     * @return Devuelve un String.
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * Setter del emisor del mensaje.
     *
     * @param emisor String con el nombre del emisor.
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    /**
     * Getter del receptor del mensaje.
     *
     * @return Devuelve un String.
     */
    public String getReceptor() {
        return receptor;
    }

    /**
     * Setter del receptor del mensaje.
     *
     * @param receptor String con el nombre del receptor.
     */
    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    /**
     * Getter del mensaje.
     *
     * @return Devuelve un String.
     */
    public String getMensaje() {
        return mensaje;
    }


    /**
     * Setter del mensaje.
     *
     * @param mensaje String con el mensaje.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Este toString() sirve para visualizar el
     * estado actual de un objeto de la clase.
     *
     * @return Devuelve un String.
     */
    @Override
    public String toString() {
        return "Mensaje{" +
                "emisor='" + emisor + '\'' +
                ", receptor='" + receptor + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
