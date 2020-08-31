package creche;

import java.util.Iterator;

public class ListaArray<T> implements Lista<T> {
    private T[] array;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public ListaArray() {
        array = (T[]) new Object[2];
        tamanho = 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public T pegar(int indice) {
        if (indice >= tamanho) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) array[indice];
    }

    @SuppressWarnings("unchecked")
    public void adicionar(T valor) {
        if (tamanho == array.length) {
            T[] novoArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                novoArray[i] = array[i];
            }
            array = novoArray;
        }
        array[tamanho++] = valor;
    }

    public void remover(int indice) {
        if (indice >= tamanho) {
            return;
        }
        int fim = tamanho - 1;
        for (int i = indice; i < fim; i++) {
            array[i] = array[i + 1];
        }
        array[--tamanho] = null;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private int indice = 0;

            public boolean hasNext() {
                return indice < tamanho;
            }

            public T next() {
                return pegar(indice++);
            }
        };
    }
}
