package Ejercicio4;

import java.util.ArrayList;

/**
 * Esta clase Monitor actúa como intermediaria para leer y escribir noticias.
 */
public class Monitor {

        private ArrayList<String> noticias;
        private int posicion;
        private boolean escribiendo, leyendo;

        /**
         * Constructor por defecto que inicializa todos
         * los atributos con valores predeterminados.
         */
        public Monitor() {
            noticias = new ArrayList<>();
            posicion = 0;
            escribiendo = false;
            leyendo = false;
        }

        /**
         * Este es el getter del contador que
         * recorre el ArrayList de noticias.
         *
         * @return int Devuelve un numero entero.
         */
        public int getPosicion() {
            return posicion;
        }

        /**
         * Este método sincronizado / protegido al que solo podrá
         * acceder un hilo de la clase Editor a la vez permite
         * generar una nueva noticia.
         *
         * @param noticia Recibe un String para
         */
        public synchronized void escribirNoticia(String noticia) {

            while (leyendo) {

                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            escribiendo = true;

            noticias.add(noticia);

            posicion++;

            escribiendo = false;

            notifyAll();
        }

        /**
         * Este método sincronizado / protegido al que solo podrá
         * acceder un hilo de la clase Lector a la vez permite
         * consumir una noticia del ArrayList.
         */
        public synchronized void leerNoticia() {

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            leyendo = true;
            System.out.println("Se ha leído una noticia");

            leyendo = false;

            notifyAll();
        }

}


