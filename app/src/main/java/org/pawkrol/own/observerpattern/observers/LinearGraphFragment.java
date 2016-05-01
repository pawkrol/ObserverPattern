package org.pawkrol.own.observerpattern.observers;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.pawkrol.own.observerpattern.R;
import org.pawkrol.own.observerpattern.subjects.DataSubject;
import org.pawkrol.own.observerpattern.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawkrol on 4/30/16.
 */
public class LinearGraphFragment extends ObserverFragment{

    private LineChart lineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.linear_graph_fragment, container, false);
        if (view == null){
            return null;
        }

        lineChart = (LineChart) view.findViewById(R.id.linechart);
        initChart();

        return view;
    }

    @Override
    public void update(Subject subject) {
        if (getView() == null) return;

        prevActiveSubject = subject;

        if (subject instanceof DataSubject) {
            lineChart.setData(
                    getLineData(((DataSubject) subject).getValues())
            );
            lineChart.invalidate();
        }
    }

    private LineData getLineData(List<Float> values){
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();
        int i = 0;

        for (Float f : values){
            entries.add(new Entry(f, i));
            labels.add("" + i++);
        }

        LineDataSet lineDataSet = new LineDataSet(entries, "");
        lineDataSet.setLineWidth(3.f);
        lineDataSet.setColor(Color.argb(255, 51, 161, 143));
        lineDataSet.setValueTextSize(14.f);
        lineDataSet.setCircleColor(Color.argb(255, 51, 161, 143));

        return new LineData(labels, lineDataSet);
    }

    private void initChart(){
        YAxis axisRight = lineChart.getAxisRight();
        axisRight.setEnabled(false);

        YAxis axisLeft = lineChart.getAxisLeft();
        axisLeft.setEnabled(false);

        XAxis axisTop = lineChart.getXAxis();
        axisTop.setDrawGridLines(false);

        Legend legend = lineChart.getLegend();
        legend.setEnabled(false);

        lineChart.setDescription("");
    }

}
