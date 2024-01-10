package Ejercicio5;

public class Main {

   public static void main(String[] args) {

        Balsa balsa [] = new Balsa [3];

        int numNaufragos = 6;

        for(int i= 0; i< balsa.length; i++){
            Naufragos naufrago = new Naufragos(7);
            balsa[i].start();
        }


    }
}
