package creche;

/**
 * Interface para interagir com o objeto de uma estrutura de dados com ela se comportanto como uma fila, onde o primeiro a entrar é o primeiro a sair (FIFO).
 *
 * @param <T> Tipo dos objetos desta fila
 */
public interface Fila<T> {
    /**
     * Adicionar um item no final fila.
     *
     * @param valor Valor do item
     */
    void enfileirar(T valor);

    /**
     * Remover o primeiro item da fila e retorná-lo.
     *
     * @return Valor do item
     */
    T desenfileirar();
}
