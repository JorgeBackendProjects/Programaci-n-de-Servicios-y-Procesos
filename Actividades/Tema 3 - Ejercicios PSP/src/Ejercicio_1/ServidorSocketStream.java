package Ejercicio_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class ServidorSocketStream {

    public static void escuchaPeticion(){

        try {

            ServerSocket serverSocket = new ServerSocket();
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);
            Socket newSocket = serverSocket.accept();
            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();
            byte[] mensaje = new byte[25];
            is.read(mensaje);
            newSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        escuchaPeticion();
    }

}
