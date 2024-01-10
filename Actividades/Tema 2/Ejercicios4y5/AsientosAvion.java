package Ejercicios4y5;

public class AsientosAvion {

    //comenzamos con 5 asientos libres en el avión
    private int asientosLibres = 5;

    public int getAsientosLibres() {
        return asientosLibres;
    }

    public boolean getAsientosLibres(int numPlaces) {
        if(numPlaces <= asientosLibres)
            return true;
        else
            return false;
    }

    public void reservaAsientos(int numAsientosReservas) {
        asientosLibres = asientosLibres - numAsientosReservas;
    }

}
