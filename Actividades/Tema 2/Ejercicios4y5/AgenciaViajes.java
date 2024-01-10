package Ejercicios4y5;

/**
 * Ejercicio4
 *
 * Este codigo falla en su orden de ejecucion ya que si solo queda un asiento disponible,
 * si un cliente va a hacer una reserva de mas de un asiento se le permite hacer la operacion,
 * aunque no deberia.
 */

public class AgenciaViajes implements Runnable{

    private AsientosAvion sa = new AsientosAvion();

    //Ejercicio5
    public void run() {
        System.out.println("ASIENTOS LIBRES: " + sa.getAsientosLibres());

        synchronized (sa) {
            gestionAsientosAvion(3);
            if (sa.getAsientosLibres() <= 0)
                System.out.println("No hay asientos libres");
        }

    }

    public void gestionAsientosAvion(int numeroAsientosReserva) {

        //Comprobamos si hay asientos suficientes

        if(sa.getAsientosLibres() >= numeroAsientosReserva) {

                System.out.println(Thread.currentThread().getName() + " hará una reserva de " + numeroAsientosReserva + " plazas ");
                try {
                    Thread.sleep(1000); //dormimos el hilo 1 segundo
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            //Realizamos la reserva de los asientos
            sa.reservaAsientos(numeroAsientosReserva);
            System.out.println(Thread.currentThread().getName() + " Reserva realizada con éxito." + " Las plazas libres son " + sa.getAsientosLibres());

        }else{

            System.out.println("No hay plazas suficientes para el cliente." + Thread.currentThread().getName() + " Las plazas libres son " + sa.getAsientosLibres());

            try {
                Thread.sleep(1000);

            }catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String [ ] args) {
        AgenciaViajes objAg = new AgenciaViajes();
        //creamos ambos hilos sobre la misma instancia
        Thread Hilo1 = new Thread(objAg);
        Thread Hilo2 = new Thread(objAg);
        Hilo1.setName("Cliente 1");
        Hilo2.setName("Cliente 2");
        Hilo1.start();
        Hilo2.start();
    }


}
