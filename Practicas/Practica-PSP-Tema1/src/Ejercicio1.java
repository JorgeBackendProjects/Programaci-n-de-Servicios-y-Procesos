import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Esta clase pertenece al Ejercicio 1; que encuentra todos los numeros que son
 * divisibles / multiplos entre 2 y 3 mas pequeños de 1000.
 */
public class Ejercicio1 implements Callable <Boolean> {

    private int i;

    /**
     * Este constructor por parametros inicializa el numero entero con el que se trabajara en cada ejecucion.
     * @param x Numero entero.
     */
    public Ejercicio1(int x){
        i = x;
    }

    /**
     * Este metodo comprueba que el numero introducido en una tarea es divisible / multiplo de 2 y 3.
     * @return Devuelve true si el numero es divisible / multiplo de 2 y 3; y false si no lo es.
     */
    public boolean divisiblesDeDosyTres() {

            if (i % 2 == 0 && i % 3 == 0) {
                System.out.println("[1]" + i + " es divisible entre 2 y 3");
                return true;
            }else{
                return false;
            }
    }

    /**
     * Este metodo llama al metodo divisiblesDeDosyTres() para aplicar su ejecucion con concurrencia.
     * @return Devuelve un valor booleano que ha sido devuelto previamente en el anterior metodo.
     * @throws Exception
     */
    public Boolean call() throws Exception {
        return divisiblesDeDosyTres();
    }

    /**
     * Hilo de ejecucion principal main(); donde se crean y ejecutan las tareas de la clase mediante
     * un gestor de concurrencia dentro de un bucle for.
     * @param args
     * @throws Exception
     */
    public static void main(String [] args) throws Exception {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        ArrayList<Ejercicio1> listaLlamadas = new ArrayList<Ejercicio1>();

        for(int i = 0; i<100; i++){
            Ejercicio1 calculo = new Ejercicio1(i);
            listaLlamadas.add(calculo);
        }

        List<Future<Boolean>> resultados = executor.invokeAll(listaLlamadas);
        executor.shutdown();

        for(int i = 0; i<resultados.size(); i++){
            Future<Boolean> resultado = resultados.get(i);
            System.out.println("Es " + i + " multiplo de 2 y 3? " + resultado.get());
        }
    }


}
