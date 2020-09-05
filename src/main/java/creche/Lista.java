package creche;

/**
 * Interface para interagir com o objeto de uma estrutura de dados com ela se comportanto como uma lista.
 *
 * @param <T> Tipo dos objetos desta lista
 */
public interface Lista<T> extends Iterable<T> {
    /**
     * Verifica o tamanho da lista.
     *
     * @return A quantidade de itens que existem atualmente na lista.
     */
    int tamanho();

    /**
     * Pega o valor de uma posição específica da lista.
     *
     * @param indice Posição do valor (índice) desejado
     * @return Valor do elemento nesta posição
     */
    T pegar(int indice);

    /**
     * Adiciona um valor ao final da lista.
     *
     * @param valor Valor a ser adicionado na lista
     */
    void adicionar(T valor);

    /**
     * Remove o valor de uma posição específica da lista.
     *
     * @param indice Posição do valor (índice) desejado
     */
    void remover(int indice);
}
