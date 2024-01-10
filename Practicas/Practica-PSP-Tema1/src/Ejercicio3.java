import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Esta clase pertenece al Ejercicio 3; que dadas una lista de frases,
 * mostrara por pantalla una de ellas al azar durante un minuto.
 */
public class Ejercicio3 implements Runnable {

    private static ArrayList<String> frases;

    /**
     * Este constructor por defecto inicializara el ArrayList que va a contener las frases,
     * luego se añaden una a una.
     */
    public Ejercicio3(){
        frases = new ArrayList<String>();
        frases.add("Hidratate bien");
        frases.add("Bebe dos litros de agua al dia");
        frases.add("Camina 5km cada dia");
        frases.add("Haz deporte a diario");
        frases.add("Come 5 piezas de fruta al dia");
    }

    /**
     * Este metodo mostrara por pantalla una frase al azar.
     */
    public void run(){
        System.out.println(frases.get((int) (Math.random()*6)));
    }

    /**
     * Este es el hilo de ejecucion principal main(); donde se ejecutara la misma tarea
     * mediante un gestor de concurrencia, de 5 en 5 segundos durante un minuto.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[]args) throws InterruptedException {

        ScheduledExecutorService x = Executors.newSingleThreadScheduledExecutor();

        Ejercicio3 c = new Ejercicio3();

        x.scheduleWithFixedDelay(c, 0, 5, TimeUnit.SECONDS);
        x.awaitTermination(60, TimeUnit.SECONDS);
        x.execute(c);
    }
}
