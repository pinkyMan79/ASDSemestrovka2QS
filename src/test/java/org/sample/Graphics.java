package org.sample;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class Graphics extends JFrame {

    public static void main(String[] args) {

        Graphics g = new Graphics();

        JPanel p = g.createDemoPanel();
        JFrame fr = new JFrame();
        fr.setSize(1900, 1000);
        fr.setVisible(true);
        fr.add(p);
        fr.setResizable(false);

    }

    private static XYDataset createDataset() {

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.removeAllSeries();

        TimeSeries s1 = new TimeSeries("Speed on Bench");
        s1.addOrUpdate(new Millisecond(), 839408.48);
        s1.addOrUpdate(new Millisecond(), 831408.48);
        s1.addOrUpdate(new Millisecond(), 989950.35);
        s1.addOrUpdate(new Millisecond(), 873326.89);
        s1.addOrUpdate(new Millisecond(), 890497.64);
        s1.addOrUpdate(new Millisecond(), 888555.26);
        s1.addOrUpdate(new Millisecond(), 898555.26);
        s1.addOrUpdate(new Millisecond(), 868555.26);
        s1.addOrUpdate(new Millisecond(), 900249.12);


        TimeSeries s2 = new TimeSeries("Speed on Errors");
        s2.addOrUpdate(new Millisecond(), 321429.032);
        s2.addOrUpdate(new Millisecond(), 329429.032);
        s2.addOrUpdate(new Millisecond(), 27649.410);
        s2.addOrUpdate(new Millisecond(), 358362.676);
        s2.addOrUpdate(new Millisecond(), 419953.668);
        s2.addOrUpdate(new Millisecond(), 1419953.668);
        s2.addOrUpdate(new Millisecond(), 473533.899);

        dataset.addSeries(s1);
        dataset.addSeries(s2);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset)
    {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Speed Graphics",  // title
                "",                            // x-axis label
                "Long Time(miliseconds, ops/s)",                      // y-axis label
                dataset,                       // data
                true,                          // create legend
                true,                          // generate tooltips
                false                          // generate URLs
        );

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint    (Color.lightGray);
        plot.setDomainGridlinePaint(Color.white    );
        plot.setRangeGridlinePaint (Color.white    );
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible   (true);
            renderer.setBaseShapesFilled    (true);
            renderer.setDrawSeriesLineAsPath(true);
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();


        return chart;
    }

    public JPanel createDemoPanel()
    {
        JFreeChart chart = createChart(createDataset());
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(600, 300));
        return panel;
    }

}
