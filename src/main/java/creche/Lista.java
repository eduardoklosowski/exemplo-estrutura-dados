package creche;

public interface Lista<T> extends Iterable<T> {
    int tamanho();
    T pegar(int indice);
    void adicionar(T valor);
    void remover(int indice);
}
