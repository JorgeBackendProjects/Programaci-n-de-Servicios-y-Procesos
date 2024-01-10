import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void prepararMuestra(ArrayList<Dispositivo> muestra) {

        for(int i = 0; i<70000; i++){
            Random r1 = new Random();
            int bateria = r1.nextInt(100);
            Dispositivo d = new Dispositivo(bateria, "Samsung", "S7");

            muestra.add(d);
        }

    }

    public static int calculoIterativo(ArrayList<Dispositivo> muestra){
        int media = 0;

        for(Dispositivo d : muestra){
            media += d.getBateria();
        }

        media /= muestra.size();

        return media;
    }

    public static void main(String[] args) {

        ArrayList<Dispositivo> misDispositivos = new ArrayList<Dispositivo>();

        prepararMuestra(misDispositivos);

        long inicio, fin, totalIterativo, totalForkJoin;

        inicio = System.nanoTime();

        calculoIterativo(misDispositivos);

        fin = System.nanoTime();

        totalIterativo = fin-inicio;

        System.out.println("Tiempo de ejecucion: " + totalIterativo);

    }


}