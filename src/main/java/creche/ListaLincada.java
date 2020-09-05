package creche;

import java.util.Iterator;

/**
 * Estrutura usada internamente pela implementação de lista lincada.
 *
 * @param <T> Tipo dos objetos da lista
 */
class ListaLincadaItem<T> {
    /** Valor guardado nesta posição da lista. */
    public T valor;
    /** Referência para a próxima posição da lista. */
    public ListaLincadaItem<T> proximo = null;

    /**
     * Método construtor que recebe um valor.
     *
     * @param valor Valor dessa posição da lista.
     */
    public ListaLincadaItem(T valor) {
        this.valor = valor;
    }
}

/**
 * Implementação da uma listagem de objetos com uma lista lincada,
 * onde um elemento aponta para o seu próximo.
 *
 * @param <T> Tipo dos objetos desta lista
 */
public class ListaLincada<T> implements Lista<T> {
    /** Quantidade de elementos presentes na estrutura de dados. */
    private int tamanho = 0;
    /** Referência para a primeira posição da lista. */
    private ListaLincadaItem<T> primeiro = null;
    /** Referência para a última posição da lista. */
    private ListaLincadaItem<T> ultimo = null;

    public int tamanho() {
        // Retorna a quatidade de elementos presentes na estrutura de dados
        return this.tamanho;
    }

    public T pegar(int indice) {
        // Lança uma exceção caso o índice exceda os elementos das lista
        if (indice >= tamanho) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // Percorre a lista da primeira posição até a posição desejada
        ListaLincadaItem<T> item = primeiro;
        for (int i = 0; i < indice; i++) {
            item = item.proximo;
        }
        // Retorna o valor presente nessa posição
        return item.valor;
    }

    public void adicionar(T valor) {
        // Cria uma nova posição da estrutura
        ListaLincadaItem<T> novo = new ListaLincadaItem<T>(valor);
        if (tamanho == 0) {
            // Caso seja o primeiro valor da estrutura
            primeiro = novo;
            ultimo = novo;
        } else {
            // Caso a estrutura já tenha algum valor
            ultimo.proximo = novo;
            ultimo = novo;
        }
        // Incrementa a quantidade de valores na estrutura
        tamanho++;
    }

    public void remover(int indice) {
        // Verifica se a posição desejada está dentro da lista
        if (indice >= tamanho) {
            return;
        }
        if (tamanho == 1) {
            // Caso a estrutura só tenha um único valor
            primeiro = null;
            ultimo = null;
        } else if (indice == 0) {
            // Caso o valor seja o primeiro da lista
            primeiro = primeiro.proximo;
        } else {
            // Demais casos
            // Percorre a lista até a posição, guardando a referência da posição anterior também
            ListaLincadaItem<T> anterior = primeiro;
            ListaLincadaItem<T> item = primeiro.proximo;
            for (int i = 1; i < indice; i++) {
                anterior = item;
                item = item.proximo;
            }
            // Altera as referência para pular o item a ser removido
            anterior.proximo = item.proximo;
            // Atualiza referência caso remova o último elemento
            if (item == ultimo) {
                ultimo = anterior;
            }
        }
        // Decrementa a quantidade de valores na estrutura
        tamanho--;
    }

    public Iterator<T> iterator() {
        // Cria um objeto de uma classe anônima que permite percorrer a lista
        return new Iterator<T>() {
            /** Referência do item que está sendo percorrido. */
            private ListaLincadaItem<T> item = primeiro;

            /**
             * Informa se ainda existem valores a serem percorridos.
             *
             * @return {@code true} caso exista um próximo valor, {@code false} caso contrário
             */
            public boolean hasNext() {
                return item != null;
            }

            /**
             * Retorna o próximo valor.
             *
             * @return O próximo valor presente na lista
             */
            public T next() {
                // Pega o valor da estrutura e atualiza a referência para a próxima posição
                T valor = item.valor;
                item = item.proximo;
                return valor;
            }
        };
    }
}
