package creche;

import java.util.Iterator;

class ListaLincadaItem<T> {
    public T valor;
    public ListaLincadaItem<T> proximo = null;

    public ListaLincadaItem(T valor) {
        this.valor = valor;
    }
}

public class ListaLincada<T> implements Lista<T> {
    private int tamanho = 0;
    private ListaLincadaItem<T> primeiro = null;
    private ListaLincadaItem<T> ultimo = null;

    public int tamanho() {
        return this.tamanho;
    }

    public T pegar(int indice) {
        if (indice >= tamanho) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ListaLincadaItem<T> item = primeiro;
        for (int i = 0; i < indice; i++) {
            item = item.proximo;
        }
        return item.valor;
    }

    public void adicionar(T valor) {
        ListaLincadaItem<T> novo = new ListaLincadaItem<T>(valor);
        if (tamanho == 0) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
        tamanho++;
    }

    public void remover(int indice) {
        if (indice >= tamanho) {
            return;
        }
        if (tamanho == 1) {
            primeiro = null;
            ultimo = null;
        } else if (indice == 0) {
            primeiro = primeiro.proximo;
        } else {
            ListaLincadaItem<T> anterior = primeiro;
            ListaLincadaItem<T> item = primeiro.proximo;
            for (int i = 1; i < indice; i++) {
                anterior = item;
                item = item.proximo;
            }
            anterior.proximo = item.proximo;
            if (item == ultimo) {
                ultimo = anterior;
            }
        }
        tamanho--;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private ListaLincadaItem<T> item = primeiro;

            public boolean hasNext() {
                return item != null;
            }

            public T next() {
                T valor = item.valor;
                item = item.proximo;
                return valor;
            }
        };
    }
}
