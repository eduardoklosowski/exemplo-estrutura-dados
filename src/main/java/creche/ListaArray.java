package creche;

import java.util.Iterator;

/**
 * Implementação da uma listagem de objetos com array nativo do Java.
 *
 * @param <T> Tipo dos objetos desta lista
 */
public class ListaArray<T> implements Lista<T>, Fila<T>, Pilha<T> {
    /** Array interno da implementação. */
    private T[] array;
    /** Quantidade de posições atualmente ocupadas do array. */
    private int tamanho;

    /**
     * Método construtor da implementação.
     */
    @SuppressWarnings("unchecked")
    public ListaArray() {
        // Cria o array interno e inicia seu tamanho com 0 elementos
        array = (T[]) new Object[2];
        tamanho = 0;
    }

    public int tamanho() {
        // Retorna a quantidade de valores no array interno
        return this.tamanho;
    }

    public T pegar(int indice) {
        // Lança uma exceção caso o índice exceda os elementos das lista
        if (indice >= tamanho) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // Acessa a posição desejada
        return array[indice];
    }

    @SuppressWarnings("unchecked")
    public void adicionar(T valor) {
        // Verifica a necessidade de um array interno maior
        if (tamanho == array.length) {
            // Cria novo array com o dobro do tamanho
            T[] novoArray = (T[]) new Object[array.length * 2];
            // Copia os elementos do array
            for (int i = 0; i < array.length; i++) {
                novoArray[i] = array[i];
            }
            // Troca o array interno
            array = novoArray;
        }
        // Adiciona valor no array interno e incrementa o tamanho
        array[tamanho++] = valor;
    }

    public void remover(int indice) {
        // Verifica se a posição desejada está dentro da lista
        if (indice >= tamanho) {
            return;
        }
        // Copia os elementos posteriores para sobreescrever o valor a ser removido
        int fim = tamanho - 1;
        for (int i = indice; i < fim; i++) {
            array[i] = array[i + 1];
        }
        // Decrementa o tamanho da lista e remove o último valor que ficou duplicado
        array[--tamanho] = null;
    }

    public Iterator<T> iterator() {
        // Cria um objeto de uma classe anônima que permite percorrer a lista
        return new Iterator<T>(){
            /** Posição que está sendo acessada. */
            private int indice = 0;

            /**
             * Informa se ainda existem valores a serem percorridos.
             *
             * @return {@code true} caso exista um próximo valor, {@code false} caso contrário
             */
            public boolean hasNext() {
                return indice < tamanho;
            }

            /**
             * Retorna o próximo valor.
             *
             * @return O próximo valor presente na lista
             */
            public T next() {
                // Pega o valor no array interno e incrementa o índice
                return pegar(indice++);
            }
        };
    }

    public void enfileirar(T valor) {
        adicionar(valor);
    }

    public T desenfileirar() {
        T valor = pegar(0);
        remover(0);
        return valor;
    }

    public void empilhar(T valor) {
        adicionar(valor);
    }

    public T desempilhar() {
        int indice = tamanho - 1;
        T valor = pegar(indice);
        remover(indice);
        return valor;
    }
}
