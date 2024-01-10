package Ejercicio3;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Esta clase actúa como servidor que atenderá las peticiones mediante
 * los sockets necesarios, recogiendo y enviando información.
 *
 * Esta contiene una serie de atributos; Una lista de 5 profesores,
 * un ID incremental para cada cliente y una lista que recoge la actividad
 * del servidor y la almacena para posteriormente escribirla en un fichero.
 */
public class Servidor {

    private static Profesor [] profesores = new Profesor[5];
    private static int idCliente = 0;
    private static ArrayList<String> informacion = new ArrayList<String>();

    /**
     * Este método rellena la lista con 5 profesores
     * y les asigna un ID incremental a cada uno.
     */
    public static void rellenarProfesores(){
        for(int i = 0; i<profesores.length; i++){
            profesores[i] = new Profesor();
            profesores[i].setId(i+1);
        }
    }

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

            rellenarProfesores();

            while(true) {

                Socket newSocket = serverSocket.accept();
                String tiempoConexion = String.valueOf(LocalDateTime.now());
                InputStream is = newSocket.getInputStream();
                OutputStream os = newSocket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);

                byte[] mensaje = new byte[50];

                idCliente++;
                System.out.println("Se ha conectado el cliente " + idCliente);
                os.write((idCliente + "").getBytes());

                os.flush();

                is.read(mensaje);
                String id = new String(mensaje, StandardCharsets.UTF_8);
                int idProfesor = Integer.parseInt(String.valueOf(id.charAt(0)));
                System.out.println("Se ha solicitado el profesor con ID: " + idProfesor);

                int cont = 0;
                for(int i = 0; i<profesores.length; i++){
                    if(profesores[i].getId() == idProfesor){
                        oos.writeObject(profesores[i]);
                    }

                    cont++;

                    if(cont == 5){
                        oos.writeObject(new Profesor());
                    }
                }

                String tiempoDesconexion = String.valueOf(LocalDateTime.now());

                FileWriter fw = new FileWriter("FichLog.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                informacion.add("El cliente con ID: " + idCliente + " se ha conectado a las " + tiempoConexion + " y se ha desconectado a las " + tiempoDesconexion + "\n   Ha solicitado el profesor " + idProfesor + "\nInformación del profesor: " + profesores[idProfesor].toString() );
                bw.write(System.lineSeparator());
                bw.append(informacion.get(0));
                informacion.remove(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
