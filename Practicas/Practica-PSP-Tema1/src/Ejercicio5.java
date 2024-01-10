import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Esta clase pertenece al Ejercicio 5; que calcula la media de las medidas tomadas a lo largo del ultimo año.
 */
public class Ejercicio5 extends RecursiveTask<Double> {

    private ArrayList<Integer> medidas = new ArrayList<Integer>();
    private int indiceInicio, indiceFinal, umbral;
    private double media;

    /**
     * Este constructor por parametros inicializa los atributos indiceInicio, indiceFinal y medidas.
     * @param mi Numero entero.
     * @param ma Numero entero.
     * @param me ArrayList de numeros enteros.
     */
    public Ejercicio5(int mi, int ma, ArrayList<Integer>me){

        indiceInicio = mi;
        indiceFinal = ma;
        medidas = new ArrayList<Integer>(me);
        media = 0;
        umbral = medidas.size()/2;
    }

    /**
     * Este metodo devuelve la media, que se usara en cada division del ArrayList para su calculo.
     * @return Devuelve la media en un numero double.
     */
    private double getMedia(){
        return media;
    }

    /**
     * Este metodo asigna las muestras simuladas aleatoriamente al ArrayList que contendra las muestras.
     * @param muestras ArrayList de enteros.
     */
    public static void recopilarMuestras(ArrayList<Integer> muestras){
        for(int i = 0; i<262800; i++){
            muestras.add((int) (Math.random()*101));
        }
    }

    /**
     * Este metodo ejecuta la tarea de forma concurrente y la divide en dos; luego obtiene la media de ambos resultados.
     * @return Devuelve la media en un numero double.
     */
    @Override
    protected Double compute() {

        int indiceMedio = (indiceFinal + indiceInicio)/2;

        Ejercicio5 izquierda = new Ejercicio5(indiceInicio, indiceMedio, medidas);
        Ejercicio5 derecha = new Ejercicio5(indiceMedio, indiceFinal, medidas);

        izquierda.fork();
        derecha.compute();
        izquierda.join();

        media = izquierda.getMedia() + derecha.getMedia();

        return media;
    }

    /**
     * Este es el hilo de ejecucion principal main(); que ejecutara la tarea con ForkJoin.
     * @param args
     */
    public static void main(String[]args){

        ArrayList<Integer> medidas = new ArrayList<Integer>();
        recopilarMuestras(medidas);

        ForkJoinPool fjp = new ForkJoinPool(4);
        Ejercicio5 nuevo = new Ejercicio5(0, medidas.size(), medidas);

        fjp.invoke(nuevo);


        long inicio, fin, totalIterativo, totalForkJoin;
        inicio = System.nanoTime();
        fin = System.nanoTime();
        totalIterativo = fin-inicio;
        System.out.println("Tiempo de ejecución: " + totalIterativo);
    }

}
