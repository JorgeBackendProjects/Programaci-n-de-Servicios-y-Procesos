public class Ejercicio2 implements Runnable{

    private String cadena;

    public Ejercicio2(){
        cadena = "";
    }

    public Ejercicio2(String a){
        cadena = a;
    }

    @Override
    public void run() {
        for(int i = 0; i<5; i++){
            System.out.println(cadena + " " + i);
        }
    }

    public static void main(String[]args){

        Ejercicio2 c = new Ejercicio2("HOLA A TODOS");
        Ejercicio2 b = new Ejercicio2("ADIOS A TODOS");

        Thread hilo1 = new Thread(c);
        Thread hilo2 = new Thread(b);

        hilo1.start();
        hilo2.start();
    }
}
