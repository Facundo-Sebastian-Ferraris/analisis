package analisis.de.algoritmos;

import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;

/**
 * @author Ferraris Facundo FAI [3820] CODIGO HECHO PARA REALIZAR PRUEBAS BATCH
 *
 * ADVERTENCIA: SE SUGIERE QUE NO HAYA IMPRESIONES POR PANTALLA NI DATOS A
 * INGRESAR POR TECLADO YA QUE AFECTA AL CALCULO
 */
public class BatchTester implements Runnable {

    // CONFIGURACIONES
    private final long N = 100000;                       // Cantidad de pruebas
    private final boolean mostrarIteracion = false;    // Mostrar cada iteración
    private int[] a = generateArray(100);        // Array aleatorio con tantos elementos
    private final boolean resetArreglo = false;        // Refrescar arreglo por iteración
    private final boolean GRAFICAR = true;        // Abrir ventana de grafico

    /**
     * Método principal de pruebas
     */
    public void main() {
        int i = 2;
    }
    // IGNORAR!!!!
    // VARIABLES PARA TIEMPOS Y GRAFICOS
    private GraficoDeLineas grafico = new GraficoDeLineas("Resultado de Prueba", N, a.length);
    private long t0;                             // Tiempo inicial
    private long totalParcial;                   // Tiempo parcial
    private long tMaximo = 0;                    // Tiempo máximo
    private long tMinimo = Long.MAX_VALUE;       // Tiempo mínimo
    private long total = 0;                      // Tiempo total
    private double mean;                         // Tiempo promedio

    /**
     * Genera un array de enteros aleatorios de la longitud especificada
     *
     * @param length Tamaño del arreglo a generar
     * @return Array de enteros aleatorios
     */
    public static int[] generateArray(int length) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(100000); // Llena con números aleatorios
        }
        return result;
    }

    @Override
    public void run() {
        int[] aBackUp = a.clone();  // Respaldo del arreglo original
        long porcentajeAnterior = 0;
        // Definir el paso del porcentaje de progreso
        // Para evitar imprimir el mismo porcentaje varias veces

        for (int i = 0; i < this.N; i++) {
            this.t0 = System.nanoTime();        // Tiempo inicial
            main();                             // Ejecuta la prueba
            this.totalParcial = System.nanoTime() - this.t0;  // Tiempo parcial

            if (mostrarIteracion) {
                System.out.println("[" + i + "]:\t" + this.totalParcial + "\tns");
            }

            this.total += this.totalParcial;
            actualizarTiempos(this.totalParcial);  // Actualizar tiempos mínimos y máximos

            if (this.GRAFICAR) {
                // Añadir el tiempo parcial al gráfico
                this.grafico.dataset.addValue(this.totalParcial, "total", i + "");
            }

            // Resetea el arreglo si está configurado
            if (resetArreglo) {
                a = generateArray(1000);
            } else {
                a = aBackUp;
            }

            // Cálculo y impresión del porcentaje de progreso
            int porcentajeActual = (int) ((i + 1) * 100 / this.N);  // Calcula el porcentaje actual
            if (porcentajeActual >= porcentajeAnterior + 1) {       // Imprime cada 10%
                System.out.println("Progreso: " + porcentajeActual + "% completado");
                porcentajeAnterior = porcentajeActual;
            }
        }

        // Calcular el tiempo promedio
        this.mean = this.total / this.N;
        imprimirResultados();  // Imprimir resultados

        if (this.GRAFICAR) {
            // Mostrar el gráfico
            this.grafico.setSize(1000, 720);
            this.grafico.setLocationRelativeTo(null);
            this.grafico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.grafico.setVisible(true);
        }

    }

    /**
     * Actualiza el tiempo mínimo
     *
     * @param t Tiempo de la iteración actual
     */
    private void actualizarTiempos(long t) {
        if (t < this.tMinimo) {
            this.tMinimo = t;
        }
        if (t > this.tMaximo) {
            this.tMaximo = t;
        }
    }

    /**
     * Imprime los resultados del tiempo total, máximo, mínimo y promedio
     */
    private void imprimirResultados() {
        System.out.println("Numero de elementos del arreglo: " + a.length);
        System.out.println("Cantidad de pruebas\t=\t" + this.N);
        System.out.println("-------------------------------------------");
        System.out.println("Tiempo Maximo\t=\t" + this.tMaximo + "\tns");
        System.out.println("Tiempo Minimo\t=\t" + this.tMinimo + "\tns");
        System.out.println("Tiempo promedio\t=\t" + this.mean + "\tns");
    }

    /**
     * Clase interna para crear el gráfico de líneas con JFreeChart
     */
    public class GraficoDeLineas extends JFrame {

        public DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        public GraficoDeLineas(String titulo, long resultConNPruebas, long sizeArreglo) {
            super(titulo);

            // Crear gráfico
            JFreeChart chart = ChartFactory.createLineChart(
                    resultConNPruebas + " pruebas con a[" + sizeArreglo + "]", // Título
                    "N° Prueba", // Eje X
                    "T(n) (ns)", // Eje Y
                    dataset
            );

            // Crear panel con el gráfico
            ChartPanel panel = new ChartPanel(chart);
            setContentPane(panel);
        }
    }

    /**
     * Método main para iniciar las pruebas batch
     *
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        BatchTester hiloMain = new BatchTester();
        hiloMain.run();
    }
}
