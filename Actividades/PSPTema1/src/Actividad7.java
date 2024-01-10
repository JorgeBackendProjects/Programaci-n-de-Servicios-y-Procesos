import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Actividad7 {


    public static void main (String [] args) throws InterruptedException {
        Calendar calendario = new GregorianCalendar();
        System.out.println("Inicio: " + calendario.get(Calendar.HOUR_OF_DAY) + " : " + calendario.get(Calendar.MINUTE) + " : " + calendario.get(Calendar.SECOND));

        //Gestor que permite la concurrencia, esta es la versión programable con un numero de hilos concreto.
        ScheduledThreadPoolExecutor stpe = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);

        //Hace falta para referenciar el método run() de la clase EjecutaHilos.
        Runnable runn = new Actividad7().new EjecutaHilos();
        //Se usa el objeto runnable, la primera tarea se ejecutará a los 2 segundos y el resto cada 3, por último se indica la unidad de tiempo.
        stpe.scheduleWithFixedDelay(runn, 2, 3, TimeUnit.SECONDS);

        //Espera a que termine, máximo 10 segundos.
        stpe.awaitTermination(10, TimeUnit.SECONDS);
        stpe.shutdown();
        System.out.println("Completado.");
    }


    class EjecutaHilos implements Runnable{

        Calendar calendario = new GregorianCalendar();

        @Override
        public void run() {

            System.out.println("Hora de ejecución de la tarea : " + calendario.get(Calendar.HOUR_OF_DAY) + " : " + calendario.get(Calendar.MINUTE) + " : " + calendario.get(Calendar.SECOND));
            System.out.println("Tarea en ejecución.");
            System.out.println("Tarea terminada.");

        }
    }


}
