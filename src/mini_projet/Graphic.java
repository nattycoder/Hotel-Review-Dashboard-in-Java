package mini_projet;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class Graphic extends JFrame {

    public Graphic( HashMap<Date, Integer> data) {
        

        
        TimeSeries series = new TimeSeries("Data");
        for (Map.Entry<Date, Integer> entry : data.entrySet()) {
            series.addOrUpdate(new Second(entry.getKey()), entry.getValue());
        }

        // Création du graphique
        TimeSeriesCollection dataset = new TimeSeriesCollection(series);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Resultats ",
                "Date",
                "Valeur",
                dataset
        );

        
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setRenderer(new XYSplineRenderer());

        
        plot.getDomainAxis();
        
       
        plot.getRangeAxis();
        

       
        ChartPanel pan = new ChartPanel(chart);
        JDialog dg=new JDialog();
        dg.add(pan);
        dg.setSize(600, 400);
        dg.setLocationRelativeTo(null);
        dg.setVisible(true);
    }

}

