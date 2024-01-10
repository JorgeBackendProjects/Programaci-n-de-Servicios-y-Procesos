import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Actividad6 {

    static class Multiplicacion implements Callable<Integer>{

        private int numero1, numero2;

        public Multiplicacion(){
            numero1=0;
            numero2=0;
        }

        public Multiplicacion(int n1, int n2){
            numero1=n1;
            numero2=n2;
        }

        @Override // Esto se ejecutará con concurrencia.
        public Integer call() throws Exception {

            return numero1*numero2;
        }
    }

    public static void main(String [] args) throws InterruptedException, ExecutionException {

        // Este método es para hilos dinámicos, en este caso hasta 3.
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        ArrayList<Multiplicacion> listaTareas = new ArrayList<Multiplicacion>();

        //Prepara 10 objetos de la clase con números aleatorios que guarda en el ArrayList, para luego hacer las multiplicaciones.
        for(int i = 0; i<10; i++){
            Multiplicacion calculo = new Multiplicacion((int)(Math.random()*10), (int)(Math.random()*10));
            listaTareas.add(calculo);
        }

        //Todos los elementos concurrentes de listaTareas se ejecutan con el executor.invokeAll.
        List<Future<Integer>> listaResultados = executor.invokeAll(listaTareas); // Todo su interior se ejecuta concurrentemente.
        executor.shutdown();

        for(int i = 0; i<listaResultados.size(); i++){
            Future<Integer> resultado = listaResultados.get(i);
            System.out.println("Resultado tarea " + i + " es: " + resultado.get());
        }

    }


}
