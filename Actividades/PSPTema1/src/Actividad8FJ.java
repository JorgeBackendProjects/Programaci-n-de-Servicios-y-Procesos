import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class Actividad8FJ extends RecursiveAction {

    private ArrayList<Dispositivo> muestra;
    private int media;
    private int indiceInicio, indiceFinal;


    public int getMedia(){

        return media;
    }

    public Actividad8FJ(int iI, int iF, ArrayList<Dispositivo> mu){

        media = 0;
        indiceInicio = iI;
        indiceFinal = iF;
        muestra = new ArrayList<Dispositivo>(muestra);
    }


    public void compute(){

        int umbral = 350000;

        if((indiceFinal-indiceInicio) <= umbral){
            //CalculoIterativo
            for(Dispositivo d : muestra){
                media += d.getBateria();
            }

            media /= muestra.size();

        }else{
            int indiceMedio = (indiceFinal + indiceInicio) / 2;
            Actividad8FJ izquierda = new Actividad8FJ(indiceInicio, indiceMedio, muestra);
            Actividad8FJ derecha = new Actividad8FJ(indiceMedio, indiceFinal, muestra);

            izquierda.fork();
            derecha.compute();
            izquierda.join();

            media = izquierda.getMedia() + derecha.getMedia();
        }
    }


}
