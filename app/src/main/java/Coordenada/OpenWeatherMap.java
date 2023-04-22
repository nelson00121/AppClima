package Coordenada;

import java.util.List;

public class OpenWeatherMap {
    private Coordenada coordenada;
    private List<ClimaD>clima;
    private String base;
    private Inicio inicio;
    private Viento viento;
    private Lluvia lluvia;
    private Nubes nubes;
    private int dt;
    private Sys sys;
    private String name;
    private int cod;

    public OpenWeatherMap() {

    }

    public OpenWeatherMap(Coordenada coordenada, List<ClimaD> climaList, String base, Inicio inicio, Viento viento, Lluvia lluvia, Nubes nubes, int dt, Sys sys, String name, int cod) {
        this.coordenada = coordenada;
        this.clima= climaList;
        this.base = base;
        this.inicio = inicio;
        this.viento = viento;
        this.lluvia = lluvia;
        this.nubes = nubes;
        this.dt = dt;
        this.sys = sys;
        this.name = name;
        this.cod = cod;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public List<ClimaD>getClima() {
        return clima;
    }

    public void setClima(List<ClimaD>clima) {
        this.clima = clima;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Inicio getInicio() {
        return inicio;
    }

    public void setInicio(Inicio inicio) {
        this.inicio = inicio;
    }

    public Viento getViento() {
        return viento;
    }

    public void setViento(Viento viento) {
        this.viento = viento;
    }

    public Lluvia getLluvia() {
        return lluvia;
    }

    public void setLluvia(Lluvia lluvia) {
        this.lluvia = lluvia;
    }

    public Nubes getNubes() {
        return nubes;
    }

    public void setNubes(Nubes nubes) {
        this.nubes = nubes;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
