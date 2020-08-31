package creche;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex02ListaArray {
    @Test
    public void testaListaArray() {
        ListaArray lista = new ListaArray();
        assertEquals(0, lista.tamanho());

        lista.adicionar(10);
        assertEquals(1, lista.tamanho());
        assertEquals(10, lista.pegar(0));

        lista.adicionar(25);
        lista.adicionar(20);
        lista.adicionar(10);
        assertEquals(4, lista.tamanho());

        assertEquals(20, lista.pegar(2));
        lista.remover(2);
        assertEquals(3, lista.tamanho());
        assertEquals(10, lista.pegar(2));
    }
}