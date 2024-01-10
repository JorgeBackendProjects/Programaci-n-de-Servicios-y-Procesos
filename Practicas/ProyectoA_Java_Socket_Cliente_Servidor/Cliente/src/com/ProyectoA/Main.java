package com.ProyectoA;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int puerto = 0; //Número de puerto para conexión con servidor
        String servidor = ""; //IP o nombre DNS del servidor al que nos conectaremos
        String mensaje = ""; //Mensaje a enviar al servidor

        //Pedimos los datos de conexión y el mensaje
        //Si se han pasado como parámetro
        if (args.length == 3) {
            //El servidor será el primer parámetro
            servidor = args[1];
            //El puerto será el segundo parámetro
            try {
                puerto = Integer.parseInt(args[1]);
            } catch (Exception e) {
                System.out.println("Debe indicar un número de" +
                        " puerto válido que no esté en uso.");
                System.exit(1); //Cerramos aplicación con código de salida 1
            }
            //El mensaje será el tercer parámetro
            mensaje = args[2];
        } else { //En caso contrario, se los pedimos al usuario por consola
            Scanner lecturaTeclado = new Scanner(System.in);
            System.out.print("Introduce la dirección del servidor: ");
            servidor = lecturaTeclado.nextLine();
            System.out.print("Introduce el puerto de conexión con el servidor: ");
            try {
                puerto = Integer.parseInt(lecturaTeclado.nextLine());
            } catch (Exception e) {
                System.out.println("Debe indicar un número " +
                        "de puerto válido que no esté en uso.");
                System.exit(1); //Cerramos aplicación con código de salida 1
            }
            System.out.print("Introduce el mensaje a enviar: ");
            mensaje = lecturaTeclado.nextLine();
        }

        if (puerto > 0) {
            try {
                System.out.println(FechaActual() + " Conectando con servidor " + servidor + " por puerto: " + puerto + "...");
                //Instanciamos clase Socket con servidor y puerto especificados
                Socket clientSocket = new Socket(servidor, puerto);
                System.out.println(FechaActual() + " Conectado a servidor: " + clientSocket.getInetAddress());

                //Establecemos el canal de comunicación
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
                //Enviamos el mensaje de texto al servidor
                System.out.println(FechaActual() + " Enviando mensaje a servidor...");
                outputStream.writeUTF(mensaje);
                System.out.println(FechaActual() + " Mensaje enviado a servidor: " + mensaje);

                //Cerramos la conexión con el servidor
                clientSocket.close();
            } catch (UnknownHostException ex) {
                System.out.println("Servidor no encontrado: " + ex.getMessage());
                System.exit(1); //Salimos del programa con código de salida 1
            } catch (IOException ex) {
                System.out.println("Error al conectar al servidor: " + ex.getMessage());
                System.exit(2); //Salimos del programa con código de salida 2
            }
        } else {
            System.out.println("Debe indicar un puerto, una" +
                    " IP (o DNS) y un mensaje para el envío.");
            System.exit(1); //Cerramos aplicación con código de salida 1
        }
    }

    /**
     * Función que devuelve la fecha y hora actuales con formato año-mes-dia hora:minuto:segundo:milisegundo
     */
    public static String FechaActual()
    {
        Date fechaHoraActual = new Date();
        String fechaFormateada =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(fechaHoraActual);
        return fechaFormateada;
    }
}
