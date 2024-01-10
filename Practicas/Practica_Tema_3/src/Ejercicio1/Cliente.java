package Ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Esta clase actúa como un cliente, que enviará mensajes y peticiones a un servidor.
 */
public class Cliente {

    /**
     * Hilo de ejecución principal main(): En él se inicializa el socket del cliente
     * para establecer conexiones con otros puertos. Este necesita las clases InputStream y
     * OutputStream para hacer peticiones, enviar mensajes y leer los mensajes recibidos.
     *
     * La manera de recibir y enviar mensajes es mediante la conversión de los datos en flujos de bytes.
     *
     * @param args
     */
    public static void main(String [] args){
        try{
            Socket cliente = new Socket();
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            cliente.connect(addr); //Establece la conexión con el puerto destino.

            InputStream is = cliente.getInputStream();
            OutputStream os = cliente.getOutputStream();

            String mensaje = "Mensaje desde el cliente";
            os.write(mensaje.getBytes()); //Envía el mensaje al servidor

            System.out.println("Numero de cliente: " + is.read()); //Muestra el número de cliente recibido del servidor

            String valoracion = "La conexión ha sido correcta";
            os.write(valoracion.getBytes()); //Envía el mensaje al servidor

            is.close();
            os.close();
            cliente.close(); //Cierre de la conexión del socket

        }catch(IOException error){
            System.out.println(error);
        }

    }

}
