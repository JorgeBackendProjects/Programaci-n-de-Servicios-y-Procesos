package Ejercicio1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
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
    public static void main(String[] args) {

        int nClientes = 0;

        try {
            ServerSocket serverSocket = new ServerSocket();
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr); //Asigna al socket una IP y numero de puerto.

            while(true) {

                Socket newSocket = serverSocket.accept();
                InputStream is = newSocket.getInputStream();
                OutputStream os = newSocket.getOutputStream();

                byte[] mensaje = new byte[50]; //Almacena los mensajes enviados por el cliente
                is.read(mensaje); //Lee y almacena el primer mensaje enviado por el cliente en el array
                String resultado = new String(mensaje, StandardCharsets.UTF_8); //Almacena el mensaje en un String

                if (!resultado.isEmpty()) {
                    nClientes++;
                }

                os.write(nClientes); //Envía un mensaje al cliente con su ID

                System.out.println(resultado + "\nNumero de clientes: " + nClientes); //Muestra por pantalla el mensaje del cliente

                is.read(mensaje); //Lee y almacena el segundo mensaje enviado por el cliente en el array
                String resultado2 = new String(mensaje, StandardCharsets.UTF_8);//Almacena el mensaje en un String

                System.out.println(resultado2);//Muestra por pantalla el segundo mensaje del cliente

            }
        } catch (IOException error) {
            System.out.println(error);
        }

    }
}
