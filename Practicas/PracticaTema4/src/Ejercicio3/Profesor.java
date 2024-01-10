package Ejercicio3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase usada para que sus objetos puedan ser enviados a través de
 * flujos de bytes mediante la interfaz Serializable.
 *
 * Un profesor tiene los siguientes atributos; Un ID, un nombre, una lista
 * de objetos de la clase Asignatura y un objeto de la clase Especialidad.
 */
public class Profesor  implements Serializable {

    private int id;
    private String nombre;
    private ArrayList<Asignatura> asignaturas;
    private Especialidad especialidad;

    public Profesor(){
        this.id = 0;
        this.nombre = "Jorge";
        this.asignaturas = new ArrayList<Asignatura>();
        this.especialidad = new Especialidad();
    }

    public Profesor(int id, String nombre, ArrayList<Asignatura> asignaturas, Especialidad especialidad){
        this.id = id;
        this.nombre = nombre;
        this.asignaturas = new ArrayList<Asignatura>(asignaturas);
        this.especialidad = new Especialidad(especialidad);
    }

    public Profesor(Profesor other){
        this.id = other.id;
        this.nombre = other.nombre;
        this.asignaturas = other.asignaturas;
        this.especialidad = other.especialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", asignaturas=" + asignaturas +
                ", especialidad=" + especialidad +
                '}';
    }
}
