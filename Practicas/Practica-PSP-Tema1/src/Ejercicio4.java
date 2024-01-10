import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Esta clase pertenece al Ejercicio 4; el cual buscara el sueldo mas alto
 * en una poblacion de 200.000 personas.
 */
public class Ejercicio4 extends RecursiveTask<Double> {

    private static ArrayList<Double> sueldos;
    private int iInicio, iFinal, media;

    /**
     * Este constructor por defecto inicializa el ArrayList de sueldos,
     * acto seguido se asigna a cada posicion un sueldo al azar.
     */
    public Ejercicio4(){

        sueldos = new ArrayList<Double>();
        double sueldo;

        for(int i = 0; i<200000; i++){
            sueldo = Math.random()*50000;
            sueldos.add(sueldo);
        }
    }

    /**
     * Este metodo devolvera el sueldo mas alto de todo el ArrayList de sueldos.
     * @return Devuelve el sueldo en un numero double.
     */
    @Override
    protected Double compute() {

        double sueldo = 0;

        for(int i = 0; i<sueldos.size()-1; i++){

            if(sueldos.get(i) > sueldos.get(i+1)){
                sueldo = sueldos.get(i);
            }else{
                sueldo = sueldos.get(i+1);
            }

        }

        System.out.println(sueldo);
        return sueldo;
    }

    /**
     * Este es el hilo de ejecucion principal main(); en el que se realizara la tarea con concurrencia con ForkJoin.
     * @param args
     */
    public static void main(String[]args){

        ForkJoinPool fjp = new ForkJoinPool(2);
        Ejercicio4 nuevo = new Ejercicio4();

        nuevo.compute();
        fjp.execute(nuevo);
    }

}
