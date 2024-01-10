package Ejercicio2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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

        int numRefrescos = (int) Math.random()*7;

        try{
            Socket cliente = new Socket();
            InetSocketAddress addr = new InetSocketAddress("localhost", 555);
            cliente.connect(addr); //Establece la conexión con el puerto destino.

            InputStream is = cliente.getInputStream();
            OutputStream os = cliente.getOutputStream();

            String refresco = "Agua";

            os.write(refresco.getBytes()); //Pide al servidor el refresco
            os.write(numRefrescos); //Indica la cantidad de refrescos

            byte [] array = new byte[10];
            is.read(array);
            String resultado = new String(array, StandardCharsets.UTF_8);
            System.out.println(resultado);

            is.close();
            os.close();
            cliente.close(); //Cierre de la conexión del socket

        }catch(IOException error){
            System.out.println(error);
        }

    }
}
