package katahistograma;

import java.awt.PopupMenu;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class ChartHistogramViewer<T> extends HistogramViewer<T> {

    public ChartHistogramViewer(Histogram<T> histogram) {
        super(histogram);
    }

    @Override
    public void show() {
        ApplicationFrame frame = new ApplicationFrame("Histogram");
        frame.add(createChartPanel());
        frame.pack();
        frame.setVisible(true);
    }

    private ChartPanel createChartPanel() {
        ChartPanel panel = new ChartPanel(creteChart());
        return panel;
    }

    private JFreeChart creteChart() {
        JFreeChart chart = ChartFactory.createBarChart("Histogram", "Categories",  "Frecuency", createDataSet());
        return chart;
    }

    private CategoryDataset createDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (T item : getHistogram().keySet()) {
            dataset.addValue(getHistogram().get(item), "Categories", (String)item);
        }
        return dataset;
    }
    
    
}
