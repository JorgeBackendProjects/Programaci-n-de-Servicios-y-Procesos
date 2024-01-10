package Ejercicio2;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Esta clase actúa como un cliente, que enviará mensajes y peticiones a un servidor público.
 *
 * Este se conectará al servidor "alt1.gmail-smtp-in.l.google.com" mediante el puerto 25 de SSH.
 * Mediante el método println() de la clase PrintWriter establecemos la conexión con el servidor y
 * enviamos mensajes al mismo.
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
    public static void main( String args[] ) {

        try {
            Socket socket = new Socket("alt1.gmail-smtp-in.l.google.com", 25);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            PrintWriter pw = new PrintWriter(dos, true);

            String linea = br.readLine();
            System.out.println(linea);

            //Inicio sesión
            pw.println("helo alt1.gmail-smtp-in.l.google.com");

            linea = br.readLine();
            System.out.println(linea);

            System.out.println("");

            Mensaje mensaje = new Mensaje("Jorge", "Iván", "Este es mi ejercicio 2...");
            ByteArrayOutputStream bs= new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream (bs);
            os.writeObject(mensaje);  // this es de tipo DatoUdp
            os.close();
            byte[] bytes =  bs.toByteArray(); // devuelve byte[]

            pw.println(bytes);

            linea = br.readLine();
            System.out.println(linea);

            //Cerrar conexión
            pw.println("quit");
            System.out.println(linea);

        } catch (UnknownHostException e) {
            System.err.println("Servidor no encontrado: " + e.getMessage());
        } catch (IOException e){
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }

    }
}
