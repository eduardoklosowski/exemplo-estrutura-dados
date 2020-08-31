package creche;

public class ListaArray {
    private int[] array;
    private int tamanho;

    public ListaArray() {
        array = new int[2];
        tamanho = 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public int pegar(int indice) {
        if (indice >= tamanho) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[indice];
    }

    public void adicionar(int valor) {
        if (tamanho == array.length) {
            int[] novoArray = new int[array.length * 2];
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
        array[--tamanho] = 0;
    }
}
