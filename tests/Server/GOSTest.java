package Server;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GOSTest {

    @Test
    void main() {
        GOS gos = new GOS();
        assertEquals("Server Configurado", gos.main());
    }
}