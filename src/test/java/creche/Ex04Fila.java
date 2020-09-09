package creche;

import org.junit.Test;

public class Ex04Fila {
    @Test
    public void testFilaComListaArray() {
        Fila<Integer> fila = new ListaArray<Integer>();

        for (int i = 0; i < 100000; i++) {
            fila.enfileirar(i);
        }
        for (int i = 0; i < 100000; i++) {
            fila.desenfileirar();
        }
    }

    @Test
    public void testFilaComListaLincada() {
        Fila<Integer> fila = new ListaLincada<Integer>();

        for (int i = 0; i < 100000; i++) {
            fila.enfileirar(i);
        }
        for (int i = 0; i < 100000; i++) {
            fila.desenfileirar();
        }
    }
}
