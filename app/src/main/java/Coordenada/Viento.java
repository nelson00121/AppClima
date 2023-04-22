package Coordenada;

public class Viento {
    private double veloc;
    private double grados;

    public Viento(double veloc, double grados) {
        this.veloc = veloc;
        this.grados = grados;
    }

    public double getVeloc() {
        return veloc;
    }

    public void setVeloc(double veloc) {
        this.veloc = veloc;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }
}
