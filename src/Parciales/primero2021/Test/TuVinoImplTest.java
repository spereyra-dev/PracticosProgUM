package Parciales.primero2021.Test;

import Parciales.primero2021.Entidades.Recomendacion;
import Parciales.primero2021.Entidades.Usuario;
import Parciales.primero2021.Entidades.Vino;
import Parciales.primero2021.Excepciones.EntidadNoExiste;
import Parciales.primero2021.Excepciones.EntidadYaExiste;
import Parciales.primero2021.Impl.TuVinoImpl;
import Parciales.primero2021.TAD.linkedlist.MyLinkedListImpl;
import Parciales.primero2021.TAD.queue.EmptyQueueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuVinoImplTest {
    TuVinoImpl tuVinoImpl = new TuVinoImpl();
    MyLinkedListImpl<Recomendacion> recomendacion = new MyLinkedListImpl<>();
    MyLinkedListImpl<Vino> vinos = new MyLinkedListImpl<>();

    @Test
    void testCrearVino() throws EntidadNoExiste, EntidadYaExiste {
        tuVinoImpl.crearVino("Malbec", "Tinto", "Argentina", 2019);
        assertEquals(1, tuVinoImpl.vinos.size());
        assertEquals("Malbec", tuVinoImpl.vinos.peek().getNombre());
    }

    @Test
    void testAgregarVinoQueGusta() throws EntidadNoExiste, EntidadYaExiste {
        tuVinoImpl.usuarios.add(new Usuario(123, recomendacion, vinos));
        tuVinoImpl.crearVino("Malbec", "Tinto", "Argentina", 2019);
        tuVinoImpl.agregarVinoQueGusta(123, "Malbec");
        assertEquals(1, tuVinoImpl.usuarios.size());
        assertTrue(tuVinoImpl.usuarios.peek().getMeGusta().contains(tuVinoImpl.vinos.peek()));
    }

    @Test
    void testAgregarRecomendacion() throws EntidadNoExiste, EntidadYaExiste, EmptyQueueException {
        tuVinoImpl.usuarios.add(new Usuario(123, recomendacion, vinos));
        tuVinoImpl.usuarios.add(new Usuario(234, recomendacion, vinos));
        tuVinoImpl.crearVino("Malbec", "Tinto", "Argentina", 2019);
        tuVinoImpl.agregarRecomendacion(123, 234, "Malbec");

        assertEquals(2, tuVinoImpl.usuarios.size());
        assertTrue(tuVinoImpl.usuarios.get(1).getMeRecomendaron().contains(tuVinoImpl.vinos.peek()));
        assertEquals("Malbec", tuVinoImpl.usuarios.get(0).getRecomendaciones().peek().getVinoARecomendar().getNombre());
        assertEquals(234, tuVinoImpl.usuarios.get(0).getRecomendaciones().peek().getUsuario().getCedula());
        assertEquals(tuVinoImpl.usuarios.get(1).getMeRecomendaron().dequeue().getNombre(), tuVinoImpl.usuarios.get(0).getRecomendaciones().peek().getVinoARecomendar().getNombre());
    }

    @Test
    void testObtenerProximaRecomendacion() throws EntidadNoExiste, EntidadYaExiste, EmptyQueueException {
        tuVinoImpl.usuarios.add(new Usuario(123, recomendacion, vinos));
        tuVinoImpl.usuarios.add(new Usuario(234, recomendacion, vinos));
        tuVinoImpl.crearVino("Malbec", "Tinto", "Argentina", 2019);
        tuVinoImpl.agregarRecomendacion(123, 234, "Malbec");
        tuVinoImpl.crearVino("Cabernet", "Tinto", "Argentina", 2019);
        tuVinoImpl.agregarRecomendacion(123, 234, "Cabernet");

        assertEquals("Malbec", tuVinoImpl.obtenerProximaRecomendacion(123).getNombre());
        assertEquals("Cabernet", tuVinoImpl.obtenerProximaRecomendacion(123).getNombre());
    }

    @Test
    void testIntercambiarVinos() throws EntidadYaExiste, EntidadNoExiste {
        tuVinoImpl.usuarios.add(new Usuario(123, recomendacion, vinos));
        tuVinoImpl.usuarios.add(new Usuario(234, recomendacion, vinos));
        tuVinoImpl.crearVino("Malbec", "Tinto", "Argentina", 2019);
        tuVinoImpl.agregarRecomendacion(123, 234, "Malbec");
        tuVinoImpl.crearVino("Cabernet", "Tinto", "Argentina", 2019);
        tuVinoImpl.agregarRecomendacion(123, 234, "Cabernet");

        assertDoesNotThrow(() -> tuVinoImpl.intercambiarVinos(123, "Malbec", "Cabernet"));
        assertThrows(EntidadNoExiste.class, () -> tuVinoImpl.intercambiarVinos(123, "FakeVino", "Cabernet"));
    }

    @Test
    void testEliminarOcurrenciasRepetidasVino() throws EntidadNoExiste, EntidadYaExiste {
        tuVinoImpl.usuarios.add(new Usuario(123, recomendacion, vinos));
        tuVinoImpl.usuarios.add(new Usuario(234, recomendacion, vinos));
        tuVinoImpl.crearVino("Malbec", "Tinto", "Argentina", 2019);
        tuVinoImpl.agregarRecomendacion(123, 234, "Malbec");
        tuVinoImpl.agregarRecomendacion(123, 234, "Malbec");
        tuVinoImpl.agregarRecomendacion(123, 234, "Malbec");

        assertEquals(3,tuVinoImpl.usuarios.get(1).getRecomendaciones().size());

        tuVinoImpl.eliminarOcurrenciasRepetidasVino(123, "Malbec");
        assertEquals(1,tuVinoImpl.usuarios.get(1).getMeRecomendaron().size());
        assertDoesNotThrow(() -> tuVinoImpl.eliminarOcurrenciasRepetidasVino(123, "Malbec"));
        assertThrows(EntidadNoExiste.class, () -> tuVinoImpl.eliminarOcurrenciasRepetidasVino(123, "FakeVino"));
    }

    @Test
    void testBuscarUsuarios() throws EntidadNoExiste {
        tuVinoImpl.usuarios.add(new Usuario(123, recomendacion, vinos));
        tuVinoImpl.usuarios.add(new Usuario(234, recomendacion, vinos));
        assertEquals(123, tuVinoImpl.buscarUsuario(123).getCedula());
        assertEquals(234, tuVinoImpl.buscarUsuario(234).getCedula());
        assertNotEquals(345, tuVinoImpl.buscarUsuario(234).getCedula());
        assertThrows(EntidadNoExiste.class, () -> tuVinoImpl.buscarUsuario(345));
    }
}