package Ejercicio_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteSocketStream {

    private static void realizaPeticion(String peticion){

        try {

            Socket clientSocket = new Socket();
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            clientSocket.connect(addr);
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            os.write(peticion.getBytes());
            clientSocket.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        realizaPeticion("Buscar en Google: 'Facebook'");
    }

}
