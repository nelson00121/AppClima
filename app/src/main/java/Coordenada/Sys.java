package Coordenada;

public class Sys {
    private int tipo;
    private int id;
    private double mensaje;
    private String país;
    private double amanecer;
    private double sunset;

    //Metodo contructor

    public Sys(int tipo, int id, double mensaje, String país, double amanecer, double sunset) {
        this.tipo = tipo;
        this.id = id;
        this.mensaje = mensaje;
        this.país = país;
        this.amanecer = amanecer;
        this.sunset = sunset;
    }
    //Métodos Get y Set

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMensaje() {
        return mensaje;
    }

    public void setMensaje(double mensaje) {
        this.mensaje = mensaje;
    }

    public String getPaís() {
        return país;
    }

    public void setPaís(String país) {
        this.país = país;
    }

    public double getAmanecer() {
        return amanecer;
    }

    public void setAmanecer(double amanecer) {
        this.amanecer = amanecer;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(double sunset) {
        this.sunset = sunset;
    }
}
