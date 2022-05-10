package org.sample;

import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeriesDataItem;

public class BenchDataSet extends TimeSeriesDataItem {


    public BenchDataSet(RegularTimePeriod period, Number value) {
        super(period, value);
    }
}
