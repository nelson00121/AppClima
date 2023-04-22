package Coordenada;

public class ClimaD {
    private int id;
    private String inicio;
    private String descripcion;
    private String icono;

    public ClimaD(int id, String inicio, String descripcion, String icono) {
        this.id = id;
        this.inicio = inicio;
        this.descripcion = descripcion;
        this.icono = icono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
