/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analisis.de.algoritmos;

import java.util.Random;

/**
 *
 * @author fferraris
 */
public class AnalisisDeAlgoritmos {

    public static int ultDigito(int n) {
        int ultimoDig = Math.abs(n) % 10;
        // Una op aritmetica es de orden constante. 
        // Tiempo % O(1) 
        // Tiempo = O(1)
        // Tiempo Math.abs O(1)

        return ultimoDig;
    }

    public static void main(String[] args) {
        int dig;
        int n;
        long acc = 0;
        int cantPruebas = 100000;
        Random r = new Random();
        long[][] tiempos = new long[2][cantPruebas];

        //Generamos un lote de pruebas 
        for (int i = 0; i < cantPruebas; i++) {
            n = r.nextInt();
            long inicio = System.nanoTime();
            dig = ultDigito(n);
            long fin = System.nanoTime();
            long tiempoEj = fin - inicio;
            acc += tiempoEj;
            System.out.println("[" + i + "]\tTiempo de ejecución: " + tiempoEj + " nanosegundos_ Para n = " + n);
        }
        System.out.println("Promedio: " + acc / cantPruebas);

    }
}
