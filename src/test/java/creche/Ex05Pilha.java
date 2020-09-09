package creche;

import org.junit.Test;

public class Ex05Pilha {
    @Test
    public void testPilhaComListaArray() {
        Pilha<Integer> pilha = new ListaArray<Integer>();

        for (int i = 0; i < 100000; i++) {
            pilha.empilhar(i);
        }
        for (int i = 0; i < 100000; i++) {
            pilha.desempilhar();
        }
    }

    @Test
    public void testPilhaComListaLincada() {
        Pilha<Integer> pilha = new ListaLincada<Integer>();

        for (int i = 0; i < 100000; i++) {
            pilha.empilhar(i);
        }
        for (int i = 0; i < 100000; i++) {
            pilha.desempilhar();
        }
    }
}
