package Ejercicio5;

public class Balsa extends Thread{

    private int numPlazas;

    public Balsa(int nP){
        numPlazas = nP;
    }

    private Naufragos naufragos;
    private int plazas, numNaufragos;

    public Balsa(int numNaufragos, int plazas){
        this.numNaufragos = numNaufragos;
        naufragos = new Naufragos(this.numNaufragos);
        this.plazas = plazas;
    }

    public int getNumNaufragos(){
        return naufragos.getNumNaufragos();
    }

    public synchronized void ocupaPlazas() {

        plazas = plazas - numNaufragos;

        System.out.println("Se han subido " + plazas + " naufragos.");

        plazas = 0;

        System.out.println("Ya no queda sitio, la balsa sigue su rumbo.");

        try {
            Thread.sleep(1000);
        }catch(InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public void run() {
        System.out.println("Asientos Libres: " + plazas);
        ocupaPlazas();

    }


}
