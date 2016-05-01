package org.pawkrol.own.observerpattern.observers;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.pawkrol.own.observerpattern.R;
import org.pawkrol.own.observerpattern.subjects.DataSubject;
import org.pawkrol.own.observerpattern.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawkrol on 4/30/16.
 */
public class BarGraphFragment extends ObserverFragment{

    private BarChart barChart;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bar_graph_fragment, container, false);
        if (view == null){
            return null;
        }

        barChart = (BarChart) view.findViewById(R.id.barchart);
        initChart();

        return view;
    }


    @Override
    public void update(Subject subject) {
        prevActiveSubject = subject;

        if (getView() == null) return;

        if (subject instanceof DataSubject) {
            barChart.setData(
                    getBarData(((DataSubject) subject).getValues())
            );
            barChart.invalidate();
        }
    }

    private BarData getBarData(List<Float> values){
        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();
        int i = 0;

        for (Float f : values){
            entries.add(new BarEntry(f, i));
            labels.add("" + i++);
        }

        BarDataSet batDataSet = new BarDataSet(entries, "");
        batDataSet.setColor(Color.argb(255, 51, 161, 143));
        batDataSet.setValueTextSize(14.f);

        return new BarData(labels, batDataSet);
    }

    private void initChart(){
        YAxis axisRight = barChart.getAxisRight();
        axisRight.setEnabled(false);

        YAxis axisLeft = barChart.getAxisLeft();
        axisLeft.setEnabled(false);

        XAxis axisTop = barChart.getXAxis();
        axisTop.setDrawGridLines(false);

        Legend legend = barChart.getLegend();
        legend.setEnabled(false);

        barChart.setDescription("");
    }

}
