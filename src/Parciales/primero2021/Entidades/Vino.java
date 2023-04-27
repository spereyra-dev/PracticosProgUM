package Parciales.primero2021.Entidades;

public class Vino {
    String nombre;
    String variedad;
    String pais;
    int cosecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCosecha() {
        return cosecha;
    }

    public void setCosecha(int cosecha) {
        this.cosecha = cosecha;
    }

    public Vino(String nombre, String variedad, String pais, int cosecha) {
        this.nombre = nombre;
        this.variedad = variedad;
        this.pais = pais;
        this.cosecha = cosecha;
    }
}
