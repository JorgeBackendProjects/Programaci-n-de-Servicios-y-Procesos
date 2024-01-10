public class Ejercicio1 extends Thread{

    private String cadena;

    public Ejercicio1(){
        cadena = "";
    }

    public Ejercicio1(String a){
        cadena = a;
    }

    public void run(){
        for(int i = 0; i<5; i++){
            System.out.println(cadena + " " + i);
        }
    }

    public static void main(String[]args){

        Thread hilo1 = new Ejercicio1("HOLA A TODOS");
        Thread hilo2 = new Ejercicio1("ADIOS A TODOS");

        hilo1.start();
        hilo2.start();
    }

}
