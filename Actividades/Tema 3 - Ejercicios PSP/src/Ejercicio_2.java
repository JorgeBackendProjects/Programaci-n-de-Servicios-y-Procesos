import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ejercicio_2 {

    public static void enviarUDP(String mensaje, String destino){

        try {

            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName(destino);

            DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr, 5555);

            datagramSocket.send(datagrama);

            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        enviarUDP("HELLO my friend", "localhost");
    }
}
