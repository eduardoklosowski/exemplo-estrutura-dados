package creche;

public class FilaArray<T> implements Fila<T> {
    private T[] array;
    private int inicio;
    private int fim;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public FilaArray() {
        array = (T[]) new Object[2];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    public void enfileirar(T valor) {
        if (tamanho == array.length) {
            T[] novoArray = (T[]) new Object[array.length * 2];
            int j = 0;
            if (inicio < fim) {
                for (int i = inicio; i < fim; i++) {
                    novoArray[j++] = array[i];
                }
            } else {
                for (int i = inicio; i < array.length; i++) {
                    novoArray[j++] = array[i];
                }
                for (int i = 0; i < fim; i++) {
                    novoArray[j++] = array[i];
                }
            }
            array = novoArray;
            inicio = 0;
            fim = j;
        }
        array[fim] = valor;
        fim = (fim + 1) % array.length;
        tamanho++;
    }

    public T desenfileirar() {
        if (tamanho == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T valor = array[inicio];
        array[inicio] = null;
        inicio = (inicio + 1) % array.length;
        tamanho--;
        return valor;
    }
}
