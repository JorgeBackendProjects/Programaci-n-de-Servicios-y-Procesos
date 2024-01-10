package Ejercicio3;

public class Ejercicio3 implements Runnable{

    private Tirada resultado;

    public Ejercicio3(Tirada r){
        resultado = r;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            int dado = (int)(Math.random()*6)+1;
            resultado.sumarTirada(dado);
            System.out.println("Ejercicio3.Ejercicio3.Tirada hilo " + Thread.currentThread().getName() + ".");

        }catch(InterruptedException error){
            System.err.println(error);
        }
    }

    public static void main(String[]args) throws InterruptedException {
        Tirada tirada =  new Tirada(0);

        Ejercicio3 dado1 = new Ejercicio3(tirada);
        Ejercicio3 dado2 = new Ejercicio3(tirada);
        Ejercicio3 dado3 = new Ejercicio3(tirada);

        Thread hilo1 = new Thread(dado1);
        hilo1.setName("DADO 1");

        Thread hilo2 = new Thread(dado2);
        hilo1.setName("DADO 2");

        Thread hilo3 = new Thread(dado3);
        hilo1.setName("DADO 3");

        hilo1.start();
        hilo2.start();
        hilo3.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("El total de la tirada es: " + tirada.getTirada());
        System.out.println("Completado;");
    }
}
