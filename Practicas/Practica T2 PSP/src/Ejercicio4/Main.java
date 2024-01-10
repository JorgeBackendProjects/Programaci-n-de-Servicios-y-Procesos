package Ejercicio4;

public class Main {

    public static void main(String[] args) {

        Monitor monitor = new Monitor();

        Editor editor1 = new Editor(monitor);
        Editor editor2 = new Editor(monitor);

        Lector lector1 = new Lector(monitor);
        Lector lector2 = new Lector(monitor);

        Thread hilo1 = new Thread(lector1);
        Thread hilo2 = new Thread(lector2);
        Thread hilo3 = new Thread(editor1);
        Thread hilo4 = new Thread(editor2);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

    }
}
