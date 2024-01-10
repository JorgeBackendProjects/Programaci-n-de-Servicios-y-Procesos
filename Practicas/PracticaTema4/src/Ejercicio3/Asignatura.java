package Ejercicio3;

import java.io.Serializable;

public class Asignatura implements Serializable {

    private int id;
    private String nombre;

    public Asignatura() {
        this.id = 0;
        this.nombre = "";
    }

    public Asignatura(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Asignatura(Asignatura other) {
        this.id = other.id;
        this.nombre = other.nombre;
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

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
