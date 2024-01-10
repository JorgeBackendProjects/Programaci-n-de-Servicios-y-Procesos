package Ejercicio3;

public class Tirada {

    private int tirada;

    public Tirada(int i){
        tirada = i;
    }

    public synchronized int getTirada(){ //Metodo de Exclusion mutua
        return tirada; //Seccion critica
    }

    public synchronized void sumarTirada(int i){
        tirada += i;
    }



}
