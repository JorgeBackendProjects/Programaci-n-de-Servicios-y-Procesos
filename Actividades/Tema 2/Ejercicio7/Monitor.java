package Ejercicio7;

public class Monitor {

    private int colaNumeros[] = new int [6];
    private int contador = 0 ;
    private boolean estaLlena = false; //Cerrojos / Semafaros
    private boolean estaVacia = true;

    //NO DEBE LLEVAR CONSTRUCTOR, EN LAS OTRAS CLSAES SE LE PASA UN MONITOR POR PARAMETROS.

    public synchronized void producir(int num){
        while(estaLlena){
            try {
                wait(); // no poner si no hay tope de produccion.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        colaNumeros [contador] = num;
        estaVacia = false;
        contador++;

        if(contador == 5){
            estaLlena = true;
        }

        notifyAll();
    }

    public synchronized int consumir(){
        while(estaVacia){
            try{
                wait();
            }catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        contador--;

        if(contador == 0){
            estaVacia = true;
        }

        estaLlena = false;
        notifyAll();
        return colaNumeros [contador];
    }


}
