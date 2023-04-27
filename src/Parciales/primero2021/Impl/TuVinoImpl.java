package Parciales.primero2021.Impl;

import Parciales.primero2021.Entidades.Recomendacion;
import Parciales.primero2021.Entidades.Usuario;
import Parciales.primero2021.Entidades.Vino;
import Parciales.primero2021.Excepciones.EntidadNoExiste;
import Parciales.primero2021.Excepciones.EntidadYaExiste;
import Parciales.primero2021.TAD.linkedlist.MyLinkedListImpl;
import Parciales.primero2021.TAD.queue.EmptyQueueException;
import Parciales.primero2021.TuVinoMgt;

public class TuVinoImpl implements TuVinoMgt {
    //Están en public para poder usarlo en los test
    public MyLinkedListImpl<Usuario> usuarios = new MyLinkedListImpl<>();
    public MyLinkedListImpl<Vino> vinos = new MyLinkedListImpl<>();

    @Override
    public void crearVino(String nombre, String variedad, String pais, int cosecha) throws EntidadYaExiste {
        if (buscarVino(nombre) != null) {
            throw new EntidadYaExiste("El vino ya existe");
        }
        final var vino = new Vino(nombre, variedad, pais, cosecha);
        vinos.add(vino);
    }

    @Override
    public void agregarVinoQueGusta(int cedula, String nombreVino) throws EntidadNoExiste {
        if (buscarVino(nombreVino) == null) {
            throw new EntidadNoExiste("El vino no existe");
        }
        Usuario usuario = buscarUsuario(cedula);
        Vino vino = buscarVino(nombreVino);
        usuario.getMeGusta().add(vino);
    }

    @Override
    public void agregarRecomendacion(int cedula, int cedulaARecomendar, String nombreVino) throws EntidadNoExiste {
        Usuario usuarioRecomienda = buscarUsuario(cedula);
        Usuario usuarioARecomendar = buscarUsuario(cedulaARecomendar);
        Vino vino = buscarVino(nombreVino);
        Recomendacion recomendacion = new Recomendacion(usuarioARecomendar, vino);

        usuarioARecomendar.getMeRecomendaron().enqueue(vino);
        usuarioRecomienda.getRecomendaciones().enqueue(recomendacion);
    }

    @Override
    public Vino obtenerProximaRecomendacion(int cedula) throws EntidadNoExiste, EmptyQueueException {
        Usuario usuario = buscarUsuario(cedula);
        if (usuario.getRecomendaciones().size() == 0) {
            return null;
        }
        Recomendacion recomendacion = usuario.getRecomendaciones().dequeue();
        return recomendacion.getVinoARecomendar();
    }

    @Override
    public void intercambiarVinos(int cedula, String nombreVino1, String nombreVino2) throws EntidadNoExiste {
        Usuario usuario = buscarUsuario(cedula);
        Vino vino1 = buscarVino(nombreVino1);
        Vino vino2 = buscarVino(nombreVino2);

        if (vino1 == null || vino2 == null) {
            throw new EntidadNoExiste("El vino no existe");
        }
        usuario.getMeRecomendaron().exchangeElements(vino1, vino2);
    }

    @Override
    public void eliminarOcurrenciasRepetidasVino(int cedula, String nombreVino) throws EntidadNoExiste {
        Usuario usuario = buscarUsuario(cedula);
        Vino vino = buscarVino(nombreVino);

        if (vino == null) {
            throw new EntidadNoExiste("El vino no existe");
        }
        usuario.getMeRecomendaron().removeRepeated(vino);
        //eliminarOcurrenciasRepetidas(vino);
        // esto es si se quiere eliminar todos los vinos excepto el primero de la lista de vinos
    }

    private Vino buscarVino(String nombreVino) {
        if (vinos.size() == 0) {
            return null;
        }
        for (int i = 0; i < vinos.size(); i++) {
            if (vinos.get(i).getNombre().equals(nombreVino)) {
                return vinos.get(i);
            }
        }
        return null;
    }

    public Usuario buscarUsuario(int cedula) throws EntidadNoExiste {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCedula() == cedula) {
                return usuarios.get(i);
            }
        }
        throw new EntidadNoExiste("El usuario no existe");
    }

    private void eliminarOcurrenciasRepetidas(Vino vino) {
        boolean primeraOcurrenciaEncontrada = false;
        for (int i = 0; i < vinos.size(); i++) {
            if (vino.getNombre().equals(vinos.get(i).getNombre())) {
                if (!primeraOcurrenciaEncontrada) {
                    primeraOcurrenciaEncontrada = true;
                } else {
                    vinos.remove(vino);
                    i--;
                }
            }
        }
    }

}
