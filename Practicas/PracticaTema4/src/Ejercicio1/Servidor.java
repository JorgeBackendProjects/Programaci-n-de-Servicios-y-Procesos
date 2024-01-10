package Ejercicio1;

import Ejercicio3.Profesor;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase actúa como servidor que atenderá las peticiones mediante
 * los sockets necesarios, recogiendo y enviando información.
 *
 * Almacenará en una lista los distintos mensajes que reciban de los clientes,
 * hasta que los destinatarios los pidan al servidor.
 */
public class Servidor {

    private static ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
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

        try {

            ServerSocket serverSocket = new ServerSocket();
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);

            while(true) {

                Socket newSocket = serverSocket.accept();
                InputStream is = newSocket.getInputStream();
                OutputStream os = newSocket.getOutputStream();

                byte[] correo = new byte[50];

                is.read(correo);
                String nombreCliente = new String(correo, StandardCharsets.UTF_8);

                is.read(correo);
                String seleccion = new String(correo, StandardCharsets.UTF_8);
                int eleccion = Integer.parseInt(String.valueOf(seleccion.charAt(0)));
                System.out.println(eleccion);

                switch (eleccion) {

                    case 1:
                        for(int i = 0; i< mensajes.size(); i++) {
                            if (mensajes.get(i).getReceptor() == nombreCliente) {
                                os.write(mensajes.get(i).getMensaje().getBytes());
                            }
                        }
                    break;

                    case 2:
                        ObjectInputStream ois = new ObjectInputStream(is);
                        Mensaje mensaje = (Mensaje) ois.readObject();
                        System.out.println(mensaje.toString());

                        mensajes.add(mensaje);
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}
