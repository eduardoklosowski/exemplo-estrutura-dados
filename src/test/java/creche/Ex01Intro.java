package creche;

import org.junit.Test;

public class Ex01Intro {
    @Test
    public void usandoLista() {
        int[] array = new int[5];
        int tamanho = 0;
        array[tamanho++] = 10;
        array[tamanho++] = 20;
        array[tamanho++] = 30;
        array[tamanho++] = 40;
        array[tamanho++] = 50;
        if (tamanho == array.length) {
            int[] novoArray = new int[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                novoArray[i] = array[i];
            }
            array = novoArray;
        }
        array[tamanho++] = 60;
        for (int i = 0; i < tamanho; i++) {
            System.out.println(array[i]);
        }
    }
}
