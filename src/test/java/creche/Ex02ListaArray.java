package creche;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex02ListaArray {
    @Test
    public void testaListaArray() {
        // Cria uma lista de inteiros utilizando a implementação ListaArray
        Lista<Integer> lista = new ListaArray<Integer>();
        assertEquals(0, lista.tamanho());

        // Adiciona um novo valor na lista
        lista.adicionar(10);
        assertEquals(1, lista.tamanho());
        assertEquals(10, lista.pegar(0).intValue());

        // Adiciona vários valores na lista
        lista.adicionar(25);
        lista.adicionar(20);
        lista.adicionar(10);
        assertEquals(4, lista.tamanho());

        // Remove um valor da lista
        assertEquals(20, lista.pegar(2).intValue());
        lista.remover(2);
        assertEquals(3, lista.tamanho());
        assertEquals(10, lista.pegar(2).intValue());

        lista.adicionar(5);

        // Imprime valores na tela
        for (Integer valor : lista) {
            System.out.println(valor);
        }
    }
}
