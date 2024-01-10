package Ejercicio3;

public class Main {

    /**
     * Hilo de ejecución principal main(); En él se inicializa un objeto observer y otro observable. En este caso
     * cambiamos el contenido del producto seis veces, por lo que el observador debe ser notificado cada vez y
     * mostrar el anuncio por pantalla.
     *
     * Para ello hay que añadir al producto observable un observador con el método addObserver();
     *
     * @param args
     */
    public static void main(String[]args){

        Cliente cli = new Cliente();
        Producto pr = new Producto();

        pr.addObserver(cli);

        pr.setMensaje("Peras");
        pr.setMensaje("Manzanas");
        pr.setMensaje("Fresas");
        pr.setMensaje("Mangos");
        pr.setMensaje("Kakis");
        pr.setMensaje("Uvas");
    }
}
