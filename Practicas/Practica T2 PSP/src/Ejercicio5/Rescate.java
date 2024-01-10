package Ejercicio5;

public class Rescate {

    private Balsa balsa;

    public Rescate(Balsa b){
        balsa = b;
    }

    public void run(){
        while(balsa.getNumNaufragos()>=0){
            balsa.ocupaPlazas();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


