/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analisis.de.algoritmos;

import java.util.Random;


/*
MODULO distMin (ARREGLO ENTERO a, ENTERO n) RETORNA ENTERO 
//Entrada: arreglo de n numeros
//Salida: Minima distancia entre dos elementos cualesquiera del arreglo.
    dmin <-infinito
    
    PARA i <- 0 HASTA n-1 HACER 
        PARA j <- 0 HASTA n-1 HACER 
            if (i!=j y a[i] - a[j]) < dmin ENTONCES 
                dmin <- |a[i] - a[j]|
    RETORNA dmin
FIN ALGORITMO 
 */
public class tresUno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = {923, 811, 702, 6, 54378, 124, 323, 2, 121};
        mergeSort(a);
        System.out.println("Distancia minima: " + distanciaMinima(a));
    }
    
    public static int[] generateArray(int length) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(100000); // Llena con números aleatorios
        }
        return result;
    }

    public static void distMin(int[] a, int n) {//el n se puede calcular de a
        long dmin = Long.MAX_VALUE; //como evito que primero adquiera este valor?
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && a[i] - a[j] < dmin) {//la comparacion i/j se puede evitar 
                    //y que ocurre si la resta es negativa?
                    dmin = Math.abs(a[i] - a[j]);//abs es eficiente?
                }
            }
        }
    }

    /**
     * Metodo para calcular la distancia minima existente entre dos arreglos
     *
     * @param a
     */
    public static int distanciaMinima(int[] a) {
        mergeSort(a);
        int largo = a.length,
                dmin = Integer.MAX_VALUE,
                dist = Integer.MAX_VALUE;
        for (int i = 1; i < largo; i++) {
            dist = Math.abs(a[i - 1] - a[i]);
            if (dist < dmin) {
                dmin = dist;
            }
        }
        return dmin;
    }

    public static void mergeSort(int[] arreglo) {
        int largo = arreglo.length;
        if (largo > 1) {
            int medio = largo / 2;
            int[] izquierda = copiarEnRango(arreglo, 0, medio),
                    derecha = copiarEnRango(arreglo, medio, largo);
            mergeSort(izquierda);
            mergeSort(derecha);
            merge(arreglo, izquierda, derecha);
        }
    }

    public static void merge(int[] arreglo, int[] izquierda, int[] derecha) {
        int indiceIzq = 0,
                indiceDer = 0,
                indiceArr = 0,
                largoIzq = izquierda.length,
                largoDer = derecha.length;
        while (indiceIzq < largoIzq && indiceDer < largoDer) {
            if (izquierda[indiceIzq] <= derecha[indiceDer]) {
                arreglo[indiceArr++] = izquierda[indiceIzq++];
            } else {
                arreglo[indiceArr++] = derecha[indiceDer++];
            }
        }

        while (indiceIzq < largoIzq) {
            arreglo[indiceArr++] = izquierda[indiceIzq++];
        }

        while (indiceDer < largoDer) {
            arreglo[indiceArr++] = derecha[indiceDer++];
        }
    }

    public static int[] copiarEnRango(int[] a, int desde, int hasta) {
        int[] retorno = new int[hasta - desde];
        for (int i = 0; i < retorno.length; i++) {
            retorno[i] = a[desde++];
        }
        return retorno;
    }
}
