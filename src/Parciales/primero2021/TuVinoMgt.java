package Parciales.primero2021;

import Parciales.primero2021.Entidades.Vino;
import Parciales.primero2021.Excepciones.EntidadNoExiste;
import Parciales.primero2021.Excepciones.EntidadYaExiste;
import Parciales.primero2021.TAD.queue.EmptyQueueException;

public interface TuVinoMgt {
    void crearVino(String nombre, String variedad, String pais, int cosecha) throws EntidadYaExiste, EntidadNoExiste;

    void agregarVinoQueGusta(int cedula, String nombreVino) throws EntidadNoExiste;

    void agregarRecomendacion(int cedula, int cedulaARecomendar, String nombreVino) throws EntidadNoExiste;

    Vino obtenerProximaRecomendacion(int cedula) throws EntidadNoExiste, EmptyQueueException;

    void intercambiarVinos(int cedula, String nombreVino1, String nombreVino2) throws EntidadNoExiste;

    void eliminarOcurrenciasRepetidasVino(int cedula, String nombreVino) throws EntidadNoExiste;
}
