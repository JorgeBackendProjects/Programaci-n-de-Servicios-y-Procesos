import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Esta clase pertenece al Ejercicio 2; que encuentra los numeros primos desde el numero 0
 * hasta el numero indicado por mil.
 */
public class Ejercicio2 implements Runnable{

    private int nMinimo, nMaximo;

    /**
     * Constructor por parametros que inicializa los numeros con los que se operaran en cada ejecucion de cada tarea.
     * @param num1 Numero entero.
     * @param num2 Numero entero.
     */
    public Ejercicio2(int num1, int num2){
        nMinimo = num1;
        nMaximo = num2;
    }

    /**
     * Este metodo comprueba los numeros que son primos en un rango, en este caso de mil en mil.
     * @return Devuelve verdadero si el numero es primo.
     */
    public boolean esPrimo(int i){

        for(i = 2; i<nMinimo-1 ; i++){

            if(nMinimo % i == 0){
                System.out.println(i + " no es primo");
                return false;
            }
        }

        return false;
    }

    /**
     * Este metodo llama al metodo esPrimo() y muestra que numero es primo y cual no.
     */
    @Override
    public void run() {

        for(int i = nMinimo-998; i<nMaximo; i++){
            if(esPrimo(i)){
                System.out.println(i + " es primo");
            }
        }
    }

    /**
     * Este es el hilo de ejecucion principal main(); en el que se ejecutara el
     * metodo run() con concurrencia mediante un gestor de concurrencia.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[]args) throws InterruptedException {

        int numero = 5;

        ExecutorService es = Executors.newCachedThreadPool();

        for(int i = 1; i<=numero ; i++){

            Ejercicio2 tarea = new Ejercicio2(i*1000, (i*1000)+1000);
            es.execute(tarea);
        }

        es.awaitTermination(10, TimeUnit.SECONDS);
        es.shutdown();
        System.out.println("Completado.");

    }

}
