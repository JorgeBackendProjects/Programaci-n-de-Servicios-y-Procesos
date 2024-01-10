package Ejercicio2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Esta clase actúa como servidor que atenderá peticiones mediante
 * los sockets necesarios, recogiendo y enviando información.
 */
public class Servidor {

    /**
     * Hilo de ejecución principal main(): En él se inicializa el socket del servidor junto a otro socket
     * que establecerá conexiones con otros puertos para atender sus peticiones. Este necesita las clases
     * InputStream y OutputStream para hacer peticiones, enviar mensajes y leer los mensajes recibidos.
     *
     * La manera de recibir y enviar mensajes es mediante la conversión de los datos en flujos de bytes.
     *
     * @param args
     */
    public static void main(String [] args) {

        MaquinaExpendedora maquina = new MaquinaExpendedora();

        try {
            ServerSocket serverSocket = new ServerSocket();
            InetSocketAddress addr = new InetSocketAddress("localhost", 555);
            serverSocket.bind(addr); //Asigna al socket una IP y numero de puerto.

            while(true) {

                Socket newSocket = serverSocket.accept();
                InputStream is = newSocket.getInputStream();
                OutputStream os = newSocket.getOutputStream();

                byte[] mensaje = new byte[10]; //Almacena los mensajes enviados por el cliente
                is.read(mensaje); //Lee y almacena el mensaje enviado por el cliente en el array
                String refresco = new String(mensaje, StandardCharsets.UTF_8); //Almacena el mensaje en un String
                System.out.println("Refrescos disponibles: " + maquina.getNRefrescos()); //Muestra por pantalla el número de refrescos disponibles

                int numRefrescos = is.read();
                int contador = 0;

                for (int i = 0; contador<=numRefrescos; i++) {
                    if (maquina.getRefrescos().get(i).getNombre() == refresco) {
                        maquina.getRefrescos().remove(i);
                        contador++;
                    }
                }

                String result = refresco + " x" + contador;

                System.out.println("Se ha entregado: " + result + "\nQuedan " + maquina.getNRefrescos() + " refrescos");
                os.write(result.getBytes());
            }
        } catch (IOException error) {
            System.out.println(error);
        }

    }
}
