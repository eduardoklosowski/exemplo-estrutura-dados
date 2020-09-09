package creche;

/**
 * Interface para interagir com o objeto de uma estrutura de dados com ela se comportanto como uma pilha, onde o primeiro a entrar é o último a sair (FILO).
 *
 * @param <T> Tipo dos objetos desta fila
 */
public interface Pilha<T> {
    /**
     * Adiciona um item no final da pilha.
     *
     * @param valor Valor do item
     */
    void empilhar(T valor);

    /**
     * Remover o primeiro item da fila e retorná-lo.
     *
     * @return Valor do item
     */
    T desempilhar();
}
