package Ejercicio7;

public class Main {

    public static void main(String [] args){
        Monitor m = new Monitor();

        Productor p = new Productor(m);
        Consumidor c = new Consumidor(m);

        Thread productor = new Thread(p);
        Thread consumidor = new Thread(c);

        productor.start();
        consumidor.start();

    }

}
