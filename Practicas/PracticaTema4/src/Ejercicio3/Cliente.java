package Ejercicio3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Esta clase actúa como un cliente, que enviará mensajes y peticiones a un servidor público.
 *
 * Este seleccionará un profesor mediante un ID y el servidor deberá responder con el objeto
 * de la clase profesor correspondiente al ID para visualizar toda su información.
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
            ObjectInputStream ois = new ObjectInputStream(is);

            byte[] contenido = new byte[50];

            is.read(contenido);
            String id = new String(contenido, StandardCharsets.UTF_8);
            int idCliente = Integer.parseInt(String.valueOf(id.charAt(0)));
            System.out.println("Se ha asignado un ID: " + idCliente);

            Scanner scan = new Scanner(System.in);
            System.out.println("Escribe el ID del profesor: (1-5)");
            int idProfesor = scan.nextInt();

            os.write((idProfesor + "").getBytes());

            os.flush();

            Profesor profesor = (Profesor)ois.readObject();
            System.out.println(profesor.toString());

            clientSocket.close();
            is.close();
            os.close();

        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
