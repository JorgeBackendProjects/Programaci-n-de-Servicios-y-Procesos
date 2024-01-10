import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase que hereda de Thread genera un ArrayList de numeros
 * enteros que contiene las temperaturas de los ultimos diez años
 * en España.
 *
 * Luego divide el ArrayList en partes y se asignara
 * cada una a un hilo diferente.
 *
 * Una vez que los hilos hayan recuperado el valor mas alto de todos,
 * se encuentra el valor mas alto de entre los resultados de cada hilo.
 */
public class Ejercicio1 extends Thread{

    private ArrayList<Integer> temperaturas;
    private int tempMaxima;

    /**
     * Constructor por parametros que recibe una lista de enteros,
     * la cual sera la division del ArrayList correspondiente al hilo.
     *
     * @param tempts Lista para inicializar y rellenar el ArrayList.
     */
    public Ejercicio1(List<Integer> tempts){
        temperaturas = new ArrayList<Integer>(tempts);
        tempMaxima = 0;
    }

    /**
     * El metodo run() sera ejecutado por cada hilo de la clase,
     * este buscara la temperatura mas alta de la lista y
     * muestra el resultado por pantalla.
     */
    @Override
    public void run() {

        for(int i = 0; i<temperaturas.size(); i++){

            if(tempMaxima < temperaturas.get(i)){
                tempMaxima = temperaturas.get(i);
            }
        }

        System.out.println("El hilo tiene una temperatura maxima de: " + getTempMaxima());
    }

    /**
     * Este es el getter del atributo tempMaxima, que se usa para
     * almacenar el resultado de cada hilo.
     *
     * @return Devuelve un entero con la temperatura maxima.
     */
    public int getTempMaxima() {
        return tempMaxima;
    }

    /**
     * Este es el hilo principal de ejecucion del programa main(), en el
     * se genera un ArrayList con los valores de todas las temperaturas.
     *
     * Este sera dividido en subListas que se asignaran a cada hilo.
     * Luego se inician los hilos con start() y se comprueba cual es
     * la mayor temperatura de entre los tres hilos.
     *
     * @param args
     */
    public static void main(String[]args){

        ArrayList<Integer> temperaturas = new ArrayList<>();

        for(int i = 0; i<3650; i++){
            temperaturas.add((int) (Math.random()*((50 - (-20)) + (-20))));
        }

        Ejercicio1 hilo1 = new Ejercicio1(temperaturas.subList(0, 1216));
        Ejercicio1 hilo2 = new Ejercicio1(temperaturas.subList(1217, 2432));
        Ejercicio1 hilo3 = new Ejercicio1(temperaturas.subList(2433, 3648));

        hilo1.start();
        hilo2.start();
        hilo3.start();

        if(hilo1.getTempMaxima() > hilo2.getTempMaxima() && hilo1.getTempMaxima() > hilo3.getTempMaxima()){
            System.out.println("La mayor temperatura es: " + hilo1.getTempMaxima());
        }if(hilo2.getTempMaxima() > hilo1.getTempMaxima() && hilo2.getTempMaxima() > hilo3.getTempMaxima()){
            System.out.println("La mayor temperatura es: " + hilo2.getTempMaxima());
        }if(hilo3.getTempMaxima() > hilo2.getTempMaxima() && hilo3.getTempMaxima() > hilo1.getTempMaxima()){
            System.out.println("La mayor temperatura es: " + hilo3.getTempMaxima());
        }

    }


}


