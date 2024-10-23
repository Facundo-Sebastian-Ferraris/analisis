
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;

public class GraficoDeLineas extends JFrame {

    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public GraficoDeLineas(String titulo) {
        super(titulo);

        // Crear dataset
        // Crear gráfico
        JFreeChart chart = ChartFactory.createLineChart(
                "Resultados de Test Batch", // Título
                "prueba", // Eje X
                "T(n)", // Eje Y
                dataset
        );

        // Crear panel con el gráfico
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

    }

    public void agregarDato(long data, String cat, String a) {
        this.dataset.addValue(data, cat, a);
    }

    public static void main(String[] args) {
        GraficoDeLineas example = new GraficoDeLineas("Ejemplo de JFreeChart");
        example.agregarDato(1, "C1", "2019");
        example.agregarDato(2, "C1", "2020");
        example.agregarDato(3, "C1", "2021");
        example.agregarDato(1, "C1", "2022");
        example.agregarDato(34, "C1", "2023");
        example.agregarDato(12, "C1", "2024");
        example.agregarDato(6, "C1", "2025");
        example.agregarDato(1, "C1", "2026");
        example.agregarDato(-1, "C1", "2027");
       
        example.setSize(1500, 1000);
        example.setLocationRelativeTo(null);
        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        example.setVisible(true);
    }
}
