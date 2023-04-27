package Parciales.primero2021.Entidades;

import Parciales.primero2021.TAD.linkedlist.MyLinkedListImpl;
import Parciales.primero2021.TAD.queue.MyQueue;


public class Usuario {
    private int cedula;
    private MyLinkedListImpl<Recomendacion> recomendaciones;
    private MyLinkedListImpl<Vino> meGusta;
    private MyQueue<Vino> meRecomendaron;

    public Usuario(int cedula, MyLinkedListImpl<Recomendacion> recomendaciones, MyQueue<Vino> meRecomendaron) {
        this.cedula = cedula;
        this.recomendaciones = recomendaciones;
        this.meRecomendaron = meRecomendaron;
        this.meGusta = new MyLinkedListImpl<>();
    }

    public Usuario(int cedula, MyLinkedListImpl<Recomendacion> recomendaciones, MyLinkedListImpl<Vino> meGusta, MyQueue<Vino> meRecomendaron) {
        this.cedula = cedula;
        this.recomendaciones = recomendaciones;
        this.meGusta = meGusta;
        this.meRecomendaron = meRecomendaron;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public MyLinkedListImpl<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(MyLinkedListImpl<Recomendacion> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public MyLinkedListImpl<Vino> getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(MyLinkedListImpl<Vino> meGusta) {
        this.meGusta = meGusta;
    }

    public MyQueue<Vino> getMeRecomendaron() {
        return meRecomendaron;
    }

    public void setMeRecomendaron(MyQueue<Vino> meRecomendaron) {
        this.meRecomendaron = meRecomendaron;
    }
}
