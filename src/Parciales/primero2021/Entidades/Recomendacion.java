package Parciales.primero2021.Entidades;

public class Recomendacion {
    Usuario usuario;
    Vino vinoARecomendar;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vino getVinoARecomendar() {
        return vinoARecomendar;
    }

    public void setVinoARecomendar(Vino vinoARecomendar) {
        this.vinoARecomendar = vinoARecomendar;
    }

    public Recomendacion(Usuario usuario, Vino vinoARecomendar) {
        this.usuario = usuario;
        this.vinoARecomendar = vinoARecomendar;
    }
}
