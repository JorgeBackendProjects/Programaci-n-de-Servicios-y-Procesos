package Ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

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
    public static void main(String[] args) {

        try {

            Socket clientSocket = new Socket();
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            clientSocket.connect(addr);

            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            Scanner scan = new Scanner(System.in);
            System.out.println("Escribe tu nombre:");
            String nombre = scan.next();

            os.write(nombre.getBytes());

            os.flush();

            Scanner seleccion = new Scanner(System.in);

            System.out.println("Elige(1/2): 1.Revisar correspondencia o 2.Enviar correspondencia...");
            int eleccion = seleccion.nextInt();

            os.write((eleccion + " ").getBytes());

            switch (eleccion) {

                case 1:
                    System.out.println("Comprobando correspondencia...");
                    break;

                case 2:
                    Scanner scann = new Scanner(System.in);

                    System.out.println("Escribe el nombre del destinatario:");
                    String destinatario = scann.next();

                    System.out.println("Escribe el mensaje:");
                    String mensaje = scann.next();

                    oos.writeObject(new Mensaje(nombre, destinatario, mensaje));
                break;
            }

            clientSocket.close();
            is.close();
            os.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
