import java.util.concurrent.ForkJoinPool;

public class Dispositivo {

    private int bateria;
    private String modelo, marca;

    public Dispositivo(){
        bateria = -1;
        modelo = "";
        marca = "";
    }

    public Dispositivo(int ba, String mo, String ma){
        bateria = ba;
        modelo = mo;
        marca = ma;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int ba) {
        this.bateria = ba;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String mo) {
        this.modelo = mo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String ma) {
        this.marca = ma;
    }


}
