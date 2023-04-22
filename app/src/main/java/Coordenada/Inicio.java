package Coordenada;

public class Inicio {
    private double temp;
    private double presion;
    private int humedad;
    private double temp_main;
    private double tem_max;

    public Inicio(double temp, double presion, int humedad, double temp_main, double tem_max) {
        this.temp = temp;
        this.presion = presion;
        this.humedad = humedad;
        this.temp_main = temp_main;
        this.tem_max = tem_max;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPresion() {
        return presion;
    }

    public void setPresion(double presion) {
        this.presion = presion;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public double getTemp_main() {
        return temp_main;
    }

    public void setTemp_main(double temp_main) {
        this.temp_main = temp_main;
    }

    public double getTem_max() {
        return tem_max;
    }

    public void setTem_max(double tem_max) {
        this.tem_max = tem_max;
    }
}
