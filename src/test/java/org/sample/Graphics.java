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
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
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

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.removeAllSeries();

        XYSeries s1 = new XYSeries("Speed on Bench");
        s1.add(1.0, 839408.48);
        s1.add(2.0, 831408.48);
        s1.add(3.0, 989950.35);
        s1.add(4.0, 873326.89);
        s1.add(5.0, 890497.64);
        s1.add(6.0, 888555.26);
        s1.add(7.0, 898555.26);
        s1.add(8.0, 868555.26);
        s1.add(9.0, 900249.12);
        s1.add(10.0, 828744.674);
        s1.add(11.0, 830501.530);
        s1.add(12.0, 846423.508);


        XYSeries s2 = new XYSeries("Speed on Errors");
        s2.add(1.0, 321429.032);
        s2.add(2.0, 329429.032);
        s2.add(3.0, 27649.410);
        s2.add(4.0, 358362.676);
        s2.add(5.0, 419953.668);
        s2.add(6.0, 141993.668);
        s2.add(7.0, 473533.899);
        s2.add(8.0, 383879.257);
        s2.add(9.0, 261467.949);
        s2.add(9.0, 419314.410);


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
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
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
